# Curierat - Courier Management System

A Spring Boot web application for managing courier orders and their delivery statuses.

## Tech Stack

| Layer | Technology |
|---|---|
| Framework | Spring Boot 2.5.5 |
| Language | Java 11 |
| Database | MySQL |
| ORM | Spring Data JPA / Hibernate |
| Templates | Mustache |
| DB Migrations | Liquibase 4.5.0 |
| Utilities | Lombok |

## Project Structure

```
src/main/java/com/curierat/curier/
├── CurierApplication.java          # Application entry point
├── AppConfig.java                  # Spring configuration
├── controller/
│   ├── AppController.java          # Home page controller
│   └── ComandController.java       # Order management controller
├── exception/
│   └── ResourceNotFoundException.java
├── model/
│   ├── Comanda.java                # Order entity
│   └── Status.java                 # Delivery status entity
└── repository/
    ├── ComandRepositoriu.java       # Order repository
    └── StatusRepositoriu.java      # Status repository
```

## Domain Model

### Comanda (Order)
Mapped to the `comenzi` table.

| Field | Type | Description |
|---|---|---|
| `id` | int | Primary key, auto-increment |
| `addresa_destinatorului` | String | Recipient address |
| `adresa_expidetor` | String | Sender address |
| `status` | List\<Status\> | Order status history (one-to-many) |

### Status
Mapped to the `status` table.

| Field | Type | Description |
|---|---|---|
| `id` | int | Primary key, auto-increment |
| `status` | String | Status description (max 50 chars) |
| `data` | Date | Status timestamp |
| `comanda` | Comanda | Parent order (many-to-one FK) |

## API Endpoints

| Method | Path | Description |
|---|---|---|
| GET | `/` | Home page |
| GET | `/comenzi` | List all orders |
| GET | `/comenzi/comanda/{id}` | View a specific order with statuses |
| GET | `/comenzi/status/{id}/add` | Update order status |

## Database Migrations

Liquibase is used for schema management. The changelog is located at:

```
src/main/resources/db/changelog/db.changelog-master.xml
```

Changesets applied in order:
1. `comanda` — Creates the `Comanda` table
2. `status` — Creates the `status` table with a foreign key to `Comanda`
3. `add_autoincrement` — Adds auto-increment to the `comenzi.id` column

## Prerequisites

- Java 11+
- Maven 3.6+
- MySQL server running on `localhost:3306`

## Database Setup

Create the database before running the application:

```sql
CREATE DATABASE curierat;
```

The application connects using the following defaults (configurable in `application.properties`):

```
URL:      jdbc:mysql://localhost:3306/curierat
Username: root
Password: root
```

> **Note:** Update `src/main/resources/application.properties` with your own credentials before running.

## Running the Application

Using the Maven wrapper:

```bash
# Windows
mvnw.cmd spring-boot:run

# Linux / macOS
./mvnw spring-boot:run
```

Or build and run the JAR:

```bash
mvnw.cmd package
java -jar target/curier-0.0.1-SNAPSHOT.jar
```

The application starts on **http://localhost:8080** by default.

## Running Tests

```bash
mvnw.cmd test
```

## Configuration

All configuration is in `src/main/resources/application.properties`:

| Property | Default | Description |
|---|---|---|
| `spring.datasource.url` | `jdbc:mysql://localhost:3306/curierat` | Database URL |
| `spring.datasource.username` | `root` | DB username |
| `spring.datasource.password` | `root` | DB password |
| `spring.jpa.hibernate.ddl-auto` | `none` | Schema managed by Liquibase |
| `spring.liquibase.change-log` | `classpath:/db/changelog/db.changelog-master.xml` | Liquibase changelog path |
