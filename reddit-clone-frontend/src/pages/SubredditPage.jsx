import React, { useEffect, useState } from 'react'
import SubredditService from '../services/subredditService'
import { Container, Divider, Grid, GridColumn } from 'semantic-ui-react'
import PostService from '../services/postService'
import UserService from '../services/userService'

export default function SubredditPage() {
    const [subreddit, setSubreddit] = useState([])
    const [posts, setPosts] = useState([])
    const [user, setUser] = useState([])
    const [isLoaded, setLoaded] = useState(false);
    const [data, setData] = useState();

    const userService = new UserService()

    useEffect(() => {
        new SubredditService().getSubreddit(52).then(result => setSubreddit(result.data.data))
        new PostService().getSubredditPosts(52).then(result => {
            setPosts(result.data.data)
            var arr = []
            result.data.data.map((variabl) => {
                arr.push(variabl.userid)
            })
            userService.getUserById(arr).then(result => setUser(result.data.data))

        })
        setLoaded(true)
    }, [])

    if (isLoaded) {
        if (user[0] != undefined) {
            setData(posts.map((el, index) => el.userid === user[index].userid &&
            {
                username: user[index].username,
                post_created_at: el.created_at,
                post_text: el.post_text,
                post_title: el.title
            }
            ))
            setLoaded(false)
        }
    }

    return (
        <div>
            <Grid>
                <Grid.Row columns={2}>
                    <GridColumn width={12}>

                        {
                            data?.map((res) => (
                                <Container
                                    style={{
                                        backgroundColor: "#CBCBCB",
                                        padding: "1em",
                                        marginTop: "2em",
                                        cursor: "pointer"
                                    }} key={res.post_created_at}>
                                    <Container textAlign='left' style={{ fontSize: "10px" }}><p><span style={{ float: "left" }}>Posted by /{res.username}</span> <span style={{ float: 'right' }}>{res.post_created_at.substring(11, 16) + '\t' + res.post_created_at.substring(0, 7).replace('-', '.')}</span></p></Container>
                                    <br />
                                    <Container textAlign='justified' >
                                        <b style={{ fontSize: "25px" }} onClick={() => window.location.href = 'http://localhost:3000/post/54'}>{res.post_title}</b>
                                        <Divider />
                                        {
                                            res.post_text.length > 100
                                                ? <p style={{ fontSize: "12px", opacity: "0.8" }}>{res.post_text.substring(0, 100) + '...'}</p>
                                                : <p style={{ fontSize: "12px", opacity: "0.8" }}>{res.post_text.substring(0, 100)}</p>
                                        }

                                    </Container>
                                </Container>
                            ))}

                    </GridColumn>
                    <GridColumn width={4}>
                        {subreddit.map((subreddit) => (
                            <Container key={subreddit.subredditId} style={{
                                fontSize: "10px",
                                textAlign: "left",
                                backgroundColor: "#CBCBCB",
                                padding: "1em"
                            }}>
                                <div style={{ fontSize: "22px" }}>{subreddit.name}</div>
                                About Subreddit
                                <div>{subreddit.about}</div>
                                <div style={{ opacity: "0.5" }}>Created At {subreddit.createdAt.substring(0, 7).replace('-', '.')}</div>
                                <Divider />
                                <div style={{ fontSize: "22px", color: "red" }} onClick={() => window.location.href = 'http://localhost:3000/createPost'}>Create Post</div>
                            </Container>

                        ))}

                    </GridColumn>
                </Grid.Row>
            </Grid>
        </div>
    )
}
