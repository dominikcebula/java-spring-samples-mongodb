# Java and Spring Sample MongoDB Application

## Overview

This repository contains a sample RESTful API application that demonstrates how to use MongoDB with Java and Spring
Boot. The application provides a complete CRUD (Create, Read, Update, Delete) API for managing a collection of books in
a MongoDB database.

## Features

- RESTful API for managing books
- MongoDB based storage
- MongoDB integration using Spring Data MongoDB
- CRUD operations for books (Create, Read, Update, Delete)
- Integration testing with Testcontainers

## Technology Stack

- Java 21
- Maven
- Spring Boot
- Spring Framework
- Spring MVC
- Spring Data MongoDB
- MongoDB
- Lombok
- JUnit 5
- Testcontainers

## API Endpoints

The application provides the following API endpoints:

- `GET /api/v1/books` - Retrieve all books
- `GET /api/v1/books/{id}` - Retrieve a specific book by ID
- `POST /api/v1/books` - Create a new book
- `PUT /api/v1/books/{id}` - Update an existing book
- `DELETE /api/v1/books/{id}` - Delete a book

## Running the Application

1. Ensure you have MongoDB installed and running on localhost:27017
2. Clone this repository
3. Navigate to the project directory
4. Run `mvn spring-boot:run`
5. The application will be available at http://localhost:8080

## Testing

The application includes integration tests that use Testcontainers to spin up a MongoDB container for testing. To run
the tests:

```
mvn test
```

## Author

Dominik Cebula

* https://dominikcebula.com/
* https://blog.dominikcebula.com/
* https://www.udemy.com/user/dominik-cebula/
