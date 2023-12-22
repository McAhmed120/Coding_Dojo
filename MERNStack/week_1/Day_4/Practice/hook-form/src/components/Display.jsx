import React from 'react'

const Display = (props) => {
    return (
        <fieldset>
            <legend>Your Form DATA</legend>
            <h3>Firstname: {props.user.Firstname}</h3>
            <h3>Lastname: {props.user.Lastname}</h3>
            <h3>Email: {props.user.Email}</h3>
            <h3>Password: {props.user.Password}</h3>
            <h3>Confirm Password: {props.user.ConfirmPassword}</h3>
            
        </fieldset>
    )
}

export default Display