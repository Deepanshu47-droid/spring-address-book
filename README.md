📖 UC2 - REST Controller with Database Connectivity

📌 Overview

This use case focuses on creating a REST Controller to demonstrate various HTTP methods while establishing MySQL database connectivity in the Address Book Spring Application. The goal is to ensure proper data transmission through REST API calls.

🛠️ 1. Spring Boot Project Setup

Use Spring Initializr (start.spring.io) to generate a Spring Boot project.

Include the following dependencies:

Spring Web (for REST APIs)

Spring Boot Starter Data JPA (for database connectivity)

MySQL Driver (for MySQL integration)

Download and extract the generated project.

🗄️ 2. MySQL Database Configuration

Create a MySQL database using:

CREATE DATABASE address_book_db;

Configure database credentials in src/main/resources/application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/address_book_db

spring.datasource.username=root

spring.datasource.password=your_password

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=true

🌍 3. Implementing REST Controller

Create a Contact entity with fields like id, name, email, phoneNumber.

Create a JPA Repository to interact with the database.

Implement a REST Controller with the following endpoints:

GET /contacts → Fetch all contacts

GET /contacts/{id} → Fetch contact by ID

POST /contacts → Add a new contact

PUT /contacts/{id} → Update a contact by ID

DELETE /contacts/{id} → Delete a contact

🧪 4. Testing REST API Using CURL

➡️ Fetch all contacts

curl -X GET http://localhost:8080/contacts

➡️ Fetch contact by ID

curl -X GET http://localhost:8080/contacts/1

➡️ Add a new contact

curl -X POST http://localhost:8080/contacts -H "Content-Type: application/json" -d '{"name": "John Doe", "email": "john@example.com", "phoneNumber": "9876543210"}'

➡️ Update a contact by ID

curl -X PUT http://localhost:8080/contacts/1 -H "Content-Type: application/json" -d '{"name": "John Updated", "email": "john.updated@example.com", "phoneNumber": "1234567890"}'

➡️ Delete a contact

curl -X DELETE http://localhost:8080/contacts/1

✅ Summary

✔️ Set up Spring Boot with MySQL

✔️ Configured database properties

✔️ Created REST Controller with CRUD operations

✔️ Tested REST API using CURL commands