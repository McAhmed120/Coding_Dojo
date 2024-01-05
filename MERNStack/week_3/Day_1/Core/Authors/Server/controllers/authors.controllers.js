const Author = require('../models/authors.models')
// Create
module.exports.createNewAuthor = (req, res) => {
    Author.create(req.body)
        .then(newCreatedAuthor => {res.status(201).json(newCreatedAuthor);
        console.log(newCreatedAuthor)
        })
        .catch(error => res.status(400).json(error))
}
// Read All
// findAllAuthors
module.exports.findAllAuthors = (req, res) => {
    Author.find({})
        .then(allAuthors =>res.status(200).json(allAuthors))
        .catch(error =>res.status(404).json(error))
}
// Read One
// findOneAuthor
module.exports.findOneAuthorById = (req, res) => {
    Author.findById({ _id: req.params.id })
        .then(oneAuthor =>res.status(200).json(oneAuthor))
        .catch(error =>res.status(500).json(error))
}

// Update
// updateOneAuthor
module.exports.updateOneAuthor = (req, res) => {
    Author.findOneAndUpdate({ _id: req.params.id }, req.body,  {new:true, runValidators:true})
        .then(updatedAuthor =>res.status(200).json(updatedAuthor))
        .catch(error =>res.status(500).json(error))
}
// Delete
// deleteOneAuthor
module.exports.deleteOneAuthor = (req,res) => {
    Author.findByIdAndDelete({_id: req.params.id})
    .then(deletedAuthor =>res.status(200).json(deletedAuthor))
    .catch(error =>res.status(500).json(error))
}