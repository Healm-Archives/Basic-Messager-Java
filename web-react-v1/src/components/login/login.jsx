import React, { useEffect, useState } from "react";
import api from "../../api/axiosConfig";

const Login = () => {
        
        const [ errorLogin, setErrorLogin ] = useState();

        const OnLogin = async () => {
                const username = document.getElementById("username").value;
                const password = document.getElementById("password").value;

                const payload = {
                        name: username,
                        password
                };

                api.post("/login", 
                        payload,
                        // { 
                        //         headers: {"Content-Type": "application/json"}
                        // }
                ).then(res => {                        
                        setErrorLogin(res.data);
                }).catch(error => {
                        if (error.response){
                                setErrorLogin(error.response.data);
                        }
                        else {
                                setErrorLogin("Network error");
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
                        <input type="text" id = "username" name = "name"/>
                        <br/>

                        <label htmlFor="password">Password : </label>
                        <input type="password" id = "password" name = "password"/>
                        <br/>
                        <br/>
                        <input type="submit" id="submit" name="submit"/>

                </form>
        );
};

export default Login;
