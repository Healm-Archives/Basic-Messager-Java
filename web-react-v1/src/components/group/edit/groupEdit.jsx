import { useState } from "react";
import api from "../../../api/axiosConfig";
import { useAuth } from "../../auth/authConfig";

const GroupEdit = ({group}) => {

        const { token } = useAuth();

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
                        // console.log(res.data);
                })
                .catch(error => {
                        console.log("eRRor ", error.response.data);
                        
                });
        }

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

export default GroupEdit
