import api from "../../../api/axiosConfig";
import { useAuth } from "../../auth/authConfig";

const GroupJoin = ({group}) => {

        const { token, userUuid } = useAuth();

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

        return (<>
                <button onClick={() => joinGroupApi(group)}>Join Group</button>
                <></>
        </>);
}

export default GroupJoin
