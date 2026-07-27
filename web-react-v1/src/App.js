// import logo from './logo.svg';
import './App.css';

import api from './api/axiosConfig';
import { useEffect, useState } from 'react';

import Message from './components/message/message';
import User from './components/user/user';
import Login from './components/login/login';
import Register from './components/register/register';
import { Link, Navigate, Outlet, Route, Routes } from 'react-router-dom';

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

          <Route path = "/login" element = { <Login/> } />

          <Route path = "/register" element = { <Register/> } />

          <Route path = "/home" element = { 
            <h1>Hellow</h1> 
          } />

          <Route path = "*" element = {
            <Navigate to = "/login" replace/>
          }/>

        </Route>

      </Routes>

    </div>
  );

}

export default App;
