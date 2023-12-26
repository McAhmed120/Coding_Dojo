import React, { useState } from 'react'
import Display from './Display'
const Color = () => {
    const [colors,setColors]=useState(["antiquewhite","aliceblue","teal"])
    const [color,setColor]=useState("")
    const formHandler = (event) => {
        event.preventDefault() 
        colors.push(color)
        setColor("")
    }
    return (
    <>
    <fieldset>
    <legend>Form</legend>
        <form onSubmit={(event) => formHandler(event)}>
            <label>Color </label>
            <input type="text" onChange={ (e) => setColor(e.target.value )} />
            <button> Add </button>
        </form>
    </fieldset>
    <fieldset>
        <legend>Box View</legend>
        {colors.map((colors,idx) => <Display key={idx} colors={colors}/> )}
    </fieldset>
    </>
    
    )
}

export default Color