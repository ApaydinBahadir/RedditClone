import React, { useEffect, useState } from 'react'
import SubredditService from '../services/subredditService'
import { Container, Divider, Grid, GridColumn } from 'semantic-ui-react'
import PostService from '../services/postService'
import UserService from '../services/userService'

export default function DenemeSubreddit() {


    return (
        <div>
            <Grid>
                <Grid.Row columns={2}>
                    <GridColumn width={12}>
                        No Post At All
                    </GridColumn>
                    <GridColumn width={4}>
                        {
                            <Container style={{
                                fontSize: "10px",
                                textAlign: "left",
                                backgroundColor: "#CBCBCB",
                                padding: "1em"
                            }}>
                                <div style={{ fontSize: "22px" }}>videoSubreddit</div>
                                About Subreddit
                                <div>videoSubreddit</div>
                                <div style={{ opacity: "0.5" }}>Created At 2023.06</div>
                                <Divider />
                                <div style={{ fontSize: "22px", color: "red" }} onClick={() => window.location.href = 'http://localhost:3000/createPost'}>Create Post</div>
                            </Container>

                        }

                    </GridColumn>
                </Grid.Row>
            </Grid>
        </div>
    )
}
