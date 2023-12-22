import React from 'react'
import { useState } from 'react'
import Display from './Display'

const UserForm = (props) => {
    const [user,setUser] = useState({Firstname:"",Lastname:"",Email:"",Password:"",ConfirmPassword:""})
    
    const addUser = (e) => {
        e.preventDefault()
        console.log(user);
        setUser({Firstname:"",Lastname:"",Email:"",Password:"",ConfirmPassword:""})
    }
    return(
        <fieldset>
            <form onSubmit={(e)=> addUser(e)}>
                <div>
                    <label>Firstname: </label> 
                    <input type="text" onChange={ (e) => setUser({...user, Firstname:e.target.value })} value={user.Firstname} />
                </div>
                <div>
                    <label>Lastname: </label> 
                    <input type="text" onChange={ (e) =>setUser({...user, Lastname:e.target.value })} value={user.Lastname} />
                </div>
                <div>
                    <label>Email Adr:</label> 
                    <input type="text" onChange={ (e) =>setUser({...user, Email:e.target.value })} value={user.Email}/>
                </div>
                <div>
                    <label>Password: </label>
                    <input type="password" onChange={ (e) =>setUser({...user, Password:e.target.value })} value={user.Password}/>
                </div>
                <div>
                    <label> Confirm Password: </label>
                    <input type="password" onChange={ (e) =>setUser({...user, ConfirmPassword:e.target.value })} value={user.ConfirmPassword}/>
                </div>
                <br />
            </form>
            <br />
            <Display user={user} />
        </fieldset>
        );
}
export default UserForm