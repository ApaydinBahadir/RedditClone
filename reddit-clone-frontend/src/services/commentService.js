import axios from "axios";
import { api } from "../App";

export default class CommentService {

    getPostsComments(postId) {
        return axios.get(api + "comment/getByPostId?postId=" + postId)
    }

    addComment(user_id,parent_id,comment_text,post_id){
        return axios.post("http://localhost:8095/api/comment/add", {
            userId: user_id,
            parentId: parent_id,
            text: comment_text,
            postId: post_id
        })
            .then((response) => console.log(response.data))
            .then((error) => console.log(error))
    }
}