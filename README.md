# Personal Finance Tracker API

A RESTful API built with **Spring Boot** for managing personal expenses and categories. The project follows a clean layered architecture using **DTOs, Mappers, Spring Data JPA, and PostgreSQL**.

---

## Features

- Expense CRUD APIs
- Category CRUD APIs
- DTO Pattern
- Mapper Pattern
- Bean Validation
- Global Exception Handling
- Constructor Dependency Injection
- Spring Data JPA with PostgreSQL

---

## Tech Stack

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- Git & GitHub

---

## Project Structure

```
src
├── controller
├── dto
├── entity
├── exception
├── mapper
├── repository
└── service
```

---

## API Endpoints

### Expense

| Method | Endpoint |
|---------|----------|
| POST | `/api/expenses` |
| GET | `/api/expenses` |
| GET | `/api/expenses/{id}` |
| PUT | `/api/expenses/{id}` |
| DELETE | `/api/expenses/{id}` |

### Category

| Method | Endpoint |
|---------|----------|
| POST | `/api/categories` |
| GET | `/api/categories` |
| GET | `/api/categories/{id}` |
| PUT | `/api/categories/{id}` |
| DELETE | `/api/categories/{id}` |

---

## Configuration

Set the following environment variables before running the project:

```text
DB_USERNAME=your_postgres_username
DB_PASSWORD=your_postgres_password
```

Update the database name if needed:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/personal_finance
```

---

## Run Locally

```bash
git clone https://github.com/Monica-027/personal-finance-tracker.git
cd personal-finance-tracker
./mvnw spring-boot:run
```

---

## Future Improvements

- Pagination & Sorting
- Filtering
- Swagger/OpenAPI
- JWT Authentication

---

## Author

**Monica Prajapati**
