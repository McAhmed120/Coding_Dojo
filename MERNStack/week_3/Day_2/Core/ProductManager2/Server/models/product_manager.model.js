const mongoose= require('mongoose')

const productManagerSchema =new mongoose.Schema({
    title:{
        type :String,
        required:[true,'title is required'],
        minlength:[4,'title must be 4 at least']
    },
    price:{
        type:Number,
        required:[true, 'price is required'],
        min:[5]
    },
    description:{
        type :String,
        required:[true,'description is required'],
        minlength:[10,'description must be 10 at least']
    }

},{timestamps:true})
const ProductManager=mongoose.model("productManager",productManagerSchema)
module.exports=ProductManager