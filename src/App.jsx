import React from 'react'
import { BrowserRouter, Routes, Route } from "react-router-dom"
import FakeProducts from './Components/FakeProducts'
import GitHubProducts from './Components/GitHubProducts'
import Navbar from "./Components/Navbar"
import Home from './Components/Home'
import TotalPro from './Components/TotalPro'
import FakeProductDetails from './Components/SubComponents/FakeProductDetails'
import GitHubProductsDetails from './Components/SubComponents/GitHubProductsDetails'

function App() {
  return (
    <>
      <BrowserRouter>
        <Navbar />
        <Routes>
          <Route path='/' element={<Home />} />
          <Route path='/fakeProducts' element={<FakeProducts />} />
          <Route path='/fakeProducts/:pid' element={<FakeProductDetails />} />

          <Route path='/gitHubProducts' element={<GitHubProducts />} />
          <Route path='/gitHubProducts/:pid' element={<GitHubProductsDetails />} />

          <Route path='/totalPro' element={<TotalPro/>} />
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
