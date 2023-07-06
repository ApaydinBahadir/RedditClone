import React from 'react'
import { useState } from 'react'
import { Button, TextArea } from 'semantic-ui-react'
import SubredditService from '../services/subredditService'
import { changeSubredditState } from '../states/States'

export default function CreateSubreddit() {

    const [name, setName] = useState()
    const [about, setAbout] = useState()
    const [returnText, setReturnText] = useState()

    function addCommentToDatabase() {
        new SubredditService().createSubreddit(name,about)
        setReturnText("Subreddit Oluşturuldu")
        changeSubredditState()
    }


    return (
        <div>
            <TextArea not null label='text' onChange={(e) => { setName(e.target.value) }} placeholder='Subreddit Name' style={{ resize: "none", width: "100%" }} />

            <TextArea not null label='text' onChange={(e) => { setAbout(e.target.value) }} placeholder='Subreddit About' style={{ resize: "none", width: "100%" }} />
            <Button onClick={() => { addCommentToDatabase() }} style={{ color: "black", borderStyle: "solid", borderColor: "white", borderWidth: "2px" }}>Send</Button>
            {
                returnText?<p>{returnText}</p>:null
            }
        </div>

    )
}
