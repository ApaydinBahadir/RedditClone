import React, { useState } from 'react'
import { useEffect } from 'react'
import { Container, Divider, Grid, GridColumn } from 'semantic-ui-react'
import UserService from '../services/userService'
import { useNavigate } from 'react-router-dom';


export default function HomePage() {

    const [posts, setPosts] = useState(() => {
        return JSON.parse(localStorage.getItem('postsData')) ?? []
    })
    const [isLoaded, setLoaded] = useState(false)
    const [data, setData] = useState([]);
    const [isLoaded2, setLoaded2] = useState(false)

    useEffect(() => {
        new UserService().getMainLatestPosts(104).then(result => setPosts(result.data.data))
        setLoaded(true);
    }, [])

    if (isLoaded) {
        localStorage.setItem('postsData', JSON.stringify(posts))

        for (let i = 0; i < posts.length; i++) {

            setData(oldData => ([...oldData,
            {
                postTitle: posts[0][i].title,
                postText: posts[0][i].post_text,
                postCreatedAt: posts[0][i].created_at,
                postId: posts[0][i].postId,
                subredditName: posts[1][i],
                userName: posts[2][i]
            }]))
        }

        setLoaded(false)
        setLoaded2(true)
    }

    return (
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
                                }} key={res.postId}>
                                <Container textAlign='left' style={{ fontSize: "10px" }}><p> <span style={{ float: "left", marginRight: "20px" }}>r/{res.subredditName}</span>  <span style={{ float: "left" }}>Posted by /{res.userName}</span> <span style={{ float: 'right' }}>{res.postCreatedAt.substring(11, 16) + '\t' + res.postCreatedAt.substring(0, 7).replace('-', '.')}</span></p></Container>
                                <br />
                                <Container textAlign='justified' >
                                    <b style={{ fontSize: "25px" }}>{res.postTitle}</b>
                                    <Divider />
                                    {
                                        res.postText.length > 100
                                            ? <p style={{ fontSize: "12px", opacity: "0.8" }}>{res.postText.substring(0, 100) + '...'}</p>
                                            : <p style={{ fontSize: "12px", opacity: "0.8" }}>{res.postText.substring(0, 100)}</p>
                                    }

                                </Container>
                            </Container>
                        ))}


                </GridColumn>
                <GridColumn width={4}>
                    <Container style={{
                        fontSize: "10px",
                        textAlign: "left",
                        backgroundColor: "#CBCBCB",
                        padding: "1em"
                    }}>
                        <div style={{ fontSize: "22px", color: "red" }} onClick={()=>window.location.href='http://localhost:3000/createSubreddit'}>Create Subreddit</div>
                    </Container>


                </GridColumn>
            </Grid.Row>
        </Grid>
    )
}
