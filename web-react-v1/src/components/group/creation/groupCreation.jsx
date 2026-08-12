import { useState } from "react";
import api from "../../../api/axiosConfig";
import { useAuth } from "../../auth/authConfig";

const GroupCreation = () => {

        const { token } = useAuth();

        // const [groupName, setGroupName] = useState();
        const [errorMessage, setErrorMessage] = useState();


        const OnCreateGroup = async () => {
                const payload = {
                        name: document.getElementById("groupName").value
                }

                await api.post("/group", payload, {
                        headers: {
                                Authorization: `Bearer ${token}`
                        }
                })
                .then(res => {
                        console.log(res);
                        setErrorMessage(res.data.message);        
                })
                .catch(error => {
                        console.log(error.response.data);
                        setErrorMessage(error.response.data.message);
                });
        }

        return (
                <form action = {OnCreateGroup}>
                        {errorMessage}
                        <br/>
                        <label htmlFor="groupName">Group name : </label>
                        <input 
                                type = "text" 
                                name = "groupName" 
                                id = "groupName"
                                // value = {groupName}
                                // onChange = {}
                                required
                        />
                        <br/>

                        <input type="submit" id = "submit" name = "submit" />

                </form>
        );
}

export default GroupCreation
