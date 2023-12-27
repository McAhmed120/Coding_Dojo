import { useState } from 'react'
import './App.css'
import axios from 'axios'

function App() {
  const [axiosPokeball, setAxiosPokeball] = useState([])
  const axiosPokemon = () => {
    axios.get("https://pokeapi.co/api/v2/pokemon/?limit=810")
    .then(response => {
      console.log("AXIOS RESPONSE :", response.data)
      setAxiosPokeball(response.data.results)
    })
    .catch(error=> console.log("AXIOS ERROR:", error))
  }
  
  
  return (
    <>
      <fieldset>
        <legend> Axios Pokémon Names</legend>
        <button onClick={axiosPokemon}>Fetch Pokemons</button>
        {axiosPokeball.map(pokemon=> <ul key={pokemon.id}> <li>{pokemon.name}</li> </ul>)}
      </fieldset>
    </>
  )
}

export default App