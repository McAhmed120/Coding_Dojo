const {findlAllProductManagers,findOneProductManagerById,createNewProductManager}= require('../controllers/product_manager.controller')

module.exports =(app)=>{
    app.get('/api/products', findlAllProductManagers)
    app.post('/api/products', createNewProductManager)
    app.get('/api/products/:id', findOneProductManagerById)
}
