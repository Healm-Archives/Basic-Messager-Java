import { useEffect, useState } from "react";
import api from "../../api/axiosConfig";
import { useAuth } from "../auth/authConfig";
import { useNavigate } from "react-router-dom";
import GroupCreation from "../group/creation/groupCreation";
import "./dashboard.css";
import GroupJoin from "../group/join/groupJoin";
import GroupLeave from "../group/join/groupLeave";
import GroupSeach from "../group/search/groupSearch";
import GroupEdit from "../group/join/groupEdit";

const Dashboard = () => {

        const { token, username, userUuid } = useAuth();
        const navigate = useNavigate();

        const [groups, setGroups] = useState([]);

        const getGroups = async () => {
                await api.get(`/groups/${userUuid}`, 
                {
                        headers: {
                                Authorization: `Bearer ${token}`
                        }
                })
                .then(res => {
                        setGroups(res.data.groupList);
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
                                {group.groupName}
                                        <GroupJoin group = {group} />
                                        <GroupLeave group = {group} />
                                        <GroupEdit group={group} />
                                <br/>
                        </>
                )
        });

        return (
        <>
                Welcome, {username} <br/>
                Joined Group: <br/>
                {groupListSection} <br/>
                <br/>
                <GroupSeach /> <br/>
                <GroupCreation />
        </>
        );

}

export default Dashboard