import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import axios from 'axios'
import "./ProductsDetails.css"

function FakeProductDetails() {
    let { pid } = useParams()
    let [gitPro, setGitPro] = useState({});
    let getProducts = async () => {
        let datas = await axios.get(`https://fakestoreapi.com/products/${pid}`);
        setGitPro(datas.data);
    }
    useEffect(() => {
        getProducts();
    }, [])
    console.log(gitPro)
    return (
        <div className='mainDetailsDiv'>
            <h2>Title : {gitPro.title}</h2>
            <h3>Category: {gitPro.category}</h3>
            <section>
                <img src={gitPro.image} alt="noPic" />
                <div>
                    <h3>Price: {gitPro.price}</h3>
                    <button>Add To Card</button>
                </div>
            </section>
            <h4>Description: {gitPro.description}</h4>
        </div>
    )
}

export default FakeProductDetails
