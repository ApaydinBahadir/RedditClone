import axios from "axios";
import { api } from "../App";

export default class PostService{
    getSubredditPosts(subredditId){
        return axios.get(api+"post/subreddit?subredditId="+subredditId)
    }

    getPost(postId){
        return axios.get(api+"post/getPost?postId="+postId)
    }

    createSubreddit(title,post_text,subreddit,userid){
        return axios.post("http://localhost:8094/api/post/add", {
            name: title,
            about: post_text,
            subreddit: subreddit,
            userid:userid
        })
            .then((response) => console.log(response.data))
            .then((error) => console.log(error))
    }
}