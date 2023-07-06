import React from 'react'

export default function subredditPost() {
    const Child = () => {

        useEffect(() => {
            const [subreddit, setSubreddit] = useState([])
            const [posts, setPosts] = useState([])
        }, []);

        return <div>Some child</div>
    }
}
