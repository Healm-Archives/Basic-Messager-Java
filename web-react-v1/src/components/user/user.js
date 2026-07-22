import React, { useEffect, useState } from "react";
import api from "../../api/axiosConfig";

const User = () => {
        const [users, setUsers] = useState([]);

        const getUsers = async () => {

                try 
                {
                        const response = (await api.get("/users"));
                        console.log("getUsers");
                        console.log(response.data);
                        
                        setUsers(response.data);

                } 
                catch (error) 
                {
                        console.log("eRror", error);
                }

        }

        useEffect(() => {
                getUsers();
        }, []);

        const user = users.map((val, i) => {
                return (
                        <div key={"userId-" + i}>
                                {val.name}
                                <br/>
                        </div>
                );
        });

        return (
                <>
                        {user}
                </>
        );

}

export default User;