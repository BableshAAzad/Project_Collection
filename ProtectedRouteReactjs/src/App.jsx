import React from 'react'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import NavBar from './Components/NavBar'
import Home from "./Components/Home"
import Services from './Components/Services'
import Products from './Components/Products'
import Information from './Components/Information'
import LoginPage from './Components/LoginPage'
import AuthProvider from './Components/ProtectedRoute/AuthProvider'
import ContextProduct from './Components/ProtectedRoute/ContextProduct'
import ContextService from './Components/ProtectedRoute/ContextService'

function App() {
  return (
    <>
      <BrowserRouter>
        <AuthProvider>
          <NavBar />
          <Routes>
            <Route path='/' element={<Home />} />
            <Route path='/servises' element={
              <ContextService>
                <Services />
              </ContextService>
            } />
            <Route path='/products' element={
              <ContextProduct>
                <Products />
              </ContextProduct>} />
            <Route path='/information' element={<Information />} />
            <Route path='/loginPage' element={<LoginPage />} />
          </Routes>
        </AuthProvider>
      </BrowserRouter>
    </>
  )
}

export default App
