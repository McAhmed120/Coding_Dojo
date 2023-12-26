import React from 'react'

const Buttons = ({buttons,setCurrent}) => {
    const clickHandler=(button)=>{
        setCurrent(button)
    }
  return (
    <div>
        {buttons.map((button,idx) => <button key={idx} onClick={()=>clickHandler(button)}>{button}</button>)}
    </div>
  )
}

export default Buttons