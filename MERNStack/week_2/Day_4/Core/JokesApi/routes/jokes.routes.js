const {findAllJokes, createNewJoke, findOneJokeById, updateOneJoke, deleteOneJoke}  = require('../controllers/jokes.controllers')
module.exports = (app) => {
    app.get('/api/jokes', findAllJokes)
    app.post('/api/jokes', createNewJoke)
    app.get('/api/jokes/:id', findOneJokeById)
    app.put('/api/jokes/:id', updateOneJoke)
    app.delete('/api/jokes/:id', deleteOneJoke)
}