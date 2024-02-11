import { configureStore } from "@reduxjs/toolkit";
import userSlice from "./Slices/UserSlice";

let store = configureStore({
    reducer : {
        users : userSlice,
    },
})

export default store;