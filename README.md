# user-service

Starter project for the **ENSIT — Microservices Architecture** course.

The scope, responsibilities, and contracts of this service are defined in the
course materials. Refer to those before writing any code.

## Source monolith

The reference monolith you are splitting from:

- Repository: <https://github.com/alabenkhlifa/SOA>
- Branch: [`split_by_domain`](https://github.com/alabenkhlifa/SOA/tree/split_by_domain)

## Tech stack

- Java 17
- Spring Boot 3.4
- Spring Cloud 2024.0 — Config & Eureka client
- H2 (embedded)
- Gradle (Kotlin DSL)

## Prerequisites

- JDK 17

## Run

```bash
./gradlew bootRun
```

Default port: `8081`

## Build & test

```bash
./gradlew build
```

---

> Work the problem yourself. The point of the course is the design — not the code.
