import React from 'react'
import { useState } from 'react'
import { Button, TextArea } from 'semantic-ui-react'
import SubredditService from '../services/subredditService'
import { changeSubredditState } from '../states/States'
import PostService from '../services/postService'

export default function CreatePost() {

    const [title, setTitle] = useState()
    const [postText, setpostText] = useState()
    const [returnText, setReturnText] = useState()

    function addCommentToDatabase() {
        new PostService().createPost(title,postText,52,104)
        setReturnText("Post Oluşturuldu")
    }


    return (
        <div>
            <TextArea not null label='text' onChange={(e) => { setTitle(e.target.value) }} placeholder='Post Title' style={{ resize: "none", width: "100%" }} />

            <TextArea not null label='text' onChange={(e) => { setpostText(e.target.value) }} placeholder='Post Text' style={{ resize: "none", width: "100%" }} />
            <Button onClick={() => { addCommentToDatabase() }} style={{ color: "black", borderStyle: "solid", borderColor: "white", borderWidth: "2px" }}>Send</Button>
            {
                returnText?<p>{returnText}</p>:null
            }
        </div>

    )
}
