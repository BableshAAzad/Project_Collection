import React, { createContext, useState } from 'react'

export let ContextProvider = createContext();

function AuthProvider({ children }) {
    let [islogin, setIsLogin] = useState(null);
    let login = (user) => {
        setIsLogin(user)
    }
    let logout = () => {
        setIsLogin(null);
    }
    return (
        <ContextProvider.Provider value={{ islogin, login, logout }}>
            {children}
        </ContextProvider.Provider>
    )
}

export default AuthProvider
