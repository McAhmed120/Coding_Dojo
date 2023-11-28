from flask import Flask, render_template, request, redirect

from users import Users

app=Flask(__name__)

@app.route('/')
def index():
    return redirect('/users')


@app.route('/users')
def users():
    return render_template("users.html",users=Users.get_all())


@app.route('/user/new')
def new():
    return render_template("new_user.html")

@app.route('/user/create',methods=['POST'])
def create():
    data={**request.form}
    print(request.form)
    print(Users.save(data))
    return redirect('/users')


if __name__=="__main__":
    app.run(debug=True)