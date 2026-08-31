import { useState } from "react";
import api from "../../../api/axiosConfig";
import { useAuth } from "../../auth/authConfig";

const GroupChat = ({group}) => {
        const { token, userUuid } = useAuth();
        
        const [ toggleGroupChat, setToggleGroupChat ] = useState(false);

        const sendChatApi =  async () => {                
                await api.post("message", {
                        content: document.getElementById("chatInput").value,
                        userUuid: userUuid,
                        groupUuid: group.groupUuid,
                        timestamp: Date.now()
                },
                {
                        headers: {
                                Authorization: `Bearer ${token}`
                        }
                });
        }

        const OnToggleGroupChat = () => {
                setToggleGroupChat(state => !state)
        }

        return (<>
                <button onClick={OnToggleGroupChat}>Chat</button>

                {toggleGroupChat && 
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
                }
        </>);

}

export default GroupChat
