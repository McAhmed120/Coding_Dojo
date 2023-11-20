from doctest import debug
import html
from flask import Flask , render_template

app = Flask(__name__)

#http://127.0.0.1
@app.route('/')
def index():
    return render_template("index.html")

if __name__ == "__main__":
    app.run(debug=True, port=5001)