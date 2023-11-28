from flask_app import app
from flask import redirect,request,render_template, url_for
from flask_app.models.user_model import User

@app.route('/')
def index():
    return redirect('/users')

@app.route('/users')
def users():
    all_users=User.get_all()
    return render_template('read_all.html',all_users=all_users)

@app.route('/users/new')
def create():
    return render_template('create.html')

@app.route('/add', methods=['post'])
def add():
    data={"first_name":request.form['first_name'],"last_name":request.form['last_name'],"email":request.form['email']}
    User.save(data)
    return render_template('create.html')

#  View One
@app.route("/users/<int:id>")
def one_user(id):
    data = {"id": id}
    user = User.get_one_by_id(data)
    return render_template("one_user.html", user=user)


# Update Get 👀 -- Post 📤
@app.route("/users/<int:id>/edit")
def edit(id):
    user_to_edit = User.get_one_by_id({"id": id})
    return render_template("edit_user.html", data=user_to_edit)


@app.route("/edit", methods=["post"])
def update():
    data={"id":request.form['id'], "first_name":request.form['first_name'],"last_name":request.form['last_name'],"email":request.form['email']}
    User.update(data)
    return redirect("/")


@app.route("/users/<int:id>/destroy")
def destroy(id):
    User.delete({"id": id})
    return redirect("/")