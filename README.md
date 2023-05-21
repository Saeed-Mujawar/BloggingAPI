<h1 align = "center"> Blogging Platform API </h1>



This is a web application that allows users to signin, singout and delete blog posts and comments. It also allows users to follow other users and view their blog posts.


## Frameworks and Languages Used

- Java
- Spring Boot
- Spring MVC
- Spring Data JPA
- Hibernate
- MySQL
- Swagger
<br>

## Dependencies
The following dependencies are required to run the project:

* Spring Boot Dev Tools
* Spring Web
* Spring Data JPA
* MySQL Driver
* Lombok
* Validation
* Swagger

<br>

## Database Configuration
To connect to a MySQL database, update the application.properties file with the appropriate database URL, username, and password. The following properties need to be updated:
```
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.datasource.url = jdbc:mysql://localhost:3306/bloggingdb
spring.datasource.username = userName
spring.datasource.password = password
spring.jpa.show-sql = true
spring.jpa.hibernate.ddl-auto = update

```


## Data Flow

### Controllers

- `CommentController`: Handles comment-related requests, such as creating a comments.
- `PostController`: Handles post-related requests, such as creating, updating, and deleting a post.
- `UserController`: Handles user-related requests, such as signin, signup.

### Services

- `UserService`: Implements business logic related to user-related requests.
- `PostService`: Implements business logic related to post-related requests.
- `CommentService`: Implements business logic related to comment-related requests.
- `FollowService`: Implements business logic related to follow-related requests.
-  `FollowingService`:  Implements business logic related to following-related requests.
- `AuthenticationService`:  Implements business logic related to Authentication-related requests.
### Repository

- `IUserRepo`: Handles user-related database operations.
- `IPostRepo`: Handles post-related database operations.
- `ICommentRepo`: Handles comment-related database operations.
- `IFollowRepo`: Handles follow-related database operations.
- `IAuthenticationRepo`: Handles Authentication-related database operations.
- `IFollowingRepo`: Handles following-related database operations.
---


## API End Points 

The following endpoints are available in the API:

* User Controller:
```
SignUp /signup
SignIn /signin
FollowUser /follow/{myid}/{otherid}
```

* Post Controller
```
POST /post: create a new post
GET /get: get all posts
Update /update/{postid}/{data}
Delete /delete/{postid}
```

* Comment Controller
```
POST /comment: post the comment
```

<br>

## DataBase Used
* SQL database
```
We have used Persistent database to implement CRUD Operations.
```
---
<br>

## Features

- User can upload Blog
- User can watch other user blog
- User can comment on other blog
- User can follow other user
- Easy to manage details, update, delete, get all blog


## Data Structures Used

- ArrayList: Used to store lists of objects such as posts, comments, and users.


## Project Summary

The project is a basic web application built using Java and the Spring framework. It allows users to sign up, sign in, and used to upload there blog in the website, where large number of viewer can view the blog. Users can also create and view posts. The application uses authentication tokens to secure user data and ensure that only authenticated users can access certain features. The API endpoints include user signup, signin, and update details, post creation and retrieval, and authentication token creation. 

    
---


