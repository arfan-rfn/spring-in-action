# Licensing Service

A Spring Boot microservice for managing software licenses.

## Overview

This service handles CRUD operations for software licenses associated with organizations. It supports internationalization (i18n) with messages in English, Spanish, and Bengali.

# Database

## Running the database

```bash
docker compose up
```

The service uses PostgreSQL as its database. Here are the connection details:
- Host: localhost
- Port: 5435
- Database: development
- Username: postgres
- Password: postgres


The database configuration is managed through Spring Boot properties with the following settings:

- Hibernate DDL auto: none (schema managed manually)
- Show SQL: enabled
- Dialect: PostgreSQL 95
- Driver: org.postgresql.Driver


## Database Schema

The service uses a relational database with the following schema:

```sql
CREATE TABLE IF NOT EXISTS licenses (
    license_id VARCHAR(100) PRIMARY KEY,
    organization_id VARCHAR(100) NOT NULL,
	description VARCHAR(200),
	product_name VARCHAR(100) NOT NULL,
	license_type VARCHAR(100) NOT NULL
);
```

## Running the service

```bash
mvn install
mvn spring-boot:run
```

