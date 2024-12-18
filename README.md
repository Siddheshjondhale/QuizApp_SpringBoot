
# Quiz Application API Documentation


###  Overview

This is a Quiz Application built using Spring Boot and H2 database. It allows users to participate in quizzes by creating users, adding questions, starting quiz sessions, submitting answers, and checking quiz stats.


Clone and Getting Started
Prerequisites

* Java: Version 21+

* Maven: Ensure Maven is installed and configured.

### Clone the Repository
To get started, clone the repository:

` git clone https://github.com/your-repo/quizApp.git`

`cd quizApp
`

### Run the Application
 * Build and run the application using Maven:
    `mvn spring-boot:run`
 * Base URL : http://localhost:8080/
* Access the H2 Database Console:
       
    Open the link: http://localhost:8080/h2-console
    
    Use the following credentials to log in:
    
    * JDBC URL: `jdbc:h2:mem:testdb`

    * Username: `sa`
    * Password: `password`
* Testing the Application

    Once the application is running, you can use tools like Postman or curl to interact with the API.



## API Endpoints
 #### User Management

 * Add a user
     
     Endpoints `POST /users/add`

     Request:
     
     `{ "username": "sidd"}`



 #### Question Management


 * Generate a Question
     
     Endpoints `POST /api/questions`

     Request:     
     ``` 
     {
         "questionText": "Which country is known as the Land of the Rising Sun?",
         "options": ["China", "Japan", "South Korea", "Thailand"],
         "correctAnswer": "Japan"
    }
    ```

    Response:
    ```
    {
        "id": 1,
        "questionText": "Which country is known as the Land of the Rising Sun?",
        "options": ["China", "Japan", "South Korea", "Thailand"],
        "correctAnswer": "Japan"
    }

    ```

 * Fetch Random Questions

     Endpoints `GET /api/questions`

     Request:
     ```
     [
         {
             "id": 1,
             "questionText": "Which country is known as the Land of the Rising Sun?",
            "options": ["China", "Japan", "South Korea", "Thailand"],
            "correctAnswer": "Japan"
        }
    ]


     ```
     



 #### Quiz Management

 * Start a Quiz
     
     Endpoints `POST /quiz/start`

     Request:
     `{"id": 1}`


     Response:
     
     ``` 
     { 
         "id": 1000001,

         "user": {
             "id": 1,
             "username": "sidd"
             },   

        "questionsAnswered": 0,
        "correctAnswers": 0,
        "incorrectAnswers": 0
    }

 * Submit an answer 
     
     Endpoints `POST /quiz/submit`

     Request:
     ```
     {
         "quizSessionId": 1000001,
         "questionId": 1,
         "answer": "Japan
    }

     ```


 * View Quiz Stats

 
     
     Endpoints `GET /quiz/stats/{quizSessionId}`

    Example `GET /quiz/stats/1000001`

     Request:
     ```
     {
         "id": 1000001,
         "user": {
             "id": 1,
             "username": "sidd"
             },
        "questionsAnswered": 1,
        "correctAnswers": 1,
        "incorrectAnswers": 0
    }

     ```
     

### Dependencies

* Spring Boot Starter Data JPA

* Spring Boot Starter Web

* Spring Boot Starter Security

* H2 Database (runtime)

* Lombok (annotation processing enabled)

* Spring Boot Starter Test

* Spring Security Test
