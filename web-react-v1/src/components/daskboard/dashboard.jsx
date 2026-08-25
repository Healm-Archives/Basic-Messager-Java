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
        const [searchGroupResult, setSearchGroupResult] = useState([]);

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
                        // setGroups(res.data.groupList);
                        setSearchGroupResult(res.data.groupList);
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

        const GroupList = ({group, join, edit, leave}) => {
                return (
                        <>
                                {join && <button onClick={() => joinGroupApi(group)}>Join Group</button>}
                                {leave && <button onClick={() => leaveGroupApi(group)}>Leave Group</button>}
                                {edit && <GroupEditForm group={group} />}
                        </>
                );
        }

        const groupListSection = groups.map(group => {
                return (
                        <>
                                {group.groupName} <GroupList group = {group} join edit leave/>
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
                                        <form action={searchGroupsApi}>

                                                <label htmlFor="groupSearchName">Group Name: </label>
                                                <input 
                                                        id="groupSearchName"
                                                        name="groupSearchName"
                                                        type="text"
                                                        required
                                                />
                                                <br/>
                                                <button type="submit">Search group</button>
                                        </form>

                                        <GroupSearchResult />
                                </div>
                                
                        }
                </>);

        }

        const GroupSearchResult = () => {
                const searchResult = searchGroupResult.map(group => {
                        return (
                                <>
                                        {group.groupName} <GroupList group = {group} join/>
                                        <br/>
                                </>
                        )});

                return (<>
                        <div className="search-result">
                                {searchResult}
                        </div>
                        <></>
                </>);
        }

        const [toggleGroupEdit, setToggleGroupEdit] = useState(false);

        const OnGroupEdit = () => {
                setToggleGroupEdit(value => !value);
        }


        const editGroupApi = async (groupUuid) => {
                await api.post("/group/edit", {
                        groupUuid: groupUuid,
                        groupName: document.getElementById("groupEditGroupName").value,
                        description: document.getElementById("groupEditDescription").value
                }, {
                        headers: {
                                Authorization: `Bearer ${token}`
                        }
                })
                .then(res => {

                        console.log(res.data);
                })
                .catch(error => {
                        console.log("eRRor ", error.response.data);
                        
                });
        }

        const GroupEditForm = ({group}) => {
                return (<>
                        <button onClick={OnGroupEdit}>Edit Group</button>

                        {toggleGroupEdit && 
                                <div className="floating-panel">
                                        <h1>Edit Group</h1>
                                        <button onClick={OnGroupEdit}>Cancel</button> <br />
                                        <form action={() => editGroupApi(group.groupUuid)}>
                                                <label htmlFor="groupEditGroupName">Group Name: </label>
                                                <input 
                                                        type="text"
                                                        name= "groupEditGroupName"
                                                        id= "groupEditGroupName"
                                                        defaultValue={group.groupName}
                                                /> <br/>
                                                <label htmlFor="groupEditDescription">Description: </label>
                                                <input 
                                                        type="text"
                                                        name="groupEditDescription"
                                                        id="groupEditDescription"
                                                /> <br/>

                                                <button type="submit">Apply Change</button>
                                        </form>

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