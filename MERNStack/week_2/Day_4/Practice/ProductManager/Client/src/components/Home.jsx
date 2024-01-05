import React from 'react'
import axios from 'axios'
import { useState,useEffect } from 'react'
import { useNavigate,Link } from 'react-router-dom'

const Home = () => {
    const [products,setProducts]=useState([])
    const [title,setTitle]=useState("")
    const [price,setPrice]=useState(0)
    const [description,setDescription]=useState("")
    const navigate = useNavigate()
    const submitHandler=(e)=>{
        e.preventDefault()
        axios.post('http://localhost:8000/api/products',{title,price,description})
        .then((res)=>{console.log(res);navigate('/')})
        .catch((error)=>{console.log(error)})
    }
    useEffect(()=>{
        axios.get(`http://localhost:8000/api/products`)
        .then(res=>{setProducts(res.data)})
        .catch(error=>console.log(error))
    },[])
    const deleteRedirect=(id)=>{
        axios.delete(`http://localhost:8000/api/products/${id}`)
        .then(res=>navigate('/'))
        .catch(error=>console.log(error))
    }
    return (
        <div className="container">
            <form className='border shadow p-4 m-5' onSubmit={submitHandler}>
                <h1 className='text-center m-3'>Product Manager</h1>
                <div className="form-group">
                    <label htmlFor="InputTitle">Title:</label>
                    <input type="text" className="form-control" id="InputTitle" value={title} onChange={(e)=>setTitle(e.target.value)}/>
                </div>
                <div className="form-group">
                    <label htmlFor="InputPrice">Price:</label>
                    <input type="number" className="form-control" id="InputPrice" value={price} onChange={(e)=>setPrice(e.target.value)}/>
                </div>
                <div className="form-group">
                    <label htmlFor="InputDescription">Description:</label>
                    <input type="text" className="form-control" id="InputDescription" value={description} onChange={(e)=>setDescription(e.target.value)}/>
                </div>
                <button type="submit" className="col-4 btn btn-lg btn-info mt-3 mb-3">Submit</button>
            </form>
            <div className='border shadow p-4 m-5'>
                <h1 className='text-center m-3'>All Products</h1>
                <ul className="list-group list-group-flush">
                {products.map(c=>(
                    <li className="h4 list-group-item d-flex justify-content-between"><Link to={`/products/${c._id}`}>{c.title}</Link><div><button className='btn btn-danger'onClick={()=>deleteRedirect(c._id)}>Delete</button><button className='btn btn-warning m-2'onClick={()=>navigate(`/products/${c._id}/edit`)}>Edit</button></div></li>
                ))}
                </ul>
            </div>
        </div>
    )
}

export default Home