import { useState } from "react";
import { redirect, useActionData, useNavigate } from "react-router-dom";
import api from "../../api/axiosConfig.jsx";
import { useAuth } from "../auth/authConfig.jsx";

// export const action = async ({request}) => {
//         const formData = await request.formData;
//         const user = await Login(formData);

//         if (!user) {
//                 return { error: "invalid credentials"};
//         }

//         return redirect("/home");
// };

const Login = () => {
        
        // const actionData = useActionData();

        const navigate = useNavigate();

        const { setToken } = useAuth();

        const [ errorLogin, setErrorLogin ] = useState();
        
        const [ username, setUsername ] = useState();
        const [ password, setPassword ] = useState();

        const handleUsername = (e) => {
                setUsername(e.target.value);
        };

        const handlePassword = (e) => {
                setPassword(e.target.value);
        };
        
        const OnLogin = async () => {

                const payload = {
                        name: username,
                        password
                };

                await api.post("/login", 
                        payload,
                ).then(res => {                        

                        setErrorLogin(res.data.message);
;
                        setToken(res.data.token);

                        // window.location.replace("http://localhost:3000/home");
                        // return redirect("/home");
                        navigate("/home");
                })
                .catch(error => {
                        if (error.response){
                                setErrorLogin(error.response.data.message);
                        }
                        else {
                                setErrorLogin("Network error");
                                console.log(error);
                                
                        }
                });

        }

        // useEffect(() => {

        // });

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
                                value = {username} 
                                onChange = {handleUsername}
                                required />
                        <br/>

                        <label htmlFor="password">Password : </label>
                        <input 
                                type="password" 
                                id = "password" 
                                name = "password" 
                                value = {password} 
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
