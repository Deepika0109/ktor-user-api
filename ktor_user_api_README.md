# Kotlin + Ktor: User Management API

A lightweight, Kotlin-native REST API built with [Ktor](https://ktor.io). This project demonstrates a simple user management backend suitable for microservices and modern JVM applications.

## ✨ Features

- Create a user
- List all users
- Delete a user by ID

## 📦 Tech Stack

- Kotlin
- Ktor framework
- kotlinx.serialization for JSON
- In-memory storage using ConcurrentHashMap

## 🚀 How to Run

### Prerequisites:
- JDK 17+
- IntelliJ IDEA (recommended)
- Gradle (handled automatically by IntelliJ)

### Steps:
```bash
./gradlew run
```

The server will start at `http://localhost:8081`.

## 🔌 API Endpoints

| Method | Endpoint       | Description          |
|--------|----------------|----------------------|
| GET    | `/users`       | List all users       |
| POST   | `/users`       | Create a new user    |
| DELETE | `/users/{id}`  | Delete user by ID    |

### Sample POST Request Body:
```json
{
  "name": "John Doe",
  "email": "john@example.com"
}
```

---

## 🧠 Author Notes

This is a great starting point for showcasing **Kotlin + Ktor** in interviews or technical blogs.