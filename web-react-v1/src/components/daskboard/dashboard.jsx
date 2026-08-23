import { useEffect, useState } from "react";
import api from "../../api/axiosConfig";
import { useAuth } from "../auth/authConfig";
import { useNavigate } from "react-router-dom";
import GroupCreation from "../group/creation/groupCreation";

const Dashboard = () => {

        const { token, username, userUuid } = useAuth();
        const navigate = useNavigate();

        const [groups, setGroups] = useState([]);

        const getGroups = async () => {
                await api.get("/groups", {
                        headers: {
                                Authorization: `Bearer ${token}`
                        }
                })
                .then(res => {
                        setGroups(res.data);
                        // console.log(res.data);
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


        const joinGroupApi = async (group) => {
                await api.post(`/group/join/${group.groupUuid}`, 
                {
                        userUuid: userUuid
                }, 
                {
                        headers: {
                                Authorization: `Bearer ${token}`
                        }
                })
                .then(res => {
                        // console.log(res);
                })
                .catch(error => {
                        console.log("eRror " + error);
                });
        }

        const leaveGroupApi = async (group) => {
                await api.post(`/group/leave/${group.groupUuid}`,
                {
                        userUuid: userUuid
                },
                {
                        headers: {
                                Authorization: `Bearer ${token}`
                        }
                })
                .then(res => {
                        // console.log(res);
                })
                .catch(error => {
                        console.log("eRror " + error);
                });
        }

        const JoinGroup = ({group}) => {
                return (
                        <>
                                <button onClick={() => joinGroupApi(group)}>Join Group</button>
                                <button onClick={() => leaveGroupApi(group)}>Leave Group</button>
                        </>
                );
        }

        const groupListSection = groups.map(group => {
                return (
                        <>
                                GroupName : {group.name} <JoinGroup group = {group}/>
                                <br/>
                        </>
                )
        });

        return (
        <>
                Welcome, {username}
                <br/>
                {/* My Group Name: <br/> */}
                {groupListSection}
                <br/>
                <GroupCreation />
        </>
        );

}

export default Dashboard