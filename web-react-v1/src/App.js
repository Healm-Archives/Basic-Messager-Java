// import logo from './logo.svg';
import './App.css';

import api from './api/axiosConfig';
import { useEffect, useState } from 'react';
import Message from './components/message/message';
function App() {

  const [messages, setMessages] = useState([]);
  
  const getMessages = async () => {
    
    console.log("Get messsage");
    
    try {

      const response = await api.get("/messages");
      
      setMessages(response.data);
    
    } 
    
    catch (error) 
    {
      console.log("eRror" + error);
    }
  
  };
  
  useEffect(() => {
    getMessages();
  }, []);

  return (
    <div className="App">
      <Message messages = {messages}/>
    </div>
  );

}

export default App;
