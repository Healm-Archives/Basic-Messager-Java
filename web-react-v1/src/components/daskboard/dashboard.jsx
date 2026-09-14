import { useEffect, useState } from "react";
import api from "../../api/axiosConfig";
import { useAuth } from "../../config/auth/authConfig";
import { useNavigate } from "react-router-dom";
import GroupCreation from "../group/creation/groupCreation";
import "./dashboard.css";
import GroupJoin from "../group/join/groupJoin";
import GroupLeave from "../group/leave/groupLeave";
import GroupSeach from "../group/search/groupSearch";
import GroupEdit from "../group/edit/groupEdit";
import GroupChat from "../group/chat/groupChat";
import Logout from "../logout/logout";

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

        // const groupListSection = joinedGroups.map(group => {
        //         return (
        //         <>
        //                 {group.groupName}
        //                 <GroupJoin group = {group} />
        //                 <GroupLeave group = {group} />
        //                 <GroupEdit group={group} />
        //                 {/* <GroupChat group = {group} /> */}
        //                 <br/>
        //         </>
        //         )
        // });

        const OnClickGroup = (group) => {
                setCurrentGroup(group);
                // console.log("clicked group : " + group.groupName);
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
                        console.log(res.data);
                        
                })
                .catch(error => {
                        console.log(error.response.data);
                        
                });
        }

        const GroupListSection2 = () => {
                const groupList = joinedGroups.map(group => {
                        return (<>
                                <div className = "group-list-section-member" onClick={() => OnClickGroup(group)}>
                                        {group.groupName}
                                </div>
                                <></>
                                {/* <GroupEdit group = {group} /> */}
                                {/* <GroupChat group = {group} /> */}
                        </>)
                });

                return (<>
                        <div className="group-list-section">
                                Welcome, {username}
                                <Logout />
                                <GroupSeach /> 
                                <GroupCreation />
                                <br />
                                <br />
                                
                                {groupList}
                        </div>
                        <></>
                </>);
        };


        const GroupChatSection = () => {
                const groupChatListMember = groupChatList.map(gc => {
                        // if (Date.now() - Date.parse(gc.timestamp) > 24 * 60 * 60 * 1000){
                        //         console.log(gc.content, "old");
                        // } else {
                        //         console.log(gc.content, "new");
                        // }

                        return (<>
                                <div className="group-chat-section-member">
                                        {/* {gc.userUuid}  */}
                                        {/* {gc.name} : {gc.content} : {gc.timestamp} */}
                                        <img src="/src/assets/react.svg" id="profile-picture" alt="harusnya ad gbr sni" />
                                        <div className="group-chat-data">
                                                <div className="group-chat-timestamp">
                                                        01-01-2026
                                                </div>
                                                <div className="group-chat-text">
                                                        {gc.content}
                                                        {/* aadasdasdaadasdasdaadasdasdaadasdasdaadasdasdaadasdasdaadasdasdaadasdasd
                                                        aadasdasdaadasdasdaadasdasdaadasdasdaadasdasdaadasdasdaadasdasdaadasdasd
                                                        aadasdasdaadasdasdaadasdasdaadasdasdaadasdasdaadasdasdaadasdasdaadasdasd
                                                        aadasdasdaadasdasdaadasdasdaadasdasdaadasdasdaadasdasdaadasdasdaadasdasd
                                                        aadasdasdaadasdasdaadasdasdaadasdasdaadasdasdaadasdasdaadasdasdaadasdasd
                                                        aadasdasdaadasdasdaadasdasdaadasdasdaadasdasdaadasdasdaadasdasdaadasdasd */}
                                                </div>
                                        </div>
                                </div>
                                <></>
                        </>);
                });

                return (<>
                        <div className="group-chat-section">
                                {groupChatListMember}
                                <br />

                                <form action={sendChatApi} className="group-chat-text-input">
                                        {/* <label htmlFor="chatInput">
                                                Type here: 
                                        </label> */}
                                        <input
                                                id = "chatInput"
                                                name = "chatInput"
                                                type = "text"
                                                placeholder="Type message here"
                                                required
                                        />
                                        <input
                                                id = "submit"
                                                name = "submit"
                                                type = "submit"
                                        />
                                </form>
                        </div>
                        <></>
                </>);
        }

        const sendChatApi =  async () => {
                                 
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

                })
                .catch(error => {
                        console.log(error.response.data);
                        
                });
        }

        return (
        <>
                <GroupListSection2 />
                <GroupChatSection />
                {/* {groupListSection} */}
                <br/>
        </>
        );

}

export default Dashboard