import React from 'react';

const PersonCard = (props) => {
    const { person }=props
    return(
        <fieldset>
            <h1>{person.lastname},{person.firstname}</h1>
            <h3>Age:{person.age}</h3>
            <h3>Hair Color: {person.haircolor}</h3>
        </fieldset>
    );
}
export default PersonCard;