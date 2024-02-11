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
        }
    }
})
export default userSlice.reducer;
export let {addProduct, removeProduct, removeAllProduct} = userSlice.actions