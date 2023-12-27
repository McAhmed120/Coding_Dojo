import { useState } from 'react'
import './App.css'

function App() {
  const [pokeball, setPokeball] = useState([])
  const fetchAPI = () => {
    fetch("https://pokeapi.co/api/v2/pokemon/?limit=810")
      .then(response => {
        console.log("RESPONSE :", response);
        return response.json()
      })
      .then(response => {
        console.log("FETCH API RESPONSE AS JSON : ", response)
        setPokeball(response.results)
      })
      .catch(error => console.log("FETCH API ERROR :", error))}
  
  return (
    <>
      <fieldset>
        <legend>Pokémon Names</legend>
        <button onClick={fetchAPI}>Fetch Pokemons</button>
        {pokeball.map(pokemon=> <ul key={pokemon.id}> <li>{pokemon.name}</li> </ul>)}
      </fieldset>
    </>
  )
}

export default App
