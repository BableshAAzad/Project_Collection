import React from 'react';
import "./Card.css"

function Card({id, title, imgUrl, price, desc, detailPage}) {
    return (
        <div className='mainCardDiv'>
            <h3>Title: {title.slice(0, 17)}</h3>
            <img src={imgUrl} alt='noPicHere' />
            <h4>Price: {price}</h4>
            <p>Desc: {desc.slice(0, 50)}</p>
            <button className='seeDetailsBtn' onClick={()=>detailPage(id)}>See Details</button>
        </div>
    )
}

export default Card
