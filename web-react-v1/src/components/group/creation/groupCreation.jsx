import { useState } from "react";
import api from "../../../api/axiosConfig";
import { useAuth } from "../../auth/authConfig";
import "./groupCreation.css";

const GroupCreation = () => {

        const { token } = useAuth();
        const [errorMessage, setErrorMessage] = useState();
        const [createGroup, setCreateGroup] = useState(false);


        const OnCreateGroup = async () => {
                const payload = {
                        name: document.getElementById("groupName").value
                }

                await api.post("/group/create", payload, {
                        headers: {
                                Authorization: `Bearer ${token}`
                        }
                })
                .then(res => {
                        console.log(res);
                        setErrorMessage(res.data.message);
                        setCreateGroup(false);
                })
                .catch(error => {
                        console.log(error.response.data);
                        setErrorMessage(error.response.data.message);
                });
        }

        const toggleCreateGroup = () => {
                setCreateGroup(prev => !prev);
        }

        return (
        <>
                <button onClick={toggleCreateGroup}>Create new group</button>

                <br/>
                
                {
                createGroup && (
                        <div className="floating-panel">

                                <form action = {OnCreateGroup}>
                                        <button onClick={toggleCreateGroup}>Cancel</button>
                                        <br/>
                                        <label htmlFor="groupName">Group name : </label>
                                        <input 
                                                type = "text" 
                                                name = "groupName" 
                                                id = "groupName"
                                                required
                                        />
                                        <br/>
                                        {errorMessage}
                                        <br/>

                                        <input type="submit" id = "submit" name = "submit" />

                                </form>
                        </div>

                )
                }
        </>
        );
}

export default GroupCreation
