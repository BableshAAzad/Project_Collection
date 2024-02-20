import { createSlice } from "@reduxjs/toolkit";


let userSlice = createSlice({
    name : "user",
    initialState : [],
    reducers : {
        addProduct(state, action){
            state.push(action.payload)
        },
        removeProduct(state, action){
           return state.filter((val)=>{
                return val.id !== action.payload;
            })
        },
        removeAllProduct(state, action){
            return [];
        },
        totalProductsCout(state, action){
            return state;
        }
    }
})
export default userSlice.reducer;
export let {addProduct, removeProduct, removeAllProduct, totalProductsCout} = userSlice.actions