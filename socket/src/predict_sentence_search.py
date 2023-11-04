import tensorflow as tf
import pandas as pd
from pyvi import ViTokenizer, ViPosTagger  # thư viện NLP tiếng Việt
import numpy as np
import gensim  # thư viện NLP

def get_data(arr):
    for i in range(0, len(arr)):
        lines = arr[i]
        lines = gensim.utils.simple_preprocess(lines)
        lines = ' '.join(lines)
        lines = ViTokenizer.tokenize(lines)
        arr[i] = lines
    return arr


def get_data_line(a):
    lines = a
    lines = gensim.utils.simple_preprocess(lines)
    lines = ' '.join(lines)
    lines = ViTokenizer.tokenize(lines)
    return lines


def load_model1():
    model1 = tf.keras.models.load_model('../model/model1_19.h5')
    return model1


def load_model2():
    model2 = tf.keras.models.load_model('../model/model2_9.h5')
    return model2


# load model
model1 = load_model1()
model2 = load_model2()

# load data
train_data = pd.read_excel('../data/train.xlsx')
train_sentences = train_data['sentence'].tolist()
train_sentences = get_data(train_sentences)

test_data = pd.read_excel('../data/test.xlsx')
test_sentences = test_data['sentence'].tolist()
test_sentences = get_data(test_sentences)

tokenizer = tf.keras.preprocessing.text.Tokenizer(filters='!"#$%&()*+,-./:;<=>?@[\\]^`{|}~\t\n')
tokenizer.fit_on_texts(train_sentences)
train_sequences = tokenizer.texts_to_sequences(train_sentences)

max_sequence_length = np.max([len(seq) for seq in train_sequences])


def calc_mean():
    arr_predict_max = []
    for x in test_sentences:
        x = tokenizer.texts_to_sequences([x])
        x = tf.keras.preprocessing.sequence.pad_sequences(x, maxlen=max_sequence_length)
        prediction = model1.predict(x)
        arr_predict_max.append(np.max(prediction))

    mean = np.mean(arr_predict_max)

    return mean


def predict_model1(sentence, mean):
    sentence = get_data_line(sentence)
    sequence = tokenizer.texts_to_sequences([sentence])
    sequence = tf.keras.preprocessing.sequence.pad_sequences(sequence, maxlen=max_sequence_length)
    try:
        x = model1.predict(sequence)
        max_predict = np.max(x)
        if max_predict >= mean: #nếu dự đoán ra trên giá trị trung bình thì trả về nhãn
            return np.argmax(x)
        else:
            return -1
    except:
        print("Câu này không hợp lệ để model1 dự đoán")


def predict_model2(sentence):
    sentence = get_data_line(sentence)
    sequence = tokenizer.texts_to_sequences([sentence])
    sequence = tf.keras.preprocessing.sequence.pad_sequences(sequence, maxlen=max_sequence_length)
    try:
        x = model2.predict(sequence)
        if x[0] >= 0.5:
            return 1
        else:
            return 0
    except:
        print("Câu này không hợp lệ để model2 dự đoán")