// import logo from './logo.svg';
import './App.css';

import api from './api/axiosConfig';
import { useEffect, useState } from 'react';
import Message from './components/message/message';
import User from './components/user/user';



function App() {

  return (
    <div className="App">
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
    </div>
  );

}

export default App;
