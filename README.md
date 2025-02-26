UC3: Introducing DTO and Model

Overview

This use case introduces DTO (Data Transfer Object) and Model to the Address Book App. The goal is to separate data representation from data processing while keeping the API structured.

Project Setup

Ensure you have Java 17+ installed.

Use Spring Boot with the following dependencies:

Spring Web

Spring Boot DevTools

Implementation Details

1️⃣ Create the Model (Contact.java)

Represents the stored contact details.

Fields: id, name, email, phone.

Uses Getters and Setters instead of Lombok.

2️⃣ Create the DTO (ContactDTO.java)

Used for data transfer between layers.

Fields: name, email, phone (excludes id).

3️⃣ Create the Controller (DTOContactController.java)

Implements REST APIs using ResponseEntity.

Manages a list of Contact objects.

API Endpoints and Testing (Using CURL)

📌 Fetch All Contacts

curl -X GET http://localhost:8080/addressbook/dto/contacts/get/all

📌 Add a New Contact

curl -X POST http://localhost:8080/addressbook/dto/contacts/add -H "Content-Type: application/json" -d '{"name":"John Doe","email":"john@example.com","phone":"1234567890"}'

📌 Fetch a Contact by ID

curl -X GET http://localhost:8080/addressbook/dto/contacts/get/1

📌 Update a Contact

curl -X PUT http://localhost:8080/addressbook/dto/contacts/update/1 -H "Content-Type: application/json" -d '{"name":"Jane Doe","email":"jane@example.com","phone":"9876543210"}'

📌 Delete a Contact

curl -X DELETE http://localhost:8080/addressbook/dto/contacts/delete/1

