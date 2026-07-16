# 📅 Service Schedule System

A REST API built with **Java** and **Spring Boot** for managing service appointments.

The project was developed to practice backend concepts such as REST APIs, layered architecture, DTOs, data validation, pagination, entity relationships, and Spring Data JPA.

---

##  Features

-  Create appointments
-  List appointments with pagination
-  Search appointment by ID
-  Search appointments by phone number
-  Search appointments by date
-  Search appointments by date range
-  Search appointments by service type
-  Update appointments
-  Delete appointments
-  Service types management
-  Search service types by partial name
-  Entity relationship (Appointment ↔ Service Type)
-  DTO pattern
-  Centralized exception handling
-  Bean Validation
-  Swagger / OpenAPI documentation
-  Date validation
-  Business hours validation
-  Duplicate appointment prevention

---

## 🛠️ Technologies

-  Java
-  Spring Boot
- ️ Spring Data JPA
-  PostgreSQL
-  Maven
-  Jakarta Validation
-  Springdoc OpenAPI (Swagger UI)

---

## 📂 Project Structure

```text
src
├── controller
├── service
├── repository
├── entity
├── dto
├── exception
├── config
```

---

## 🚀 API Endpoints

###  Appointments

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/agendamentos` | Create appointment |
| GET | `/agendamentos` | List appointments (paginated) |
| GET | `/agendamentos/{id}` | Get appointment by ID |
| GET | `/agendamentos/telefone/{telefone}` | Search by phone |
| GET | `/agendamentos/data/{data}` | Search by date |
| GET | `/agendamentos/periodo` | Search by date range |
| GET | `/agendamentos/tipos-servico/{id}` | Search by service type |
| PUT | `/agendamentos/{id}` | Update appointment |
| DELETE | `/agendamentos/{id}` | Delete appointment |

###  Service Types

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/tipos-servico` | Create service type |
| GET | `/tipos-servico` | List service types |
| GET | `/tipos-servico/{id}` | Get service type by ID |
| GET | `/tipos-servico/buscar?nome=` | Search service types by name |
| PUT | `/tipos-servico/{id}` | Update service type |
| DELETE | `/tipos-servico/{id}` | Delete service type |

---

## 📌 Business Rules

-  Appointments cannot be scheduled in the past.
-  Business hours are **08:00 AM – 06:00 PM**.
-  Two appointments cannot have the same date and time.
-  Every appointment must be linked to a service type.
-  A service type cannot be deleted while it is being used by appointments.
-  Service type names must be unique.

---

## 📖 API Documentation

After starting the application, the interactive Swagger UI is available at:

```
http://localhost:8080/swagger-ui/index.html
```

---

## 👨‍💻 Author

**Arthur de Lara Zilli**