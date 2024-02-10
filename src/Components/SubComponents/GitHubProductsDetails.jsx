import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom';
import "./ProductsDetails.css"
import Loading from "../Loader/Loading"

function GitHubProductsDetails() {
  let { pid } = useParams()
  let [gitPro, setGitPro] = useState({});
  let [isloading, setIsLoading] = useState(false);

  let getProducts = async () => {
    setIsLoading(true)
    let datas = await axios.get(`https://dummyjson.com/products/${pid}`);
    setGitPro(datas.data);
    setIsLoading(false);
  }
  useEffect(() => {
    getProducts();
  }, [])
  let addToCard = () => {
    console.log(gitPro)
  }
  return (
    <>
      {isloading && <Loading />}
      {isloading || <div className='mainDetailsDiv'>
        <h2>Title : {gitPro.brand}</h2>
        <h3>Category: {gitPro.category}</h3>
        <section>
          <img src={gitPro.thumbnail} alt="noPic" />
          <div>
            <h3>Price: {gitPro.price}</h3>
            <button onClick={addToCard}>Add To Card</button>
          </div>
        </section>
        <h4>Description: {gitPro.description}</h4>
      </div>}
    </>
  )
}

export default GitHubProductsDetails
