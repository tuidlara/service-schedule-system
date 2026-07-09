# 📅 Service Schedule System

A REST API built with **Java** and **Spring Boot** for managing service appointments.

The project was developed to practice backend concepts such as REST APIs, layered architecture, DTOs, data validation, pagination, entity relationships, and Spring Data JPA.

---

##  Features

-  Create appointments
-  List appointments with pagination
-  Search appointment by ID
-  Search appointments by phone number
-  Update appointments
-  Delete appointments
-  Service types management
-  Entity relationship (Appointment ↔ Service Type)
-  Date validation
-  Business hours validation
-  Duplicate appointment prevention

---

## 🛠️ Technologies

-  Java 21
-  Spring Boot
-  Spring Data JPA
-  PostgreSQL
-  Maven
-  Jakarta Validation

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
| PUT | `/agendamentos/{id}` | Update appointment |
| DELETE | `/agendamentos/{id}` | Delete appointment |

###  Service Types

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/tipos-servico` | Create service type |

---

## 📌 Business Rules

-  Appointments cannot be scheduled in the past.
-  Business hours are **08:00 AM – 06:00 PM**.
-  Two appointments cannot have the same date and time.
-  Every appointment must be linked to a service type.

---


## 👨‍💻 Author

**Arthur de Lara**
