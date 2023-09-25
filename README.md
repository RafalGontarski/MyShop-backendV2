# Fishing Store Backend

## Overview

This is the backend component of our fishing store application. Designed with robustness in mind, it handles a variety of tasks, including product management, user roles, and more.

## Technical Details

- **Programming Language**: Java
- **Framework**: Spring with Hibernate
- **Database**: PostgreSQL
- **API Type**: RestAPI
- **Design Patterns**: MVC and Builder
- **Authentication & Authorization**: Implemented with JWT
- **User Roles**: Admin, Owner, Manager, Client

## Features

1. **User Model**: Handles user data and associated operations.
2. **Category Model**: Manages different product categories within the store.
3. **Product Model**: Manages individual products, their details, and related operations.

## Setup & Installation

1. **Database Setup**: Ensure PostgreSQL is installed and set up on your machine.
2. **Dependencies**: Install the necessary Java dependencies and ensure Spring Boot is set up.
3. **Configuration**: Update the `application.properties` file with your database connection details.
4. **Running the application**: Navigate to the root directory and execute:
   ```
   ./mvnw spring-boot:run
   ```
5. The server will start, and the API will be accessible at `http://localhost:8080/`.

## API Endpoints

(You can expand on this section with detailed API routes, request, and response examples)

## Authentication & Authorization

- **JWT**: Used for securing the API and ensuring only authenticated users can access specific endpoints.
- **User Roles**:
  - **Admin**: Full access to all operations.
  - **Owner**: Can manage product listings and view sales data.
  - **Manager**: Can manage product listings.
  - **Client**: Can view products and make purchases.

## Future Improvements

- Expand the models to include purchase histories, reviews, etc.
- Implement a caching mechanism for faster data retrieval.
- Integration with a frontend application for a complete e-commerce experience.

## Contributions

Feel free to fork this repository, make changes, and submit pull requests. For major changes, please open an issue first to discuss what you'd like to change.

## License

MIT License

Copyright (c) 2023 Rafal Gontarski
