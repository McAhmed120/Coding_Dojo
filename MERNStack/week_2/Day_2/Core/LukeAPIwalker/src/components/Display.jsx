import React, { useState, useEffect } from 'react'
import { useParams, useNavigate } from 'react-router-dom'
import axios from 'axios';
const Display = (props) => {

    const { cat , id } = useParams();
    const [selected, setSelected] = useState(null)
    const navigate = useNavigate()
    const getData = async () => {
        try {
            const result = await axios.get(`https://swapi.dev/api/${cat}/${id}/`)
            console.log(result.data)
            setSelected(result.data)
        }catch(error) {
            navigate('/error')
        }
    }
    useEffect(() => {getData()},[id,cat])
    return (
    <div>
    
        {(selected)&& <div>
        <h1>{selected.name}</h1>
        {(cat==="people")&&<div><h5>Height:{selected.height}</h5><h5>mass:{selected.mass}</h5><h5>Hair Color:{selected.hair_color}</h5></div>}
        {(cat==="starships")&&<div><h5>Model:{selected.model}</h5><h5>manufacturer:{selected.manufacturer}</h5><h5>crew:{selected.crew}</h5></div>}
        {(cat==="planets")&&<div><h5>climate:{selected.climate}</h5><h5>population:{selected.population}</h5><h5>gravity:{selected.gravity}</h5></div>} </div>}

    </div>
    )
}

export default Display