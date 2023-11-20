
from flask import Flask , render_template

app = Flask(__name__)
#http://127.0.0.1
@app.route('/')
def index():
    users =[
    {'name':"John",'age':35},
    {'name':"sarah",'age':35},
    {'name':"alex",'age':35},
    {'name':"amelia",'age':35},
    {'name':"James",'age':35},
    {'name':"Eric",'age':35}]


    return render_template("index.html",users=users)
@app.route('/circles/<color>/<int:number>')
def circles(color,number):
    return render_template("circles.html" , color=color , number=number)
    
if __name__ == "__main__":
    app.run(debug=True , port=5001)
