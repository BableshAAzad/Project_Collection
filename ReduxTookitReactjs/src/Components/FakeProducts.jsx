import axios from 'axios';
import React, { useEffect, useState } from 'react'
import Card from './Cards/Card';
import "./CssComponents/FakeProducts.css"
import { useNavigate } from 'react-router-dom';

function FakeProducts() {
  let [gitPro, setGitPro] = useState([]);
  let navigate = useNavigate()
  let getProducts = async () => {
    let datas = await axios.get("https://fakestoreapi.com/products");
    setGitPro(datas.data);
  }
  useEffect(() => {
    getProducts();
  }, [])
  let detailPage =(id)=>{
    navigate(`/fakeProducts/${id}`)
  }
  return (
    <div className='mainFakePro'>
      {gitPro.map((val) => {
        return (<Card key={val.id} id={val.id} title={val.title}
          imgUrl={val.image} price={val.price}
          desc={val.description} detailPage={detailPage} />)
      })}
    </div>
  )
}
export default FakeProducts
