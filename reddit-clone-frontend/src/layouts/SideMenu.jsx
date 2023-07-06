import React, { useEffect, useState } from 'react'
import { Menu } from 'semantic-ui-react'
import SubredditService from '../services/subredditService';
import { subredditState } from '../states/States';

export default function SideMenu() {
  const [subreddits, setSubreddits] = useState([]);


  useEffect(() => {
    new SubredditService().getUserSubreddit(104).then(result => setSubreddits(result.data.data))

  }, [subredditState])

  return (
    <Menu pointing vertical>
      {
        subreddits?.map((subreddits) => (
          <Menu.Item
            key={subreddits.name}
            name={subreddits.name}
            onClick={()=>window.location.href='http://localhost:3000/subreddit/denemeSubreddit'}
          />
        ))
      }
    </Menu>
  )
}
