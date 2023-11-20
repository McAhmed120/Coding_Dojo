
from flask import Flask, render_template  # Import Flask to allow us to create our app
app = Flask(__name__)    # Create a new instance of the Flask class called "app"

@app.route('/')
def hello_world():
    return "hello world"
    # The "@" decorator associates this route with the function immediately following

@app.route('\hello')
def hello():
    return "hello from server"

@app.route('\hello\usr')
def say_hello():
    return  "<h1>Hello james </h1>"

@app.route('/hello/user/<username/<int:times>')
def say_hello_username(username):
    return f"<h1> hello{username} </h1>" * times

@app.route('/hello/user/<username/<int:age>')
def user_info(username, age):
    return f"<h1>USERNAME :{username}<br/> AGE :{age}</h1>"

@app.route('/index')
def user_info():
    return render_template("index.html")

def hello_world():
    return 'Hello World!'  # Return the string 'Hello World!' as a response

if __name__=="main":   # Ensure this file is being run directly and not from a different module
    app.run(debug=True ,port=1377)    # Run the app in debug mode.