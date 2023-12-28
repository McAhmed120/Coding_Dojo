import React,{useState} from 'react'
import { useNavigate } from 'react-router-dom'
const Form = () => {
    const navigate = useNavigate();
    const [id, setId] = useState(0)
    const [cat, setCat] = useState("")
    const search = (e) => {
        e.preventDefault()
        console.log("ID :", id);
        console.log("category :", cat);
        navigate(`/${cat}/${id}`)
    }
    return (
        <div className='row'>
            <form className='d-flex justify-content-center align-items-center gap-5' onSubmit={(e)=>search(e)}>
                <div className="d-flex justify-content-center align-items-center gap-3">
                    <label htmlFor="cat" className='h4'>Search for:</label>
                    <select className="form-select" id="cat" onChange={(e)=>{setCat(e.target.value)}}>
                        <option value="people" selected>people</option>
                        <option value="planets">planets</option>
                        <option value="starships">starships</option>
                    </select>
                </div>
                <div className="d-flex justify-content-center align-items-center gap-3">
                    <label htmlFor="id" className='h4'>ID:</label>
                    <input type="number" className='form-control' id='id' 
                    onChange={(e)=>{setId(e.target.value)}} value={id} />
                </div>
                <div className="d-flex justify-content-center align-items-center gap-3">
                    <button className='btn btn-secondary btn-lg'>Search</button>
                </div>
            </form>
        </div>
    )
}


export default Form