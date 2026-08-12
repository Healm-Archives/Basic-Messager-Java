import { useEffect, useState } from "react";
import api from "../../api/axiosConfig";
import { useAuth } from "../auth/authConfig";
import { useNavigate } from "react-router-dom";
import GroupCreation from "../group/creation/groupCreation";

const Dashboard = () => {

        const { token, username } = useAuth();
        const navigate = useNavigate();
        const [groups, setGroups] = useState([]);

        const getGroups = async () => {
        
                // try {
                //         const response = await api.get("/groups", {
                //                 headers: {
                //                         Authorization: `Bearer ${token}`
                //                 }
                //         });
                        
                //         setGroups(response.data);
                //         console.log(response.data);
                        
                // } 
                
                // catch (error) 
                // {
                //         console.log("eRror" + error);
                // }

                await api.get("/groups", {
                        headers: {
                                Authorization: `Bearer ${token}`
                        }
                })
                .then(res => {
                        setGroups(res.data);
                        console.log(res.data);
                })
                .catch(error => {
                        console.log("eRror" + error);
                });

        };
        
        useEffect(() => {
                if (!username) {
                        navigate("/login");
                        return;
                }
                getGroups();
        }, []);

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
                <GroupCreation />
        </>
        );

}

export default Dashboard