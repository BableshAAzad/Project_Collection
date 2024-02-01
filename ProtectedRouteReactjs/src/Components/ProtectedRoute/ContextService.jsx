import React, { useContext } from 'react'
import { ContextProvider } from "./AuthProvider"
import { Navigate } from 'react-router-dom';

function ContextService({ children }) {
    let { islogin } = useContext(ContextProvider);
    if (islogin === null) {
        return <Navigate to="/loginPage" />
    }
    return (
        <>
            {children}
        </>
    )
}

export default ContextService
