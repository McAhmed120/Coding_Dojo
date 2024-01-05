const mongoose = require('mongoose')

const JokeSchema = new mongoose.Schema({
    setup:{
        type:String,
        required:[true, "setup is required !"],
        minlength:[10, '{PATH} length must be at least 10 🚫🚫🚫🚫']
    },
    punchline:{
        type:String,
        required:[true, "punchline is required !"],
        minlength:[3, '{PATH} length must be at least 3 🚫🚫🚫🚫']
    }
},{timestamps:true})

const Joke = mongoose.model("Joke",JokeSchema)
module.exports = Joke;