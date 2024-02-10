import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import axios from 'axios'
import "./ProductsDetails.css"
import Loading from "../Loader/Loading"

function FakeProductDetails() {
    let { pid } = useParams()
    let [gitPro, setGitPro] = useState({});
    let [isloading, setIsLoading] = useState(false);

    let getProducts = async () => {
        setIsLoading(true)
        let datas = await axios.get(`https://fakestoreapi.com/products/${pid}`);
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
                <h2>Title : {gitPro.title}</h2>
                <h3>Category: {gitPro.category}</h3>
                <section>
                    <img src={gitPro.image} alt="noPic" />
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

export default FakeProductDetails
