import { useState } from 'react'
import './App.css'
import { Navigate, Route, Routes } from 'react-router-dom'
import Home from './pages/Home'
import Product from './components/Product'

function App() {
  const [count, setCount] = useState(0)
  

  return (
    <>
    <Routes>
      <Route path='/' element={<Navigate to='/products' />}/>
    {/* home route : http://localhost:5173/products */}
     
     <Route path='/products' element={<Home/>}/>

    {/* <Route path='/products' element={<Product/>}/> */}



    {/* view product route : http://localhost:5173/products/:id */}

    <Route path='/products/:id' element={<Product/>}/> 
    <Route path='*' element={<Navigate to='/products' />}/>

    </Routes>
      </>
  )
}

export default App