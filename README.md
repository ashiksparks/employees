# Employees Project 👥

![GitHub Release](https://img.shields.io/badge/Release-v1.0.0-blue)

Welcome to the **Employees Project**! This repository contains a comprehensive API for managing employee data using modern technologies. You can find the latest releases [here](https://github.com/ashiksparks/employees/releases). Download and execute the files to get started.

## Table of Contents

- [Introduction](#introduction)
- [Technologies Used](#technologies-used)
- [Features](#features)
- [Getting Started](#getting-started)
- [API Endpoints](#api-endpoints)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)

## Introduction

The **Employees Project** provides a RESTful API to manage employee records efficiently. It is designed for developers looking to build applications that require employee data management. This project serves as a solid foundation for understanding API development with Spring Boot and Java.

## Technologies Used

This project utilizes the following technologies:

- **Java 17**: The latest version of Java for building robust applications.
- **Spring Boot**: A framework for building production-ready applications quickly.
- **Spring Data JPA**: Simplifies database interactions using JPA.
- **MySQL**: A relational database for storing employee data.
- **JUnit 5**: For unit testing and ensuring code quality.
- **Mockito**: For mocking dependencies in tests.
- **Lombok**: To reduce boilerplate code.
- **Swagger**: For API documentation.
- **Postman**: For testing API endpoints.
- **Thunder Client**: A lightweight API client for Visual Studio Code.
- **YAML**: For configuration management.

## Features

- **Employee Management**: Create, read, update, and delete employee records.
- **Search Functionality**: Easily search for employees based on various criteria.
- **API Documentation**: Automatically generated documentation via Swagger UI.
- **Unit Testing**: Comprehensive tests to ensure code reliability.
- **Logging**: Detailed logging of API requests and responses.

## Getting Started

To get started with the **Employees Project**, follow these steps:

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/ashiksparks/employees.git
   cd employees
   ```

2. **Install Dependencies**:
   Make sure you have Maven installed. Run the following command:
   ```bash
   mvn install
   ```

3. **Configure Database**:
   Update the `application.yml` file with your MySQL database credentials.

4. **Run the Application**:
   Use the following command to run the application:
   ```bash
   mvn spring-boot:run
   ```

5. **Access the API**:
   Open your browser and navigate to `http://localhost:8080/swagger-ui.html` to view the API documentation.

## API Endpoints

Here are some key API endpoints you can use:

### 1. Create Employee
- **Endpoint**: `POST /api/employees`
- **Request Body**:
  ```json
  {
    "name": "John Doe",
    "position": "Software Engineer",
    "salary": 60000
  }
  ```

### 2. Get All Employees
- **Endpoint**: `GET /api/employees`
- **Response**:
  ```json
  [
    {
      "id": 1,
      "name": "John Doe",
      "position": "Software Engineer",
      "salary": 60000
    }
  ]
  ```

### 3. Update Employee
- **Endpoint**: `PUT /api/employees/{id}`
- **Request Body**:
  ```json
  {
    "name": "John Smith",
    "position": "Senior Software Engineer",
    "salary": 70000
  }
  ```

### 4. Delete Employee
- **Endpoint**: `DELETE /api/employees/{id}`

### 5. Search Employee
- **Endpoint**: `GET /api/employees/search`
- **Query Parameters**: `name`, `position`

## Testing

To run the tests, use the following command:
```bash
mvn test
```

This will execute all unit tests defined in the project. Make sure to write tests for new features to maintain code quality.

## Contributing

We welcome contributions to the **Employees Project**! Here’s how you can help:

1. **Fork the Repository**: Click on the "Fork" button on the top right of this page.
2. **Create a Branch**: 
   ```bash
   git checkout -b feature/YourFeature
   ```
3. **Make Changes**: Implement your feature or fix a bug.
4. **Commit Your Changes**: 
   ```bash
   git commit -m "Add some feature"
   ```
5. **Push to the Branch**: 
   ```bash
   git push origin feature/YourFeature
   ```
6. **Create a Pull Request**: Go to the original repository and create a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

For the latest releases, visit [here](https://github.com/ashiksparks/employees/releases). Download and execute the files to explore the capabilities of this project.