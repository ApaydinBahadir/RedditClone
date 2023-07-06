import axios from "axios";
import { api } from "../App";

export default class UserService{
    getUserById(userId){
        return axios.get(api+"user/getUser?userId="+userId)
    }

    getMainLatestPosts(userId){
        return axios.get(api+"user/MainLatestPosts?userid="+userId)
    }
}