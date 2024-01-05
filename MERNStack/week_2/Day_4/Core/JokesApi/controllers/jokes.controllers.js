const Joke = require('../models/jokes.models')

// Read All
// findAllJokes
module.exports.findAllJokes = (req, res) => {
    Joke.find()
        .then(allJokes => {
            console.log("All Jokes From DB", allJokes);
            res.status(200).json({ data: allJokes, message: 'All Jokes List', ok: true })
        })
        .catch(error => {
            console.log(error);
            res.status(404).json({ error })
        })
}
// Read One
// findOneJoke
module.exports.findOneJokeById = (req, res) => {
    Joke.findById({ _id: req.params.id })
        .then(oneJoke => {
            console.log("Joke Found", oneJoke);
            if(!oneJoke) {
                res.status(404).json({ error:"Joke Not Found", ok:false })
            }else{
                res.status(200).json({ data: oneJoke, message: 'Joke Found', ok: true })
            }
        })
        .catch(error => {
            console.log(error);
            res.status(500).json({ error })
        })
    }
// Create
module.exports.createNewJoke = (req, res) => {
    Joke.create(req.body)
        .then(newCreatedJoke => {
            console.log("New  Joke", newCreatedJoke);
            res.status(201).json({ data: newCreatedJoke, message: 'Joke Created with success', ok: true })
        })
        .catch(error => {
            console.log(error);
            res.status(404).json({ error })
        })
}
// Update
// updateOneJoke
module.exports.updateOneJoke = (req, res) => {
    Joke.findOneAndUpdate({ _id: req.params.id }, req.body,  {new:true, runValidators:true})
        .then(updatedJoke => {
            console.log("Joke To Update", updatedJoke);
            res.status(200).json({ data: updatedJoke, message: 'Joke Updated with success', ok: true })

        })
        .catch(error => {
            console.log(error);
            res.status(500).json({ error })
        })
}
// Delete
// deleteOneJoke
module.exports.deleteOneJoke = (req,res) => {
    Joke.findByIdAndDelete({_id: req.params.id})
    .then(deletedJoke => {
        console.log("Deleted Joke", deletedJoke);
        res.status(200).json({ data: deletedJoke, message: 'Joke deleted with success', ok: true })
    })
    .catch(error => {
        console.log(error);
        res.status(500).json({ error })
    })
}