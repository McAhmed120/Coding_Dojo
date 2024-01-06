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
    };
        // get all products from db
    useEffect(() => {
        axios
        .get("http://localhost:8000/api/products")
        .then((allProducts) => setProducts(allProducts.data))
        .catch((err) => console.log(err));


    }, []);

        // delete the clicked on product from db
    const onDeleteProduct = (id) => {
        axios
        .delete(`http://localhost:8000/api/product/${id}`)
        .then((res) => {
            console.log(res);
            const filteredProduct = products.filter((eachProduct) => {
            return eachProduct._id !== id;
            });
            setProducts(filteredProduct);
        })
        .catch((err) => console.log(err));
    };
   
   
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
                {products.map((oneProduct) => (
                    <div key={oneProduct._id}>
                        <Link to={`/products/${oneProduct._id}`}>
                        <h2>{oneProduct.title}</h2>
                        </Link>
                        <div>
                            <Link className="btn btn-primary" to={`/products/${oneProduct._id}/edit`}>Edit</Link>
                            <button onClick={()=>onDeleteProduct(oneProduct._id)} className="btn btn-danger">Delete</button>
                        </div>
                    </div>
                   
                    ))}
                </ul>
            </div>
        </div>
    )
}

export default Home