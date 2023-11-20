from flask import Flask , render_template

app = Flask(__name__)
#http://127.0.0.1
@app.route('/')


@app.route('/circles/<color>/<int:number>')
def square(color,number):
    return render_template("square.html" , color=color , number=number)
    
if __name__ == "__main__":
    app.run(debug=True , port=5001)
