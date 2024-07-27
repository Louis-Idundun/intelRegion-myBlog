# My Blog Application

This is a Java-based Spring Boot application that serves as a backend for a blogging platform with a PostgreSQL database. The application is containerized using Docker and Docker Compose.

## Prerequisites

Before you begin, ensure you have the following software installed on your machine:

- [Docker](https://www.docker.com/products/docker-desktop)
- [Docker Compose](https://docs.docker.com/compose/install/)
- [Maven](https://maven.apache.org/install.html)
- [Java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)

## Project Structure

my-blog-app/
├── Dockerfile
├── README.md
├── docker-compose.yml
├── pom.xml
└── src/
└── main/
└── java/
└── resources/
└── target/
└── myBlog-0.0.1-SNAPSHOT.jar


## Prerequisites

Before you begin, ensure you have the following installed on your machine:

- Java JDK 11 or later
- Maven 3.6.0 or later
- PostgreSQL

## Setup

### Step 1: Clone the Repository

```bash
git clone https://github.com/yourusername/myblog.git
cd myblog
```

### Step 2: Configure PostgreSQL
Create a PostgreSQL database and user for the application:
```
CREATE DATABASE myblog_db;
CREATE USER myblog_user WITH ENCRYPTED PASSWORD 'yourpassword';
GRANT ALL PRIVILEGES ON DATABASE myblog_db TO myblog_user;
```

#### Step 3: Configure Application Properties

Edit the src/main/resources/application.properties file with your database details:
```
spring.datasource.url=jdbc:postgresql://localhost:5432/myblog_db
spring.datasource.username=myblog_user
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
````

##### Step 4: Build the Application
Use Maven to build the application:
```
mvn clean install
```

###### Step 5: Run Docker Compose
Use Docker Compose to build and run the application. This command will start both the PostgreSQL database and the Spring Boot application.
```
docker-compose up --build
```

##### Step 6: Access the Application
The application should now be running and accessible at http://localhost:8080.

API Endpoints
Here are some of the key API endpoints available in this application:

User Endpoints
```
POST /api/users/register - Register a new user
POST /api/users/login - Authenticate user and return a token
GET /api/users/profile - Get user profile (Authenticated)
```
Post Endpoints
```
GET /api/posts - Retrieve all posts (Paginated)
GET /api/posts/:id - Retrieve a single post by ID
POST /api/posts - Create a new post (Authenticated)
PUT /api/posts/:id - Update a post by ID (Authenticated & Author only)
DELETE /api/posts/:id - Delete a post by ID (Authenticated & Author only)
```
Comment Endpoints
```
GET /api/posts/:postId/comments - Retrieve all comments for a post (Paginated)
POST /api/posts/:postId/comments - Create a new comment on a post (Authenticated)
PUT /api/comments/:id - Update a comment by ID (Authenticated & Author only)
DELETE /api/comments/:id - Delete a comment by ID (Authenticated & Author only)
```
Environment Variables
The application uses the following environment variables, which are set in the docker-compose.yml file:
```
SPRING_DATASOURCE_URL
SPRING_DATASOURCE_USERNAME
SPRING_DATASOURCE_PASSWORD
You can modify these values as needed.
```
Database
The application uses PostgreSQL as the database. The database configuration is defined in the docker-compose.yml file. The database service is set up with the following environment variables:
```
POSTGRES_USER
POSTGRES_PASSWORD
POSTGRES_DB
```

##### Step 7: Docker Configuration
Dockerfile
The Dockerfile defines the Docker image for the Spring Boot application.
```
# Use an official OpenJDK runtime as a parent image
FROM maven:3.8.5-openjdk-17 AS build
COPY . .

# Set the working directory in the container
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/myBlog-0.0.1-SNAPSHOT.jar myblog.jar

# Copy the executable jar file to the working directory
COPY target/myBlog-0.0.1-SNAPSHOT.jar /app/myBlog.jar
EXPOSE 8080
# Command to run the application
ENTRYPOINT ["java","-jar","/myblog.jar"]
```

Docker Compose
The docker-compose.yml file defines the services for the application.
```
version: "3.8"
services:
  database:
    image: 'postgres:latest'
    container_name: database
    restart: always
    environment:
      - 'POSTGRES_DB=myBlog_DB'
      - 'POSTGRES_PASSWORD=$Luweezy36'
      - 'POSTGRES_USER=louisidundun'
    ports:
      - '5432:5432'
    networks:
          - myBlog

  backend:
    container_name: myBlog
    build:
      context: .
      dockerfile: Dockerfile
    ports:
      - '8020:8020'
    environment:
      - SPRING_DATASOURCE_URL=jdbc:postgresql://database:5432/myBlog_DB
      - SPRING_DATASOURCE_USERNAME=louisidundun
      - SPRING_DATASOURCE_PASSWORD=@Luweezy360#
      - SPRING_JPA_HIBERNATE_DDL_AUTO=create
    depends_on:
      - database
    networks:
      - myBlog
#    healthcheck:
#      test: [ "CMD", "curl", "-f", "http://localhost:8020/actuator/health" ]
#      interval: 30s
#      timeout: 10s
#      retries: 5
networks:
  myBlog:
    driver: "bridge"
```

Testing
To run unit and integration tests, use the following Maven command:
```
mvn test
```

Deployment
To deploy the application to a cloud provider, ensure your Docker images are pushed to a container registry and configure the cloud provider to pull and run these images.
```
Additional Resources
Spring Boot Documentation
Docker Documentation
PostgreSQL Documentation
```

License
This project is licensed under the MIT License. See the LICENSE file for details.
```
This `README.md` file provides comprehensive instructions on setting up, running, and understanding the application. Modify any sections as needed to fit your project's specifics.
```











