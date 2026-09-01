import { useState } from "react";
import api from "../../../api/axiosConfig";
import { useAuth } from "../../auth/authConfig";
import GroupJoin from "../join/groupJoin";

const GroupSeach = () => {

        const { token } = useAuth();
        const [searchGroups, setSearchGroups] = useState(false);
        const [searchGroupResult, setSearchGroupResult] = useState([]);

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
                        setSearchGroupResult(res.data.groupList);
                })
                .catch(error => {
                        console.log("eRror" + error);
                });

        };


        const GroupSearchResult = () => {
                const searchResult = searchGroupResult.map(group => {
                        return (
                                <>
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
