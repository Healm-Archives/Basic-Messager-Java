import { useState } from 'react';
import './App.css';

import { Link, Navigate, Outlet, Route, Routes } from 'react-router-dom';
import Login from './components/login/login';
import Message from './components/message/message';
import Register from './components/register/register';

function App() {

  const NavBar = () => {
    return (
      <div className = "App-section">
        <Link to = "/">Home</Link> |{" "}
        <Link to = "/login">Login</Link> |{" "}
        <Link to = "/register">Register</Link>
        <br/>
      </div>
    );
  }


  return (

    <div className="App">
      <Routes >

        <Route path = "/" element = {
          <>
            <NavBar />
            <div className = "App-section">
              <Outlet />
            </div>
          </>
        }>

          <Route index element = {
            <>                              
                hello
            </>
          } />

          <Route path = "/login" element = { <Login /> } />

          <Route path = "/register" element = { <Register/> } />

          <Route path = "/home" element = { 
            <>
              <h1>Hello authenticated user</h1> 
              <p>Message</p>
              <Message />
            </>
          } />

          <Route path = "*" element = {
            <Navigate to = "/login" replace/>
          }/>

        </Route>

      </Routes>

    </div>

  );

}

export default App
