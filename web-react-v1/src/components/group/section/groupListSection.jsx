import { useAuth } from "../../../config/auth/authConfig";
import Logout from "../../logout/logout";
import GroupCreation from "../creation/groupCreation";
import GroupSeach from "../search/groupSearch";

const GroupListSection = ({joinedGroups, OnSelectGroup}) => {

        const { username } = useAuth();

        const groupList = joinedGroups.map(group => {
                return (<>
                        <div className = "group-list-section-member" onClick={() => OnSelectGroup(group)}>
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

}

export default GroupListSection
