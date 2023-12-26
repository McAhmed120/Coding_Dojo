import { useState } from 'react'
import './App.css'
import Buttons from './components/Buttons'
import Display from './components/Display'

function App() {
  const [buttons, setButton] = useState(["Tab1","Tab2","Tab3"])
  const [current, setCurrent] = useState("")

  return (
    < >
      <Buttons buttons={buttons} setCurrent={setCurrent}/>
      <Display current={current}/>
    </>
  )
}

export default App