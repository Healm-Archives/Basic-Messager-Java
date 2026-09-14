import { createContext, useContext, useEffect, useState } from "react";

const AuthContext = createContext();

export const AuthProvider = ({children}) => {
        const [ token, setToken ] = useState(() => localStorage.getItem("token"));
        const [ username, setUsername] = useState(() => localStorage.getItem("username"));
        const [ userUuid, setUserUuid] = useState(() => localStorage.getItem("userUuid"));

        useEffect(() => {
                if (token) {
                        localStorage.setItem("token", token);
                } else {
                        localStorage.removeItem("token");
                }
        }, [token]);

        useEffect(() => {
                if (username) {
                        localStorage.setItem("username", username);
                } else {
                        localStorage.removeItem("username");
                }
        }, [username]);

        useEffect(() => {
                if (userUuid) {
                        localStorage.setItem("userUuid", userUuid);
                } else {
                        localStorage.removeItem("userUuid");
                }
        }, [userUuid]);

        return (
                <AuthContext.Provider value = {{token, setToken, username, setUsername, userUuid, setUserUuid}}>
                        {children}
                </AuthContext.Provider>
        )
}

export const useAuth = () => useContext(AuthContext);
