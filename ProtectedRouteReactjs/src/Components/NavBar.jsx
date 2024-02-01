import React, { useContext } from 'react'
import "./Navbar.css";
import { NavLink } from 'react-router-dom';
import { ContextProvider } from "./ProtectedRoute/AuthProvider"

function NavBar() {
  let { islogin, logout } = useContext(ContextProvider)
  return (
    <nav>
      <div className='logoP'>
        <p>Prodtected Route</p>
      </div>
      <div className='navOptions'>
        <NavLink to="/" >Home</NavLink>
        <NavLink to="/servises" >Servises</NavLink>
        <NavLink to="/products" >Products</NavLink>
        <NavLink to="/information" >Information</NavLink>
        <NavLink className="loginLast" to="/loginPage" >{islogin === null ? "Login" : <button onClick={logout}
          style={{
            fontSize: "1.2rem",
            borderRadius: "0.2rem",
            padding : "0.5rem",
            border : "none",
            backgroundColor:"orange",
            color: "white"
          }}
        >Logout</button>}</NavLink>
      </div>
    </nav>
  )
}

export default NavBar
