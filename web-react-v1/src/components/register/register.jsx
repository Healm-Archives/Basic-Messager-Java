import React, { useEffect, useState } from "react";
import api from "../../api/axiosConfig";

const Register = () => {
        
        const [ errorRegister, setErrorRegister ] = useState();

        const OnRegister = async () => {
                const username = document.getElementById("username").value;
                const password = document.getElementById("password").value;

                const payload = {
                        name: username,
                        password
                };

                api.post("/signin", 
                        payload,
                        // { 
                        //         headers: {"Content-Type": "application/json"}
                        // }
                        )
                        .then(res => {
                                setErrorRegister(res.data);
                        })
                        .catch(error => {
                                setErrorRegister(error.response.data);
                        });
                
        }

        // useEffect(() => {

        // });

        return (
                <form action={OnRegister}>
                        <h1>Register</h1>
                        { errorRegister }
                        <br/>
                        
                        <label htmlFor="username">Username : </label>
                        <input type="text" id = "username" name = "name" required />
                        <br/>

                        <label htmlFor="password">Password : </label>
                        <input type="password" id = "password" name = "password" required />
                        <br/>

                        <input type="submit" id="submit" name="submit"/>

                </form>
        );
};

export default Register;
