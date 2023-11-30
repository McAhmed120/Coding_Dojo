from flask_app import app
from flask import redirect , render_template , url_for,request
from flask_app.models.dojo_model import Dojo


@app.route("/")
def index():
    return render_template("index.html")


@app.route("/processing", methods=['POST'])
def Processing():
    data= {
        "name":request.form['name'],
        "location":request.form['location'],
        "language":request.form['language'],
        "comment":request.form['comment']}
    if not Dojo.validate(data):
        return redirect('/')
    Dojo.save(data)
    return redirect('/results')


@app.route('/results')
def results():
    user=Dojo.get_last()
    return render_template("results.html", user=user)