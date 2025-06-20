# Java and Spring Sample MongoDB Application

## Overview

This repository contains a sample RESTful API application that demonstrates how to use MongoDB with Java and Spring
Boot. The application provides a complete CRUD (Create, Read, Update, Delete) API for managing a collection of books in
a MongoDB database.

## Features

- RESTful API for managing books
- MongoDB based storage
- MongoDB integration using Spring Data MongoDB
- Docker Compose integration for automatic MongoDB startup
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
- Docker
- Docker Compose
- Spring Boot Docker Compose
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

## API Examples

Below are curl examples for all API operations:

### Retrieve All Books

```bash
curl -X GET http://localhost:8080/api/v1/books
```

Example response:

```json
[
  {
    "id": "65a123b789cdef0123456789",
    "title": "To Kill a Mockingbird",
    "author": "Harper Lee",
    "publishedYear": 1960,
    "genres": [
      "Fiction",
      "Classic",
      "Coming-of-age"
    ],
    "pages": 281
  },
  {
    "id": "65a123b789cdef0123456790",
    "title": "1984",
    "author": "George Orwell",
    "publishedYear": 1949,
    "genres": [
      "Dystopian",
      "Science Fiction",
      "Political Fiction"
    ],
    "pages": 328
  }
]
```

### Retrieve a Specific Book

```bash
curl -X GET http://localhost:8080/api/v1/books/65a123b789cdef0123456789
```

Example response:

```json
{
  "id": "65a123b789cdef0123456789",
  "title": "To Kill a Mockingbird",
  "author": "Harper Lee",
  "publishedYear": 1960,
  "genres": [
    "Fiction",
    "Classic",
    "Coming-of-age"
  ],
  "pages": 281
}
```

### Create a New Book

```bash
curl -X POST http://localhost:8080/api/v1/books \
  -H "Content-Type: application/json" \
  -d '{
    "title": "The Great Gatsby",
    "author": "F. Scott Fitzgerald",
    "publishedYear": 1925,
    "genres": ["Fiction", "Classic", "Tragedy"],
    "pages": 180
  }'
```

Example response:

```json
{
  "id": "65a123b789cdef0123456791",
  "title": "The Great Gatsby",
  "author": "F. Scott Fitzgerald",
  "publishedYear": 1925,
  "genres": [
    "Fiction",
    "Classic",
    "Tragedy"
  ],
  "pages": 180
}
```

### Update an Existing Book

```bash
curl -X PUT http://localhost:8080/api/v1/books/65a123b789cdef0123456791 \
  -H "Content-Type: application/json" \
  -d '{
    "title": "The Great Gatsby",
    "author": "F. Scott Fitzgerald",
    "publishedYear": 1925,
    "genres": ["Fiction", "Classic", "Tragedy", "Literary Fiction"],
    "pages": 180
  }'
```

Example response:

```json
{
  "id": "65a123b789cdef0123456791",
  "title": "The Great Gatsby",
  "author": "F. Scott Fitzgerald",
  "publishedYear": 1925,
  "genres": [
    "Fiction",
    "Classic",
    "Tragedy",
    "Literary Fiction"
  ],
  "pages": 180
}
```

### Delete a Book

```bash
curl -X DELETE http://localhost:8080/api/v1/books/65a123b789cdef0123456791
```

This operation returns no content (HTTP 204) if successful.

## Running the Application

1. Ensure you have Docker installed and running
2. Clone this repository
3. Navigate to the project directory
4. Run `mvn spring-boot:run`
5. The application will automatically start MongoDB using Docker Compose
6. The application will be available at http://localhost:8080

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
