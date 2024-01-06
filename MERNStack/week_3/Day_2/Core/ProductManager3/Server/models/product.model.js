const mongoose = require('mongoose')

const ProductSchema = new mongoose.Schema({
    title:{
        type:String,
        required:[true, "{PATH} is required !"],
        minlength:[3, '{PATH} length must be at least 3 🚫']
    },
    price:{
        type:Number,
        required:[true, "{PATH} is required !"]
    },
    description:{
        type:String,
        required:[true, "{PATH} is required !"],
        minlength:[8, '{PATH} length must be at least 8 🚫']
    }
},{timestamps:true});

const Product = mongoose.model("Product",ProductSchema)
module.exports = Product;