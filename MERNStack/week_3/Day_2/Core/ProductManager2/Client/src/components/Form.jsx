import React from 'react'
import axios from 'axios'
import { useState } from 'react'
import { useNavigate } from 'react-router-dom';

const Form = () => {

    const navigate=useNavigate()
    const [product, setProduct] = useState({title: '', price: 0, description: ''});
  const createNewMovie = (e) =>{
    e.preventDefault()
    axios.post('http://localhost:8000/api/products', product)
    .then(response => {
        console.log(response);
        setProduct({title: '', price: 0, description: ''})
        navigate('/')
    })
    .catch(error => console.log(error))
}
  return (
    <form onSubmit={(e) => createNewMovie(e)}>
    <div className="form-group mb-3">
      <label htmlFor=""> Title</label>
      <input
        type="text"
        className="form-control"
        onChange={(e) => setProduct({ ...product, title: e.target.value })}
        value={product.title}
      />
    </div>
    <div className="form-group mb-3">
      <label htmlFor=""> Price</label>
      <input
        type="number"
        className="form-control"
        onChange={(e) =>
          setProduct({ ...product, price: e.target.value })
        }
        value={product.price}
      />
    </div>

    <div className="form-group mb-3">
      <label htmlFor=""> Description</label>
      <input
        type="text"
        className="form-control"
        onChange={(e) =>
          setProduct({ ...product, description: e.target.value })
        }
        value={product.description}
      />
    </div>
    <button className='btn btn-info btn-lg w-50'>Create</button>
  </form>
  )
}

export default Form