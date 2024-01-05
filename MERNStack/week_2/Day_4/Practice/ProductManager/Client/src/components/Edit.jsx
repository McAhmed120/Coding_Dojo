import React from 'react'
import axios from 'axios'
import { useState,useEffect } from 'react'
import { useNavigate,useParams } from 'react-router-dom'
const Edit = () => {
    const{id}=useParams()
    const [title,setTitle]=useState("")
    const [price,setPrice]=useState(0)
    const [description,setDescription]=useState("")
    const navigate = useNavigate()
    const submitHandler=(e)=>{
        e.preventDefault()
        axios.put('http://localhost:8000/api/products/'+id,{title,price,description})
        .then((res)=>{console.log(res);navigate('/')})
        .catch((error)=>{console.log(error)})
    }
    useEffect(()=>{
        axios.get('http://localhost:8000/api/products/'+id)
        .then(res=>{
            setTitle(res.data.title)
            setPrice(res.data.price)
            setDescription(res.data.description)
        })
        .catch(error=>console.log(error))
    },[id])
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
                <button type="submit" className="col-4 btn btn-lg btn-warning mt-3 mb-3">Update</button>
            </form>
        </div>
    )
}

export default Edit