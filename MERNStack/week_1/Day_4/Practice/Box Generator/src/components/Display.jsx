import React from 'react'

const Display = (props) => {
    console.log(props.colors)
    return (
        <fieldset style={{backgroundColor:props.colors}}>
            <legend>{props.colors}</legend>
        </fieldset>    
        )
}

export default Display