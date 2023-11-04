import socket
import json
from predict_sentence_search import *

server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server_socket.bind(("localhost", 8081))
server_socket.listen(5)  # 5 ket noi cung 1 thoi diem
mean = calc_mean()

print("connecting....")
while True:
    client_socket, client_address = server_socket.accept()
    print(f"Đã nhận kết nối từ {client_address}")
    data = client_socket.recv(1024).decode()
    print("data gui ve: " + data)
    lb1 = str(predict_model1(data, mean))
    lb2 = str(predict_model2(data))
    if lb1 == None:
        lb1 = ""
    if lb2 == None:
        lb2 = ""
    data = {"label1": lb1,
            "label2": lb2}
    json_str = json.dumps(data)
    client_socket.send(json_str.encode())

    client_socket.close()
