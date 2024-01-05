import React from 'react'
import axios from 'axios'
import { useState, useEffect } from 'react'
import { useNavigate, useParams } from 'react-router-dom'

const Oneproduct = () => {
    const { id } = useParams()
    const [product, setProduct] = useState({})
    const navigate = useNavigate()
    useEffect(() => {
        axios.get('http://localhost:8000/api/products/' + id)
            .then(res => { setProduct(res.data) })
            .catch(error => console.log(error))
    }, []);
    const deleteObj=(id)=>{
        axios.delete(`http://localhost:8000/api/products/${id}`)
        .then(res=>navigate('/'))
        .catch(error=>console.log(error))
    }
    return (
        <div className='container'>
            <div className="card m-5 shadow" style={{ width: "30rem" }}>
                <div className="card-body">
                    <h1 className="card-title">{product.title}</h1>
                    <h4 className="card-subtitle mb-2 text-muted">Price: {product.price} $</h4>
                    <p className="h5 card-text">Description: {product.description}</p>
                    <button className="btn btn-dark w-25 m-3" onClick={()=>navigate('/')}>Home</button>
                    <button className='btn w-25 btn-danger'onClick={()=>deleteObj(product._id)}>Delete</button>
                </div>
            </div>
        </div>
    )
}

export default Oneproduct