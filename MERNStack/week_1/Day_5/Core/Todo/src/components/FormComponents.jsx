import React from 'react'
import { useState } from 'react'



const FormComponents = ({addPlan}) => 
{
    const [plan,setPlan]=useState({content:"",status:false})
    const formHandler=(e)=>{
        e.preventDefault()
        addPlan(plan)
        setPlan({content:"",status:false})
    }

    return (
        <div>
            <form onSubmit={formHandler}>
                <input type="text" onChange={(e)=> setPlan({...plan ,content:e.target.value})} value={plan.content} />
                <button>Add</button>
            </form>
        </div>
    )
}

export default FormComponents