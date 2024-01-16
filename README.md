# ToDo app api

## Overview
This ToDo app API is a side project of mine developed to sharpen my skills in developing RESTful API using Spring Boot. This project serves as a proof of my dedication and commitment to continuous learning and improvement in the realm of backend development.

## Project Objectives
Primary objectives for this project are:
1. **Skills Enhancement**: Sharpening my skills in building practical and efficient REST APIs with the Spring Boot framework.
2. **Provide Robust API**: Developing useful and efficient API while also providing a well-documented documentation of the API usage

## Features
- **Task Management**: Basic CRUD operations towards task entity
- **RESTful Design**: Follows best practices for RESTful API design, promoting simplicity and ease of use.

## Technologies Used
- Spring boot
- Lombok
- Spring Data JPA

## API Documentation and Endpoint
API Documentation can be referred here on [Swagger UI](http://localhost:8000/swagger-ui/index.html#/). Below are the API endpoints for the API:
- > **GET** /api/tasks: Retrieve all tasks.
- > **GET** /api/tasks/{id}: Retrieve a specific task by ID.
- > **POST** /api/tasks: Create a new task.
- > **PUT** /api/tasks/{id}: Update an existing task from incomplete to complete.
- > **DELETE** /api/tasks/{id}: Delete a task.
- > **DELETE** /api/tasks: Delete all tasks.

## Future Planning
- Add security feature for API security
- Integrate with React app to develop a fullstack ToDo App
- Integrate with Eureka client for microservice architecture
