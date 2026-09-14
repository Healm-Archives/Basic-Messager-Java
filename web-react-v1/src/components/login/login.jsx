import { useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../../api/axiosConfig.jsx";
import { useAuth } from "../../config/auth/authConfig.jsx";

// export const action = async ({request}) => {
//         const formData = await request.formData;
//         const user = await Login(formData);

//         if (!user) {
//                 return { error: "invalid credentials"};
//         }

//         return redirect("/");
// };

const Login = () => {

        const navigate = useNavigate();

        const { setToken, setUsername, setUserUuid } = useAuth();

        const [ errorLogin, setErrorLogin ] = useState();
        
        const [ loginUsername, setLoginUsername ] = useState();
        const [ loginPassword, setLoginPassword ] = useState();

        const handleUsername = (e) => {
                setLoginUsername(e.target.value);
        };

        const handlePassword = (e) => {
                setLoginPassword(e.target.value);
        };
        
        const OnLogin = async () => {

                const payload = {
                        name: loginUsername,
                        password: loginPassword
                };

                await api.post("/login", 
                        payload,
                ).then(res => {
                        
                        setErrorLogin(res.data.message);
                        
                        setToken(res.data.token);
                        setUsername(loginUsername);
                        setUserUuid(res.data.userUuid);

                        navigate("/home");
                })
                .catch(error => {
                        if (error.response){
                                setErrorLogin(error.response.data.message);
                                console.log(error.response);
                        }
                        else {
                                setErrorLogin("Network error");
                                console.log(error);
                                
                        }
                });

        }

        return (
                <form action={OnLogin}>
                        <h1>Login</h1>
                        { errorLogin }
                        <br/>
                        <label htmlFor="username">Username : </label>
                        <input 
                                type="text" 
                                id = "username" 
                                name = "name" 
                                onChange = {handleUsername}
                                required />
                        <br/>

                        <label htmlFor="password">Password : </label>
                        <input 
                                type="password" 
                                id = "password" 
                                name = "password" 
                                onChange = {handlePassword}
                                required />
                        <br/>
                        <br/>
                        <input 
                                type="submit" 
                                id="submit" 
                                name="submit"/>

                </form>
        );
};

export default Login
