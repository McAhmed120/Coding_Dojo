from flask import Flask, render_template

app = Flask(__name__)

@app.route('/')
def hello():
    return "<h1> hello world </h1> "
# Define a route for /play
@app.route('/play')
def play():
    return render_template('index.html', num_boxes=1, color='aqua')

# Define a route for /play/<x>
@app.route('/play/<int:x>')
def play_x_boxes(x):
    return render_template('index.html', num_boxes=x, color='aqua')

# Define a route for /play/<x>/<color>
@app.route('/play/<int:x>/<color>')
def play_x_colored_boxes(x, color):
    return render_template('index.html', num_boxes=x, color=color)

if __name__ == '__main__':
    app.run(debug=True)
