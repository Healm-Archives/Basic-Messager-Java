// import logo from './logo.svg';
import './App.css';

import api from './api/axiosConfig';
import { useEffect, useState } from 'react';

import Message from './components/message/message';
import User from './components/user/user';
import Login from './components/login/login';
import Register from './components/register/register';
import { Navigate, Route, Routes } from 'react-router-dom';

function App() {

  const NavBar = () => {
    return (
      <div className = "App-section">
        <a href = "/">Home</a>
        <br/>
        <a href = "/login">Login</a>
        <br/>
        <a href = "/register">Register</a>
      </div>
    );
  }

  return (
    <div className="App">
      <Routes >

        <Route path = "/" element = {
          <>
            <div className = "App-section">
              <div>
                Select user : 
                <br/>
                <User />
              </div>
            </div>
            
            <div className = "App-section">
              <Message/>
            </div>

            <NavBar />
          </>
        } />

        <Route path = "/login" element = {
          <>
            <NavBar />

            <div className = "App-section">
              <Login/>
            </div>
          </>

        } />

        <Route path = "/register" element = {
          <>
            <NavBar />

            <div className = "App-section">
              <Register/>
            </div>
          </>

        } />

        <Route path = "*" element = {
          <Navigate to = "/login" replace/>

        }/>

      </Routes>

    </div>
  );

}

export default App;
