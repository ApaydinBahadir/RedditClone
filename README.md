# What is this project?

This project is a headless Reddit clone, meaning it only includes a backend with no graphical user interface. It uses an event-driven, microservice architecture. You can interact with it via HTTP requests using tools like Postman.

# What technologies used?

<ul>
  <li>Java</li>
  <li>Java Spring Boot</li>
  <li>Hibernate</li>
  <li>Event Driven Microservice</li>
  <li>Postgresql</li>
</ul>

# Setup Requirements

You need postgresql working on localhost:5432, which is default. It's should be have user username as "postgresql" and password "123". Other should be handled by program automatically. Or you can change for what you like but don't forget for do it for every service.

# How to use?

<ul>
    <li> API Endpoint: Base URL for API requests is http://localhost:8090/api/ </li>
    <li> Testing: Use Postman or another HTTP client to send requests to the API. </li>
</ul>
 
# Api's

### User Service

#### POST /user/add

- **Description**: Adds a new user.
- **Request Body**: 
    ```json
    {
      "username": "john_doe",
      "email": "john.doe@example.com",
      "password": "securepassword123"
    }
    ```
- **Response**: A `Result` object indicating success or failure.

#### GET /user/user

- **Description**: Retrieves a user by their username.
- **Query Parameter**: `username` (String)
- **Response**: A `DataResult` object containing user data.

#### GET /user/getUser

- **Description**: Retrieves users by their ID.
- **Query Parameter**: `userId` (List of Integer)
- **Response**: A `DataResult` object containing user data.

### Subreddit Service

#### POST /api/subreddit/create

- **Description**: Creates a new subreddit.
- **Request Body**: 
    ```json
    {
      "name": "exampleSubreddit",
      "about": "This is an example subreddit."
    }
    ```
- **Response**: A `Result` object indicating success or failure.

#### GET /api/subreddit/subreddit

- **Description**: Retrieves a subreddit by its name.
- **Query Parameter**: `name` (String)
- **Response**: A `DataResult` object containing subreddit data.

#### POST /api/subreddit/subreddit/updateRole

- **Description**: Updates the role of a user in a subreddit.
- **Query Parameters**: 
  - `subredditId` (int)
  - `userId` (int)
  - `role` (int)
- **Response**: A `Result` object indicating success or failure.

#### GET /api/subreddit/subredditUser/subscribe

- **Description**: Subscribes a user to a subreddit.
- **Query Parameters**: 
  - `userId` (int)
  - `subredditId` (int)
- **Response**: A `Result` object indicating success or failure.

#### GET /api/subreddit/subreddit/unsubscribe

- **Description**: Unsubscribes a user from a subreddit.
- **Query Parameters**: 
  - `subredditId` (int)
  - `userId` (int)
- **Response**: A `Result` object indicating success or failure.

#### GET /api/subreddit/subreddit/getById

- **Description**: Retrieves a subreddit by its ID.
- **Query Parameter**: `subredditId` (int)
- **Response**: A `DataResult` object containing subreddit data.

#### GET /api/subreddit/subreddit/getUsersSubreddit

- **Description**: Retrieves all subreddits a user is subscribed to.
- **Query Parameter**: `userid` (int)
- **Response**: A `DataResult` object containing a list of subreddits.


### Post Service

#### POST /api/post/add

- **Description**: Adds a new post.
- **Request Body**: 
    ```json
    {
      "title": "Example Post Title",
      "postText": "This is the content of the post.",
      "subreddit": 1,
      "userId": 1
    }
    ```
- **Response**: A `Result` object indicating success or failure.

#### GET /api/post/user

- **Description**: Retrieves posts by a specific user.
- **Query Parameter**: `userId` (Integer)
- **Response**: A `DataResult` object containing posts for the specified user.

#### GET /api/post/subreddit

- **Description**: Retrieves posts for a specific subreddit.
- **Query Parameter**: `subredditId` (Integer)
- **Response**: A `DataResult` object containing posts for the specified subreddit.

#### GET /api/post/getPost

- **Description**: Retrieves a specific post by its ID.
- **Query Parameter**: `postId` (Integer)
- **Response**: A `DataResult` object containing the details of the specified post.


### Comment Service

#### POST /api/comment/add

- **Description**: Adds a new comment.
- **Request Body**: 
    ```json
    {
      "text": "This is a comment.",
      "parentId": 1,
      "postId": 1,
      "userId": 0
    }
    ```
- **Response**: A `Result` object indicating success or failure.

#### GET /api/comment/getByUserId

- **Description**: Retrieves comments by a specific user.
- **Query Parameter**: `userId` (int)
- **Response**: A `DataResult` object containing comments for the specified user.

#### GET /api/comment/getByPostId

- **Description**: Retrieves comments for a specific post.
- **Query Parameter**: `postId` (int)
- **Response**: A `DataResult` object containing comments for the specified post.

#### GET /api/comment/getByParentId

- **Description**: Retrieves comments that are replies to a specific parent comment.
- **Query Parameter**: `parentId` (int)
- **Response**: A `DataResult` object containing comments that are replies to the specified parent comment.
