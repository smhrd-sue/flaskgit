#!/usr/bin/env python
# coding: utf-8

# In[1]:


from flask import Flask, request
import requests
from flask import redirect
import json

app = Flask(__name__) # flask 서버객체 생성
 
# route(경로): 외부에서 접근할 때 페이지 구분을 위한 경로지정
@app.route('/test', methods=['GET','POST'])
def index():
    print(request.method+"방식")
    if request.method == 'GET':
        choice = request.args['choice'] #request.args : URL 쿼리 스트링 안의 키/값 쌍
        userid = request.args['id'] 
    else:
        choice = request.form['choice'] #request.form : HTML POST 폼의 body 안의 키/값 쌍
        userid = request.form['id']
        
    print(userid, choice)
        
    # mbti 예측 로직 구현
    if choice == 'I':
        mbti = 'ISFP'
    else:
        mbti = 'ESFP'

    url = "http://localhost:8081/SpringBoot1/mbti?id={}&choice={}&mbti={}".format(userid, choice, mbti)
    print(url)
    return redirect(url)

    # url = "http://localhost:8081/SpringBoot1/mbti"
    # result = json.dumps({'id' : userid, 'choice' : choice, 'mbti' : mbti})
    # print(result)
    # return requests.post(url, json=result)

    # url = "http://localhost:8081/SpringBoot1/mbti"
    # result = json.dumps({'id' : userid, 'choice' : choice, 'mbti' : mbti})
    # print(result)
    # headers = {'Content-Type': 'application/json'}
    # response = requests.post(url, data=json.dumps(data), headers=headers)
    # return jsonify({"spring_response": response.json()})

    

# main함수의 시작을 의미 
# 비유하자면 자바의 main(String[] args)메소드와 같은 역할
if __name__ == '__main__':
    # 웹서버주소(host)와 포트번호(port)를 지정하여 웹 서버 실행
    app.run(host='13.209.58.50', port='5000') 


# In[ ]:





# In[ ]:




