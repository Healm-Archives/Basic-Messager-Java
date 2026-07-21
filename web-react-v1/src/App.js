// import logo from './logo.svg';
import './App.css';

import api from './api/axiosConfig';
import { useEffect, useState } from 'react';

function App() {

  const [messages, setMessages] = useState();
  
  const getMessages = async () => {

    try {
      
      // const { response } = await api.get("/messages");
      const response = await api.get("/messages");
      
      // console.log(response);
      // console.log(response.data);
      
      setMessages(response.data);
      
      // console.log(`response = ${response}`);
      // console.log(`response.data = ${response.data}`);
      // console.log(`response.data = ${typeof response.data}`);
      // console.log(`response.data = ${Array.isArray(response.data)}`);


      // response.data

      // const msg = await response.json();

      // console.log(`response = ${msg}`);
      
    } 
    
    catch (error) 
    {
      console.log("eRror" + error);
    }
  
  };
  

  useEffect(() => {
    getMessages();
  }, []);

  const ShowMessage = () => {
    // getMessages();
    // console.log(messages);
    const message = messages?.map((value, index) => {
        console.log(value);
        
        return (
          <div key = {index}>
            {value}
          </div>
        );
    });

    // console.log(messages?.[0]);
    


    return (
      <>
        {message}
      </>
    );
  }

  return (
    <div className="App">
      <ShowMessage/>
    </div>
  );

}

export default App;
