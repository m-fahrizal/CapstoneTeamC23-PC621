try:
    import tensorflow as tf
    import numpy as np
    from tensorflow.keras.layers import Dense
    from tensorflow.keras.utils import load_img, img_to_array
except ImportError:
    raise ImportError

def sigmoid_prediction(linear_predictions):
    sigmoid = Dense(1, activation='sigmoid', 
                    kernel_initializer='ones', 
                    bias_initializer='zeros')
    X = np.array([[x[0][0] for x in linear_predictions]])
    return sigmoid(X)

def process_image(img_path,target_size=(224, 224)):
    img = load_img(img_path, target_size=target_size)
    img = img_to_array(img) / 255
    img = np.expand_dims(img,0)

    return img
def inference(model_paths:list=None,
              data_points:list=None):
    '''
    fungsi untuk melakukan inference model yang sudah dideploy.
    Parameters :
        model_path : list dari path kedua model (gambar dan tabel)
        data_points: list dari data yang akan diprediksi untuk masing masing model
    Contoh Penggunaan :
    
    >> prediction , confidence = inference(['./csv_model.h5'],
                                           [np.array([[0,100,2.5,0,1]]),])
    >> print(prediction)\n
    Not Eligible
    '''
    

    assert len(model_paths) == len(data_points), 'jumlah models dan data_poin tidak sesuai'
    predictions = []
    for i, path in enumerate(model_paths):
        try:
            model = tf.keras.models.load_model(path)
            pred = model.predict(data_points[i])
            predictions.append(pred)
        except Exception as e:
            print('ERROR |',e)
    confidence = sigmoid_prediction(predictions)
    prediction = 'Eligible' if confidence >= 0.5 else 'Not Eligible'
    return prediction, confidence[0][0].numpy()
    
# contoh penggunaan
if __name__=='__main__':
    prediction , confidence = inference(['./csv_model.h5','./image_model.h5'],
                                        [np.array([[0,90,5,0,2]]), # kolom : [prestasi, nilai ujian, gaji ortu, punya kip SMA, status rumah]
                                         process_image('../test.png')])
    print(prediction,f', {round(confidence*100,2)}% confidence')