import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom';
import "./ProductsDetails.css"

function GitHubProductsDetails() {
  let { pid } = useParams()
  let [gitPro, setGitPro] = useState({});
  let getProducts = async () => {
    let datas = await axios.get(`https://dummyjson.com/products/${pid}`);
    setGitPro(datas.data);
  }
  useEffect(() => {
    getProducts();
  }, [])
  console.log(gitPro)
  return (
    <div className='mainDetailsDiv'>
      <h2>Title : {gitPro.brand}</h2>
            <h3>Category: {gitPro.category}</h3>
            <section>
                <img src={gitPro.thumbnail} alt="noPic" />
                <div>
                    <h3>Price: {gitPro.price}</h3>
                    <button>Add To Card</button>
                </div>
            </section>
            <h4>Description: {gitPro.description}</h4>
    </div>
  )
}

export default GitHubProductsDetails
