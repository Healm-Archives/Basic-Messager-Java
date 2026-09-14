import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../../api/axiosConfig";
import { useAuth } from "../../config/auth/authConfig";
import "./dashboard.css";
import GroupChat from "../group/chat/groupChat";
import GroupListSection from "../group/section/groupListSection";

const Dashboard = () => {

        const { token, username, userUuid } = useAuth();
        const navigate = useNavigate();

        const [ joinedGroups, setJoinedGroups ] = useState([]);

        const [ currentGroup, setCurrentGroup ] = useState();
        const [ groupChatList, setGroupChatList ] = useState([]);

        const getJoinedGroupsApi = async () => {
                await api.post(`/groups/joined`, 
                {
                        userUuid: `${userUuid}`
                },
                {
                        headers: {
                                Authorization: `Bearer ${token}`
                        }
                })
                .then(res => {
                        setJoinedGroups(res.data.groupList);
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
                getJoinedGroupsApi();
        }, []);

        const OnSelectGroup = (group) => {
                setCurrentGroup(group);
                getChatApi(group);
        }

        const getChatApi = async (group) => {

                await api.post("/messages/get", {
                        groupUuid: group.groupUuid
                }, {
                        headers: {
                                Authorization: `Bearer ${token}`
                        }
                })
                .then(res => {
                        setGroupChatList(res.data);
                        // console.log(res.data);
                        
                })
                .catch(error => {
                        console.log(error.response.data);
                        
                });
        }

        const sendChatApi =  async (currentGroup) => {
                await api.post("/message/send", {
                        content: document.getElementById("chatInput").value,
                        userUuid: userUuid,
                        groupUuid: currentGroup.groupUuid,
                        timestamp: new Date().toISOString()
                }, {
                        headers: {
                                Authorization: `Bearer ${token}`
                        }
                })
                .then(res => {
                        getChatApi(currentGroup)
                })
                .catch(error => {
                        console.log(error.response.data);
                        
                });
        }

        return (
        <>
                <GroupListSection 
                        joinedGroups={joinedGroups}
                        OnSelectGroup={OnSelectGroup}
                />
                <GroupChat 
                        currentGroup={currentGroup}
                        groupChatList={groupChatList} 
                        OnSendMessages={sendChatApi}
                />
                <br/>
        </>
        );

}

export default Dashboard