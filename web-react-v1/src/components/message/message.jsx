import { useEffect, useState } from "react";
import api from "../../api/axiosConfig";
import { useAuth } from "../auth/authConfig";

const Message = () => {

        const { token } = useAuth();

        const [messages, setMessages] = useState([]);
        
        const getMessages = async () => {
        
                // console.log("Get messsage");
                
                try {

                        // const response = await api.get("/messages");
                        // console.log("Jwt token : " + jwtToken);
                        
                        // const response = await api.get("/messages", {
                        const response = await api.get("/users", {
                                headers: {
                                        Authorization: `Bearer ${token}`
                                }
                        });
                        
                        setMessages(response.data);
                        console.log(response.data);
                        
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

export default Message