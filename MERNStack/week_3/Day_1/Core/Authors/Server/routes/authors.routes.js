const {findAllAuthors,createNewAuthor,findOneAuthorById,updateOneAuthor,deleteOneAuthor}  = require('../controllers/authors.controllers')

module.exports = (app) => {
    app.get('/api/authors', findAllAuthors);
    app.post('/api/authors', createNewAuthor);
    app.get('/api/authors/:id', findOneAuthorById);
    app.put('/api/authors/:id', updateOneAuthor);
    app.delete('/api/authors/:id', deleteOneAuthor);
}