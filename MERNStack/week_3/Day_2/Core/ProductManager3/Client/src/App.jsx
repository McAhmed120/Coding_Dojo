import { Routes, Route, Navigate } from 'react-router-dom'
import Home from './components/Home'
import Oneproduct from './components/OneProduct'
import Edit from './components/Edit'

function App() {

  return (
    <>
      <Routes>
        <Route path='/products' element={<Navigate to={'/products'} />} />
        <Route path='/' element={<Home/>}/>
        <Route path='/products/:id' element={<Oneproduct/>}/>
        <Route path='/products/:id/edit' element={<Edit/>}/>
      </Routes>
    </>
  )
}

export default App