import axios from 'axios';
import React, { useEffect, useState } from 'react'
import Card from './Cards/Card';
import "./CssComponents/FakeProducts.css"
import { useNavigate } from 'react-router-dom';
import Loading from "./Loader/Loading"

function FakeProducts() {
  let [gitPro, setGitPro] = useState([]);
  let [isloading, setIsLoading] = useState(false);
  let navigate = useNavigate()
  let getProducts = async () => {
    setIsLoading(true)
    let datas = await axios.get("https://fakestoreapi.com/products");
    setGitPro(datas.data);
    setIsLoading(false);
  }
  useEffect(() => {
    getProducts();
  }, [])
  let detailPage =(id)=>{
    navigate(`/fakeProducts/${id}`)
  }
  return (
    <div className='mainFakePro'>
      {isloading && <Loading />}
      {gitPro.map((val) => {
        return (<Card key={val.id} id={val.id} title={val.title}
          imgUrl={val.image} price={val.price}
          desc={val.description} detailPage={detailPage} />)
      })}
    </div>
  )
}
export default FakeProducts
