import { useState } from "react";
import { redirect } from "react-router-dom";
import api from "../../api/axiosConfig.jsx";

const Login = () => {
        
        const [ errorLogin, setErrorLogin ] = useState();
        
        const [ username, setUsername ] = useState();
        const [ password, setPassword ] = useState();

        // const [ token, setToken ] = useState();
        let token = "";

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
                        // { 
                        //         headers: {"Content-Type": "application/json"}
                        // }
                ).then(res => {                        
                        setErrorLogin(res.data.message);
                        
                        // console.log(res.data.token);
                        token = res.data.token;

                        // window.location.replace("http://localhost:3000/home");
                        redirect("/home");
                })
                .catch(error => {
                        if (error.response){
                                // setErrorLogin(error.response.data);
                                setErrorLogin(error.response.data.message);
                        }
                        else {
                                setErrorLogin("Network error");
                                // console.log(error);
                                
                        }
                });

                // let token = myresponse.data.token;

                console.log("Token", token);

                const myusers = await api.get("/users", {
                        headers: {
                                Authorization: `Bearer ${token}`
                        }
                });

                console.log(myusers);

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
