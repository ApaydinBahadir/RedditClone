import React from 'react'
import SideMenu from './SideMenu'
import HomePage from '../pages/HomePage'
import PostPage from '../pages/PostPage'
import { Grid, GridColumn } from 'semantic-ui-react'
import SubredditPage from '../pages/SubredditPage'
import { Route, Routes } from 'react-router-dom'
import CreateSubreddit from '../pages/CreateSubreddit'
import CreatePost from '../pages/CreatePost'
import SignInPage from '../pages/SignInPage'
import DenemeSubreddit from '../pages/DenemeSubreddit'


export default function Dashboard() {
    return (
        <div>

            <Grid>
                <Grid.Row>
                    <GridColumn width={3}>
                        <Routes>
                            <Route path='/' />
                            <Route path="/*" element={<SideMenu />} />
                        </Routes>
                    </GridColumn>
                    <GridColumn width={13}>
                        <Routes>
                            <Route path='/home' element={<HomePage />} />
                            <Route path="/subreddit/denemeSubreddit" element={<SubredditPage />} />
                            <Route path="/post/54" element={<PostPage />} />
                            <Route path="/createSubreddit" element={<CreateSubreddit />} />
                            <Route path="/subreddit/videoSubreddit" element={<DenemeSubreddit/>}/>
                            <Route path="/createPost" element={<CreatePost />}></Route>
                        </Routes>
                    </GridColumn>
                </Grid.Row>
            </Grid>

        </div>
    )
}
