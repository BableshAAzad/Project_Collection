import React from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { removeProduct, removeAllProduct, totalProductsCout } from './Store/Slices/UserSlice';

function TotalPro() {
  let dispatch = useDispatch();
  let data = useSelector((state) => {
    return state.users;
  })
  // console.log(data)
  let deleteProduct=(id)=>{
    dispatch(removeProduct(id))
  }
  let deleteAllProducts =()=>{
    dispatch(removeAllProduct())
  }
  return (
    <div>
      <h1>Total Products</h1><br />
      <ol>
        {data.map(({ id, title, price, description, category }) => {
          return <li key={id}>
            <h3>Title : {title}</h3>
            <h4>Category : {category}</h4>
            <h3>Price : {price}</h3>
            <p>Description : {description}</p>
            <button onClick={()=>{deleteProduct(id)}}>Remover to Card</button>
            <br /><br />
            <hr />
          </li>
        })}
      </ol>
      <button onClick={deleteAllProducts}>Delete All Products</button>
    </div>
  )
}

export default TotalPro
