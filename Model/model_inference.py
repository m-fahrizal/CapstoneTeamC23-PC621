try:
    import tensorflow as tf
    import numpy as np
    from tensorflow.keras.layers import Dense
except ImportError:
    print('dependency not installed')

def _sigmoid_prediction(linear_predictions):
    sigmoid = Dense(1, activation='sigmoid', 
                    kernel_initializer='ones', 
                    bias_initializer='zeros')
    X = np.array([[x[0][0] for x in linear_predictions]])
    return sigmoid(X)

def inference(model_paths:list=None,
              data_points:list=None):
    '''fungsi untuk melakukan inference model yang sudah dideploy.
    Parameters :
        model_path : list dari path kedua model (gambar dan tabel)
        data_points: list dari data yang akan diprediksi untuk masing masing model'''
    assert len(model_paths) == len(data_points), 'jumlah models dan data_poin tidak sesuai'
    predictions = []
    for i, path in enumerate(model_paths):
        try:
            model = tf.keras.models.load_model(path)
            pred = model.predict(data_points[i])
            predictions.append(pred)
        except Exception as e:
            print('ERROR |',e)
    
    return _sigmoid_prediction(predictions) >= 0.5
    
if __name__=='__main__':
    prediction = inference(['./csv_model.h5'],
                           [np.array([[0,100,2.5,0,1]]),
                            # np.array([[1,80,2.5,0,1]]),
                            ])
    print('yes' if prediction else 'no')