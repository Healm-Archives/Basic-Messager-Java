import { useState } from "react";
import api from "../../../api/axiosConfig";
import { useAuth } from "../../auth/authConfig";

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
                <button onClick={toggleCreateGroup}>
                        {createGroup? "Cancel" : "Create new group"}
                </button>

                <br/>
                
                {
                createGroup && (
                        <form action = {OnCreateGroup}>
                                {errorMessage}
                                <br/>
                                <label htmlFor="groupName">Group name : </label>
                                <input 
                                        type = "text" 
                                        name = "groupName" 
                                        id = "groupName"
                                        required
                                />
                                <br/>

                                <input type="submit" id = "submit" name = "submit" />

                        </form>

                )
                }
        </>
        );
}

export default GroupCreation
