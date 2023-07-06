import React, { useEffect, useRef, useState } from 'react'
import PostService from '../services/postService'
import CommentService from '../services/commentService'
import SubredditService from '../services/subredditService'
import { Button, Container, Divider, Grid, GridColumn, Input, TextArea } from 'semantic-ui-react'
import UserService from '../services/userService'
import { wait } from '@testing-library/user-event/dist/utils'

export default function PostPage() {
    const [post, setPost] = useState([])
    const [comments, setComments] = useState([])
    const [subreddit, setSubreddit] = useState([])
    const [user, setUser] = useState([])
    const [users, setUsers] = useState([])
    const [isLoaded, setLoaded] = useState(false)
    const [data, setData] = useState([])
    const [someVar, setSomeVar] = useState(true);
    const [addComment, setAddComment] = useState();
    const inputRef = useRef();

    let userService = new UserService()

    useEffect(() => {
        setSomeVar(!someVar)
    }, [])

    useEffect(() => {
        new PostService().getPost(54).then(result => {
            result.data.data.map((variabl) => {
                new SubredditService().getSubreddit(variabl.subreddit).then(res => setSubreddit(res.data.data))
                userService.getUserById(variabl.userid).then(res => setUser(res.data.data))
            })
            setPost(result.data.data)
        })
        new CommentService().getPostsComments(54).then(result => {
            let arr = [];
            result.data.data.map((variabl) => {
                userService.getUserById(variabl.userId).then(res => {

                    arr.push(res.data.data)
                })

            })

            setUsers(arr)

            setComments(result.data.data)
        })
        setLoaded(!isLoaded)
    }, [someVar])


    useEffect(() => {
        if (user[0] != undefined) {
            setData([])

            for (let i = 0; i < comments.length; i++) {

                setData(oldData => ([...oldData,

                {
                    commentId: comments[i].commentId,
                    commentCreatedAt: comments[i].createdTime,
                    commentText: comments[i].text,
                    commentUsername: users[i][0].username
                }
                ]))




            }
        }
        console.log(data)

    }, [isLoaded])


    function addCommentToDatabase(text){
        new CommentService().addComment(104,0,text,54)
    }

    function renderData() {
        setSomeVar(!someVar)
    }

    return (
        <Grid>
            <Grid.Row columns={2}>
                <GridColumn width={12}>
                    {
                        post?.map((post) =>
                            user?.map((user) => (
                                (
                                    <Container
                                        style={{
                                            backgroundColor: "#CBCBCB",
                                            padding: "1em",
                                            marginTop: "10px",
                                            cursor: "pointer"
                                        }} key={`${post.postId}_${user.userid}`}>
                                        <Container textAlign='left' style={{ fontSize: "10px" }}><p><span style={{ float: "left" }}>Posted by /{user.username}</span> <span style={{ float: 'right' }}>{post.created_at.substring(11, 16) + '\t' + post.created_at.substring(0, 7).replace('-', '.')}</span></p></Container>
                                        <br />
                                        <Container textAlign='justified' >
                                            <b style={{ fontSize: "25px" }}>{post.title}</b>
                                            <Divider />
                                            <p style={{ fontSize: "12px" }}>{post.post_text}</p>

                                        </Container>
                                        <Divider />
                                        <TextArea label='text' ref={inputRef} onChange={(e) => { setAddComment(e.target.value) }} placeholder='Your Comment...' style={{ resize: "none", width: "100%" }} />
                                        <Button onClick={() => { addCommentToDatabase(addComment) }} style={{ color: "black", borderStyle: "solid", borderColor: "white", borderWidth: "2px" }}>Set</Button>
                                        <Button onClick={() => { renderData() }} style={{ color: "black", borderStyle: "solid", borderColor: "white", borderWidth: "2px" }}>Render</Button>
                                        <Divider />

                                        {
                                            data?.map((data) => (
                                                <Container style={{
                                                    backgroundColor: "#CBCBCB",
                                                    padding: "1em",
                                                    width: "98%",
                                                    marginTop: "4px"
                                                }} key={data.commentId}>

                                                    <Container textAlign='left' style={{ fontSize: "10px" }}><p><span style={{ float: "left" }}>Posted by /{data.commentUsername}</span> <span style={{ float: 'right' }}>{data.commentCreatedAt.substring(11, 16) + '\t' + data.commentCreatedAt.substring(0, 7).replace('-', '.')}</span></p></Container>
                                                    <Divider />
                                                    <Container textAlign='justified' >
                                                        <p style={{ fontSize: "12px" }}>{data.commentText}</p>
                                                    </Container>
                                                </Container>
                                            ))
                                        }
                                    </Container>
                                ))))}


                </GridColumn>
                <GridColumn width={4}>
                    <Container style={{
                        fontSize: "10px",
                        textAlign: "left",
                        backgroundColor: "#CBCBCB",
                        padding: "1em"
                    }}>
                        <div style={{ fontSize: "22px" }}></div>
                        About Subreddit
                        <div></div>
                        <div style={{ opacity: "0.5" }}>Created At</div>
                    </Container>


                </GridColumn>
            </Grid.Row>
        </Grid >
    )
}
