try:
    import tensorflow as tf
    import numpy as np
    from tensorflow.keras.layers import Dense
except ImportError:
    print('dependency not installed')

def _sigmoid_prediction(outImageModel, outTabularModel):
    sigmoid = Dense(1, activation='sigmoid', 
                    kernel_initializer='ones', 
                    bias_initializer='zeros')
    X = np.array([[outImageModel[0][0],outTabularModel[0][0]]])
    return sigmoid(X)

def inference(model_paths:list=None,
              data_points:list=None):
    '''fungsi untuk melakukan inference model yang sudah dideploy.
    Parameters :
        model_path : list dari path kedua model (gambar dan tabel)
        data_points: list dari data yang akan diprediksi untuk masing masing model'''
    models = []
    for path in model_paths:
        try:
            model = tf.keras.models.load_model(path)
            models.append(model)
        except:
            print(f'model not found in {path}')
    predictions = []
    for data, model in zip(data_points, models):
        pred = model.predict(data)
        predictions.append(pred)
    
    return _sigmoid_prediction(predictions[0],predictions[1])
    
if __name__=='__main__':
    prediction = inference(['../test.h5','../test.h5'],
                           np.array([[[1,2,3]],[[4,5,6]]]))
    print(prediction)