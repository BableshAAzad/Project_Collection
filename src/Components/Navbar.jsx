import React, { useEffect, useState } from 'react'
import { NavLink } from 'react-router-dom';
import './CssComponents/Navbar.css'
import { useDispatch, useSelector } from 'react-redux';
import { totalProductsCout } from './Store/Slices/UserSlice';

function Navbar() {
  let dispatch = useDispatch();
  let [tot, setTot] = useState(0)
  let data = useSelector((state) => {
    return state.users;
  })

  useEffect(() => {
    setTot(data.length);
  }, [data]);

  useEffect(() => {
    dispatch(totalProductsCout());
  }, [dispatch]);

  return (
    <section className='navMain'>
      <div className='navHome'>
        <NavLink to="/">Home</NavLink>
      </div>
      <div className='navOption'>
        <NavLink to="/fakeProducts">FakeProducts</NavLink>
        <NavLink to="/gitHubProducts">GitHubProducts</NavLink>
        <NavLink to="/totalPro">Total : {tot}</NavLink>
      </div>
    </section>
  )
}

export default Navbar
