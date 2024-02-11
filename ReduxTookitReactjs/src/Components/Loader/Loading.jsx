import React from 'react'
import "./Loading.css"
import pic from "./LinearDNA.gif";

function Loading() {
  return (
    <div className='loadingMain'>
      <img src={pic} alt='Loading....' />
    </div>
  )
}

export default Loading
