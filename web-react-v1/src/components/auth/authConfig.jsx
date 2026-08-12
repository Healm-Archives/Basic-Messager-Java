import { createContext, useContext, useEffect, useState } from "react";

const AuthContext = createContext();

export const AuthProvider = ({children}) => {
        const [ token, setToken ] = useState(() => localStorage.getItem("token"));
        const [ username, setUsername] = useState(() => localStorage.getItem("username"));

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

        return (
                <AuthContext.Provider value = {{token, setToken, username, setUsername}}>
                        {children}
                </AuthContext.Provider>
        )
}

export const useAuth = () => useContext(AuthContext);
