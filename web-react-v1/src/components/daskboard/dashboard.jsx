import { useEffect, useState } from "react";
import api from "../../api/axiosConfig";
import { useAuth } from "../auth/authConfig";
import { useNavigate } from "react-router-dom";
import GroupCreation from "../group/creation/groupCreation";
import "./dashboard.css";

const Dashboard = () => {

        const { token, username, userUuid } = useAuth();
        const navigate = useNavigate();

        const [groups, setGroups] = useState([]);
        const [searchGroups, setSearchGroups] = useState(false);

        const getGroups = async () => {
                await api.get(`/groups/${userUuid}`, 
                {
                        headers: {
                                Authorization: `Bearer ${token}`
                        }
                })
                .then(res => {
                        setGroups(res.data.groupList);
                        // console.log(res.data);
                })
                .catch(error => {
                        console.log("eRror" + error);
                });

        };

        const searchGroupsApi = async () => {
                const groupName = document.getElementById("groupSearchName").value;
                console.log(groupName);
                

                await api.get(`/groups/search`, 
                {
                        params: {
                                groupName: groupName
                        },
                        headers: {
                                Authorization: `Bearer ${token}`
                        }
                })
                .then(res => {
                        setGroups(res.data.groupList);
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
                                {group.name} <JoinGroup group = {group}/>
                                <br/>
                        </>
                )
        });

        const groupSearchToggle = () => {
                setSearchGroups(state => !state);
        }

        const GroupSearchBar = () => {
                return (<>
                        <button onClick={groupSearchToggle}>Search</button>
                        <br/>
                        
                        {searchGroups && 
                                <div  className="floating-panel">
                                        <button onClick={groupSearchToggle}>Cancel</button>
                                        <br/>
                                        <label htmlFor="groupSearchName">Group Name:</label>
                                        <input 
                                                id="groupSearchName"
                                                name="groupSearchName"
                                                type="text"
                                                required
                                        />
                                        <br/>
                                        <button onClick={() => searchGroupsApi()} >
                                                Search group: 
                                        </button>
                                </div>
                                
                        }
                </>);

        }

        return (
        <>
                Welcome, {username} <br/>
                {/* My Group Name: <br/> */}
                Joined Group: <br/>
                {groupListSection} <br/>
                <br/>
                <GroupSearchBar /> <br/>
                <GroupCreation />
        </>
        );

}

export default Dashboard