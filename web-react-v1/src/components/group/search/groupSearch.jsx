import { useState } from "react";
import api from "../../../api/axiosConfig";
import { useAuth } from "../../auth/authConfig";
import GroupJoin from "../join/groupJoin";

const GroupSeach = () => {

        const { token } = useAuth();
        const [searchGroups, setSearchGroups] = useState(false);

        const groupSearchToggle = () => {
                setSearchGroups(state => !state);
        }

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

        const [searchGroupResult, setSearchGroupResult] = useState([]);

        const GroupSearchResult = () => {
                const searchResult = searchGroupResult.map(group => {
                        return (
                                <>
                                        {/* {group.groupName} <GroupList group = {group} join/> */}
                                        {group.groupName} <GroupJoin group = {group} />
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

export default GroupSeach
