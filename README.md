📖 Address Book App - UC4: Introducing Services Layer
📝 Overview
In this update, we introduce the Service Layer to manage the Model and separate concerns from the Controller Layer. Now, the Controller will delegate business logic to the Service Layer, making the application more modular and maintainable.

🛠️ Tech Stack
Java 17+
Spring Boot
Spring Web
Spring Data JPA
MySQL
Maven
🔥 Features Implemented
✅ Controller delegates requests to the Service Layer
✅ Service Layer handles business logic
✅ Dependency Injection using @Autowired
✅ REST API endpoints for CRUD operations
✅ ResponseEntity used to return JSON responses
✅ CURL Commands for testing

🚀 Setup Instructions
1️⃣ Spring Initializer Setup
Use Spring Initializr with the following configurations:

Project: Maven
Language: Java
Spring Boot Version: Latest Stable
Dependencies: Spring Web, Spring Data JPA, MySQL Driver
2️⃣ Database Configuration
Modify application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/addressbook_db  
spring.datasource.username=root  
spring.datasource.password=your_password  
spring.jpa.hibernate.ddl-auto=update  
spring.jpa.show-sql=true  
3️⃣ Run the Application

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
-d '{"name":"John Doe","email":"john.doe@example.com","phone":"9876543210"}'  
📌 Update a contact

curl -X PUT http://localhost:8080/addressbook/service/contacts/update/1 \
-H "Content-Type: application/json" \
-d '{"name":"John Updated","email":"updated@example.com","phone":"9123456789"}'  
📌 Delete a contact

curl -X DELETE http://localhost:8080/addressbook/service/contacts/delete/1  
🎯 Summary
In UC4, we have successfully introduced the Service Layer, making our application more structured and maintainable. The Controller now focuses only on handling requests and responses, while business logic is moved to the Service Layer.