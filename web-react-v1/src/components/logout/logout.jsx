import { useNavigate } from "react-router-dom";
import { useAuth } from "../../config/auth/authConfig";

const Logout = () => {
        
        const { setToken, setUsername } = useAuth();

        const navigate = useNavigate();

        const onLogout = () => {
                setToken();
                setUsername();

                navigate("/");
        }

        return (
                <button onClick={onLogout}>
                        Logout
                </button>
        );
}

export default Logout
