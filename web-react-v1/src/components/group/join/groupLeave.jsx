import api from "../../../api/axiosConfig";
import { useAuth } from "../../auth/authConfig";

const GroupLeave = ({group}) => {

        const { token, username, userUuid } = useAuth();
        
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

        return (<>
                <button onClick={() => leaveGroupApi(group)}>Leave Group</button>
                <></>
        </>);
}

export default GroupLeave
