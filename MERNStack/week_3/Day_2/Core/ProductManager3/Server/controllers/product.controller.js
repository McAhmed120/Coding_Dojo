const Product = require('../models/product.model')

// Create
module.exports.createNewProduct = (req, res) => {
    Product.create(req.body)
        .then(newCreatedProduct => {res.status(201).json(newCreatedProduct)})
        .catch(error => res.status(400).json(error))
}

// findAllProducts
module.exports.findAllProducts = (req, res) => {
    Product.find({})
        .then(allProducts =>res.status(200).json(allProducts))
        .catch(error =>res.status(404).json(error))
}
// findOneProduct
module.exports.findOneProductById = (req, res) => {
    Product.findById({ _id: req.params.id })
        .then(oneProduct =>res.status(200).json(oneProduct))
        .catch(error =>res.status(500).json(error))
}
// updateOneProduct
module.exports.updateOneProduct = (req, res) => {
    Product.findOneAndUpdate({ _id: req.params.id }, req.body,  {new:true, runValidators:true})
        .then(updatedProduct =>res.status(200).json(updatedProduct))
        .catch(error =>res.status(500).json(error))
}
// deleteOneProduct
module.exports.deleteOneProduct = (req,res) => {
    Product.findByIdAndDelete({_id: req.params.id})
    .then(deletedProduct =>res.status(200).json(deletedProduct))
    .catch(error =>res.status(500).json(error))
}