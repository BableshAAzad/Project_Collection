import React from 'react'
import { NavLink } from 'react-router-dom';
import './CssComponents/Navbar.css'

function Navbar() {
  return (
    <section className='navMain'>
      <div className='navHome'>
        <NavLink to="/">Home</NavLink>
      </div>
      <div className='navOption'>
        <NavLink to="/fakeProducts">FakeProducts</NavLink>
        <NavLink to="/gitHubProducts">gitHubProducts</NavLink>
        <NavLink to="/totalPro">Total</NavLink>
      </div>
    </section>
  )
}

export default Navbar
