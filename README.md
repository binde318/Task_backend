1.1 Project Description: This project is a simple online book system that uses spring CRUD operation, where you can access books with their title, authors, prices, and names.


1.2 Technologies Used: The technologies used in the projects are MySQL for database connectivity, that is the database server that manages the CRUD operations to take place effectively,
spring boot, dependencies such as Lombok to reduce boilerplate, spring data Jpa to enable effective interaction with the database for CRUD operations, and modelMapper is often used to convert entities to DTOs (Data Transfer Objects) and vice versa. 


2.1 Prerequisites: what is needed to be installed before the application is set up to run are Java, Maven, a database server, etc.

3.1 Database Configuration: The application database connection properties use the application.properties file not YAML.

4.1 Run the Application: The application can run on IntelliJ IDE by clicking on the run icon on the SpringBootApplication main class.

4.2 Access the Application: The application can be accessed on localhost port number 8089.

5.1 Overview: This application supports CRUD operation on GETMMAPPING, DELETEMAPPING, PUTMAPPING, and POSTMAPPING.
5.2 Endpoints: Use Postman to test the endpoints, POSTENDPONT: This is the endpoint that creates data from the server side for the user or client to access via GETMETHOD,
GETENDPOINT: This is the endpoint that enables the client to access that data from the server side to the client side either by ID or any parameters provided in the entity class
and the data are in JSON format.
DELETEENDPOINT: enable delete of data by user data ID as request, and the response of "data has been deleted successfully", if the data does not exist then an exception handling will
throw a message "data with the Id does not exist".
PUTENDPOINT: enable the updating of the data, by either changing the entire argument of the parameters of the class or part of it. 

6 Database Schema: including tables, relationships, and key fields.

7 Error Handling:S I used global exception handlers to catch and process exceptions that occur during the processing of HTTP requests. This is often done using @ControllerAdvice and @ExceptionHandler annotations.


