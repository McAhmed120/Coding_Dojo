from flask_app import app
from flask import redirect,request,render_template,url_for
from flask_app.models.books_model import Books
from flask_app.models.authors_model import Authors


@app.route('/books')
def books():
    all_books=Books.get_all()
    return render_template('/books.html',all_books=all_books)

@app.route('/create/book',methods=["post"])
def create_book():
    data={"title":request.form['title'],"num_of_pages":request.form['num_of_pages']}
    Books.save(data)
    return redirect('/books')


@app.route('/books/<int:id>')
def book_details(id):
    data= {
        "id":id
    }
    return render_template('one_book.html',book=Books.get_one_by_id(data),favauthors=Books.get_by_favorite_id(data),all_authors=Authors.get_all())

@app.route('/favoritebook/add',methods=["post"])
def favorite_book():
    print(f"========>{request.form}")
    data={"book_id":request.form['book_id'],"author_id":request.form['author_id']}
    Books.fav(data)
    return redirect(url_for('book_details',id=data['book_id']))