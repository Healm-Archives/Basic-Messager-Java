import { Link } from "react-router-dom";
import { useAuth } from "../../config/auth/authConfig";

const Nav = () => {

        const { username } = useAuth();

        return (
                !username &&
                <div>
                        <Link to = "/home">Home</Link> |{" "}
                        <Link to = "/login">Login</Link> |{" "}
                        <Link to = "/register">Register</Link> |{" "}
                        <br/>
                </div>
        );
}

export default Nav