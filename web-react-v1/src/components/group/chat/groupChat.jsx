import { useState } from "react";
import api from "../../../api/axiosConfig";
import { useAuth } from "../../auth/authConfig";

const GroupChat = ({group}) => {
        const { token, userUuid } = useAuth();
        
        const [ toggleGroupChat, setToggleGroupChat ] = useState(false);

        const sendChatApi =  async () => {
                                 
                await api.post("/message/send", {
                        content: document.getElementById("chatInput").value,
                        userUuid: userUuid,
                        groupUuid: group.groupUuid,
                        timestamp: new Date().toISOString()
                }, {
                        headers: {
                                Authorization: `Bearer ${token}`
                        }
                })
                .then(res => {

                })
                .catch(error => {
                        console.log(error.response.data);
                        
                });
        }

        const getChatApi = async () => {

                await api.post("/messages/get", {
                        groupUuid: group.groupUuid
                }, {
                        headers: {
                                Authorization: `Bearer ${token}`
                        }
                })
                .then(res => {
                        console.log(res.data);
                        
                })
                .catch(error => {
                        console.log(error.response.data);
                        
                });
        }

        const OnToggleGroupChat = () => {
                setToggleGroupChat(state => !state)
        }

        return (<>
                <button onClick={OnToggleGroupChat}>Chat</button>

                {toggleGroupChat && 
                        <>
                                <form action={sendChatApi}>
                                        <label htmlFor="chatInput">
                                                Type here: 
                                        </label>
                                        <input
                                                id = "chatInput"
                                                name = "chatInput"
                                                type = "text"
                                                required
                                        />
                                        <input
                                                id = "submit"
                                                name = "submit"
                                                type = "submit"
                                        />
                                </form>

                                <button onClick={getChatApi}>Refresh</button>
                        </>
                }
        </>);

}

export default GroupChat
