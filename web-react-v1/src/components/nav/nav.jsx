import { Link } from "react-router-dom";
import Logout from "../logout/logout";

const Nav = () => {
        return (
                <div className = "App-section">
                        <Link to = "/home">Home</Link> |{" "}
                        <Link to = "/login">Login</Link> |{" "}
                        <Link to = "/register">Register</Link> |{" "}
                        <Logout />
                        <br/>
                </div>
        );
}

export default Nav;