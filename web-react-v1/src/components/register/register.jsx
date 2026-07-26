import React, { useEffect } from "react";
import api from "../../api/axiosConfig";

const Register = () => {
        
        const OnRegister = async () => {
                const username = document.getElementById("username").value;
                const password = document.getElementById("password").value;

                const payload = {
                        name: username,
                        password
                };

                const response = await api.post("/signup", 
                        payload,
                        // { 
                        //         headers: {"Content-Type": "application/json"}
                        // }
                )
                
                console.log("response data");
                console.log(response);
                console.log(response.data);
                
        }

        // useEffect(() => {

        // });

        return (
                <form action={OnRegister}>
                        <h1>Register</h1>
                        <label htmlFor="username">Username : </label>
                        <input type="text" id = "username" name = "name"/>
                        <br/>

                        <label htmlFor="password">Password : </label>
                        <input type="password" id = "password" name = "password"/>
                        <br/>

                        <input type="submit" id="submit" name="submit"/>

                </form>
        );
};

export default Register;
