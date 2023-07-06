import axios from "axios";
import { api } from "../App";

export default class SubredditService{
    getSubreddit(subredditId){
        return axios.get(api+"subreddit/getById?subredditId="+subredditId)
    }

    getUserSubreddit(userid){
        return axios.get(api+"subreddit/getUsersSubreddit?userid="+userid)
    }    
    
    createSubreddit(subredditName,subredditAbout){
        return axios.post("http://localhost:8093/api/subreddit/create", {
            name: subredditName,
            about: subredditAbout
        })
            .then((response) => console.log(response.data))
            .then((error) => console.log(error))
    }
}