import { useEffect, useState } from "react";
import api from "../../api/axiosConfig";
import { useAuth } from "../auth/authConfig";
import { useNavigate } from "react-router-dom";

const Dashboard = () => {

        const { token, username } = useAuth();

        const navigate = useNavigate();

        const [groups, setGroups] = useState([]);
        
        const getGroups = async () => {
        
                try {
                        const response = await api.get("/groups", {
                                headers: {
                                        Authorization: `Bearer ${token}`
                                }
                        });
                        
                        setGroups(response.data);
                        console.log(response.data);
                        
                } 
                
                catch (error) 
                {
                        console.log("eRror" + error);
                }
        
        };
        
        useEffect(() => {
                if (!username) {
                        navigate("/login");
                        return;
                }
                getGroups();
        }, []);

        const OnCreateGroup = async () => {
                const payload = {
                        name: document.getElementById("name").value
                }

                await api.post("/group", payload, {
                        headers: {
                                Authorization: `Bearer ${token}`
                        }
                })
                .then(res => {
                        console.log(res);
                        
                }).catch(error => {
                        console.log(error);
                        
                });
        }

        const groupListSection = groups.map(group => {
                return (
                        <>
                                GroupName : {group.name}
                                <br/>
                        </>
                )
        });

        return (
        <>
                Welcome, {username}
                <br/>
                My Group Name: <br/>
                {groupListSection}
                <br/>
                create new group
                <br/>
                <br/>
                <form action = {OnCreateGroup}>
                        <label htmlFor="groupName">Group name : </label>
                        <input 
                                type = "text" 
                                name = "groupName" 
                                id = "name"
                                required
                        />
                        <br/>

                        <input type="submit" id = "submit" name = "submit" />

                </form>
        </>
        );

}

export default Dashboard