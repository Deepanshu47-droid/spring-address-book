📖 Address Book App - UC5: Services Layer with In-Memory Storage

📝 Overview

In this use case, the Service Layer is now responsible for storing, updating, and deleting AddressBook data. Instead of persisting data to a database, we use an in-memory List to hold contact information. This setup will later be extended to use a database.

🛠️ Tech Stack

Java 17+

Spring Boot

Spring Web

Maven

🔥 Features Implemented

✅ Service Layer stores contacts in-memory

✅ CRUD operations are handled at the service level

✅ Data is temporarily stored in a List

✅ Separation of Concerns: Controller delegates logic to Service

✅ ResponseEntity used for consistent JSON responses

✅ CURL commands for testing

🚀 Setup Instructions

1️⃣ Spring Initializer Setup

Use Spring Initializr with the following configurations:

Project: Maven

Language: Java

Spring Boot Version: Latest Stable

Dependencies: Spring Web

2️⃣ Run the Application

mvn spring-boot:run  

🌍 REST API Endpoints

Method	Endpoint	Description

GET	/addressbook/service/contacts/get/all	Fetch all contacts

GET	/addressbook/service/contacts/get/{id}	Fetch contact by ID

POST	/addressbook/service/contacts/add	Add new contact

PUT	/addressbook/service/contacts/update/{id}	Update contact by ID

DELETE	/addressbook/service/contacts/delete/{id}	Delete contact by ID

🖥️ CURL Commands for Testing

📌 Get all contacts


curl -X GET http://localhost:8080/addressbook/service/contacts/get/all  

📌 Get contact by ID

curl -X GET http://localhost:8080/addressbook/service/contacts/get/1  

📌 Add a new contact

curl -X POST http://localhost:8080/addressbook/service/contacts/add \

-H "Content-Type: application/json" \

-d '{"name":"Raj","email":"raj@example.com","phone":"9876543210"}'  

📌 Update a contact

curl -X PUT http://localhost:8080/addressbook/service/contacts/update/1 \

-H "Content-Type: application/json" \

-d '{"name":"Gagan","email":"gagan@example.com","phone":"9123456789"}'  

📌 Delete a contact

curl -X DELETE http://localhost:8080/addressbook/service/contacts/delete/1  