import React, { useContext, useState } from 'react'
import { ContextProvider } from "./ProtectedRoute/AuthProvider"
import { useNavigate } from 'react-router-dom'

function LoginPage() {
  document.title = "Login page"
  let [userN, setUserN] = useState("")
  let navigate = useNavigate()
  let { login, islogin } = useContext(ContextProvider);
  let getUserName = ({ target: { value } }) => {
    setUserN(value)
  }
  let sendFormLoginData = (e) => {
    e.preventDefault();
    if (userN === "") {
      alert("Please enter usename and password");
      return false;
    }
    login(userN);
    navigate("/products")
  }
  return (
    <>
      {islogin || <div style={{ textAlign: "center" }}>
        <h1>Login page</h1>
        <form action="" onSubmit={sendFormLoginData}>
          <input type='text' name="fname" onChange={getUserName} placeholder='Enter Name' /><br /><br />
          <input type="password" placeholder='password' /><br /><br />
          <button type='submit'>Login</button>
        </form>
      </div>}
    </>
  )
}

export default LoginPage
