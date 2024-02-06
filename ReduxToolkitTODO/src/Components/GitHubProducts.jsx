import axios from "axios";
import { useEffect, useState } from "react";
import Card from './Cards/Card';
import "./CssComponents/FakeProducts.css"
import { useNavigate } from "react-router-dom";

function GitHubProducts() {
  let [gitPro, setGitPro] = useState([]);
  let navigate = useNavigate()
    let getProducts = async () => {
        let datas = await axios.get("https://dummyjson.com/products");
        setGitPro(datas.data.products);
      }
      useEffect(()=>{
        getProducts();
      },[])
      let detailPage =(id)=>{
        navigate(`/gitHubProducts/${id}`)
      }
  return (
    <div className='mainFakePro'>
      {gitPro.map((val) => {
        return <Card key={val.id} id={val.id} title={val.category}
          imgUrl={val.thumbnail} price={val.price}
          desc={val.description} detailPage={detailPage} />
      })}
    </div>
  )
}

export default GitHubProducts
