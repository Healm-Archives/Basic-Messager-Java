import React, { useEffect, useState } from "react";
import api from "../../api/axiosConfig";

const Message = () => {

        const [messages, setMessages] = useState([]);
        
        const getMessages = async () => {
        
                // console.log("Get messsage");
                
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
        
        // console.log("messages");
        // console.log(messages);
        
        const message = messages.map((value, index) => {
                                
                return (
                <div key = {"messageId-" + index}>
                        user_{value.userId}: {value.content}
                </div>
                );
        });

        return (
        <>
                {message}
        </>
        );

}

export default Message;
