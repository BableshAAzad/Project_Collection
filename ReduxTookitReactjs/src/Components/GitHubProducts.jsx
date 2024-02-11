import axios from "axios";
import { useEffect, useState } from "react";
import Card from './Cards/Card';
import "./CssComponents/FakeProducts.css"
import { useNavigate } from "react-router-dom";
import Loading from "./Loader/Loading"


function GitHubProducts() {
  let [gitPro, setGitPro] = useState([]);
  let navigate = useNavigate()
  let [isloading, setIsLoading] = useState(false);

  let getProducts = async () => {
    setIsLoading(true)
    let datas = await axios.get("https://dummyjson.com/products");
    setGitPro(datas.data.products);
    setIsLoading(false);
  }
  useEffect(() => {
    getProducts();
  }, [])
  let detailPage = (id) => {
    navigate(`/gitHubProducts/${id}`)
  }
  return (
    <div className='mainFakePro'>
      {isloading && <Loading />}
      {gitPro.map((val) => {
        return <Card key={val.id} id={val.id} title={val.category}
          imgUrl={val.thumbnail} price={val.price}
          desc={val.description} detailPage={detailPage} />
      })}
    </div>
  )
}

export default GitHubProducts
