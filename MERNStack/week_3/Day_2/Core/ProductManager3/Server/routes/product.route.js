const {findAllProducts,createNewProduct,findOneProductById,updateOneProduct,deleteOneProduct}  = require('../controllers/product.controller')

module.exports = (app) => {
    app.get('/api/products', findAllProducts);
    app.post('/api/products', createNewProduct);
    app.get('/api/products/:id', findOneProductById);
    app.put('/api/products/:id', updateOneProduct);
    app.delete('/api/products/:id', deleteOneProduct);
}