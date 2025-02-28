
---------------------------------------------------------------------------------------------------------------------------------------
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
----------------------------------------------------------------------------------------------------------------------------------------
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
----------------------------------------------------------------------------------------------------------------------------------------
📖 Address Book App - UC4: Introducing Services Layer 📝 Overview In this update, we introduce the Service Layer to manage the Model and separate concerns from the Controller Layer. Now, the Controller will delegate business logic to the Service Layer, making the application more modular and maintainable.

🛠️ Tech Stack Java 17+ Spring Boot Spring Web Spring Data JPA MySQL Maven 🔥 Features Implemented ✅ Controller delegates requests to the Service Layer ✅ Service Layer handles business logic ✅ Dependency Injection using @Autowired ✅ REST API endpoints for CRUD operations ✅ ResponseEntity used to return JSON responses ✅ CURL Commands for testing

🚀 Setup Instructions 1️⃣ Spring Initializer Setup Use Spring Initializr with the following configurations:

Project: Maven Language: Java Spring Boot Version: Latest Stable Dependencies: Spring Web, Spring Data JPA, MySQL Driver 2️⃣ Database Configuration Modify application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/addressbook_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
3️⃣ Run the Application

mvn spring-boot:run
🌍 REST API Endpoints Method Endpoint Description GET /addressbook/service/contacts/get/all Fetch all contacts GET /addressbook/service/contacts/get/{id} Fetch contact by ID POST /addressbook/service/contacts/add Add new contact PUT /addressbook/service/contacts/update/{id} Update contact by ID DELETE /addressbook/service/contacts/delete/{id} Delete contact by ID 🖥️ CURL Commands for Testing 📌 Get all contacts

curl -X GET http://localhost:8080/addressbook/service/contacts/get/all
📌 Get contact by ID

curl -X GET http://localhost:8080/addressbook/service/contacts/get/1
📌 Add a new contact

curl -X POST http://localhost:8080/addressbook/service/contacts/add
-H "Content-Type: application/json"
-d '{"name":"John Doe","email":"john.doe@example.com","phone":"9876543210"}'
📌 Update a contact

curl -X PUT http://localhost:8080/addressbook/service/contacts/update/1
-H "Content-Type: application/json"
-d '{"name":"John Updated","email":"updated@example.com","phone":"9123456789"}'
📌 Delete a contact

curl -X DELETE http://localhost:8080/addressbook/service/contacts/delete/1
🎯 Summary In UC4, we have successfully introduced the Service Layer, making our application more structured and maintainable. The Controller now focuses only on handling requests and responses, while business logic is moved to the Service Layer.
----------------------------------------------------------------------------------------------------------------------------------------
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

Method Endpoint Description

GET /addressbook/service/contacts/get/all Fetch all contacts

GET /addressbook/service/contacts/get/{id} Fetch contact by ID

POST /addressbook/service/contacts/add Add new contact

PUT /addressbook/service/contacts/update/{id} Update contact by ID

DELETE /addressbook/service/contacts/delete/{id} Delete contact by ID

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
----------------------------------------------------------------------------------------------------------------------------------------
📖 Address Book App - UC6

🚀 Use Case 6: Using Lombok for DTO

📌 Objective

In this use case, we integrate Lombok to auto-generate getters, setters, constructors, and other boilerplate code for our DTO (Data Transfer Object).

🔧 Steps to Implement

1️⃣ Download and Install Lombok

Eclipse/IntelliJ: Download the Lombok JAR and run it to integrate with the IDE.

VS Code: Install the Lombok Extension.

2️⃣ Add Lombok Dependency to the pom.xml file to enable Lombok in the project.

3️⃣ Use Lombok Annotations in DTO and Model classes:

@Data – Generates getters, setters, toString(), equals(), and hashCode().

@AllArgsConstructor – Generates a constructor with all fields.

@NoArgsConstructor – Generates a no-args constructor.

✅ Benefits of Using Lombok

✅ Reduces Boilerplate Code – No need to write getters, setters, and constructors manually.

✅ Improves Code Readability – Clean and concise DTO and Model classes.

✅ Easier Maintenance – Less code to modify when adding new fields.

🚀 Summary

✅ Lombok installed and configured.

✅ DTO and Model classes now use Lombok annotations.

✅ Less boilerplate code, making the codebase cleaner and more maintainable.
----------------------------------------------------------------------------------------------------------------------------------------
📜 UC7: Logging with Lombok in Address Book

📝 Overview

In this use case, we integrate Lombok to simplify logging in the application. By using the @Slf4j annotation, we can enable logging without manually creating logger instances. The logging levels, file locations, and patterns are configured in the application.properties file based on the active profile (dev, staging, production).

🔧 Steps to Implement

1️⃣ Add Lombok Dependency

Ensure that Lombok is added to your pom.xml file:

org.projectlombok

lombok

1.18.28

provided

2️⃣ Install Lombok in IDE

Eclipse/IntelliJ: Download and run the Lombok JAR to install the plugin.

VS Code: Install the Lombok extension from the marketplace.

📂 Configuration

🌍 Define Active Profile

In the common application.properties, set the active profile:

spring.profiles.active=dev

🏗 Create Profile-Specific Configurations

application-dev.properties (for development)

application-prod.properties (for production)

Each profile file defines logging levels, file paths, and patterns.

📌 Using Lombok for Logging

Use the @Slf4j annotation in your classes to enable logging:

🔍 Logging Levels

Lombok logging supports different levels:

log.info("Info message"); log.debug("Debug message"); log.error("Error message");

The logging behavior (console or file output) depends on profile settings.

✅ Testing

After setting up, verify logs by running the application and checking the console or log files based on profile settings.

🎯 Summary

✔ Integrated Lombok for simplified logging

✔ Used @Slf4j to avoid manual logger creation

✔ Defined logging properties per environment

✔ Configured application.properties to set logging behavior

🚀 Now, logging is easy and efficient in our Address Book application!
----------------------------------------------------------------------------------------------------------------------------------------
UC8: Logging Configuration Based on Environment

📌 Overview

This use case (UC8) focuses on setting up logging configurations for different environments (Development, Staging, and Production) using Spring Boot's application.properties. The goal is to control logging levels, output destinations (console or file), and patterns dynamically based on the active profile.

🛠 Steps to Implement Logging Based on Environment

1️⃣ Add the Required Dependency in pom.xml

Add the Spring Boot logging dependency to ensure proper logging configuration.

org.springframework.boot spring-boot-starter-logging
2️⃣ Define the Active Profile in application.properties

In the common application.properties file, specify the active profile as dev (default environment).

📍File: src/main/resources/application.properties

spring.profiles.active=dev

This means the application will use application-dev.properties unless another profile (staging or prod) is specified.

3️⃣ Create Logging Configurations for Each Environment

🔹 Development (application-dev.properties)

📍 File: src/main/resources/application-dev.properties

Log everything (for debugging)
logging.level.root=DEBUG

Print logs to the console
logging.file.name=logs/dev.log

logging.pattern.console=%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n

logging.pattern.file=%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n

🔹 Staging (application-staging.properties)

📍 File: src/main/resources/application-staging.properties

Only log WARN and higher (to reduce noise)
logging.level.root=WARN

Write logs to a staging log file
logging.file.name=logs/staging.log

logging.pattern.file=%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n

🔹 Production (application-prod.properties)

📍 File: src/main/resources/application-prod.properties

Log only ERROR level messages
logging.level.root=ERROR

Write logs to a production log file
logging.file.name=logs/prod.log

logging.pattern.file=%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n

4️⃣ Use Lombok for Logging

In your Spring Boot service and controllers, use Lombok's @Slf4j annotation for logging.

Example Usage in a Service Class

📍 File: src/main/java/com/addressbook/service/ContactService.java

5️⃣ Running the Application with Different Profiles

To run the application with a specific profile, use:

For Development Mode:

mvn spring-boot:run -Dspring-boot.run.profiles=dev

For Staging Mode:

mvn spring-boot:run -Dspring-boot.run.profiles=staging

For Production Mode:

mvn spring-boot:run -Dspring-boot.run.profiles=prod

Alternatively, you can set the profile in IDE (IntelliJ, Eclipse, VS Code) by adding:

-Dspring.profiles.active=prod

in the Run Configurations → VM Options.

📌 Summary

Configured logging levels dynamically for Dev, Staging, and Prod.

Used Lombok's @Slf4j for clean logging.

Separated environment-specific properties into different application-*.properties files.

Allowed switching environments using spring.profiles.active.

This setup ensures logs are filtered and stored correctly based on the environment, improving debugging and monitoring in production! 🚀
----------------------------------------------------------------------------------------------------------------------------------------
📌 UC10: Add Validation to Name Field

🚀 Objective

Ensure the name field in the ContactDTO is mandatory.

Add pattern validation so only letters and spaces are allowed.

Validation should apply to both Create (POST) and Update (PUT) REST Calls.

🛠 Implementation Steps

1️⃣ Add Validation to ContactDTO

2️⃣ Modify Controller to Handle Validation Errors

3️⃣ Enable Detailed Error Messages in application.properties

server.error.include-message=always

server.error.include-binding-errors=always

✅ Testing the API

🔹 Valid Input (Should Succeed)

📌 POST /addressbook/database/contacts/add

{ "name": "Deepanshu malviya", "email": "Deepannshu@email.com", "phone": "9876543210" }

✅ Response (200 OK)

{ "message": "Contact added successfully!" }

🔹 Invalid Input (Should Fail)

📌 POST /addressbook/database/contacts/add

{ "name": "Deep123", "email": "deep@gmail.com", "phone": "98765943940" }

❌ Response (400 Bad Request)

{ "status": 400, "error": "Bad Request", "message": "Name must contain only letters" }

🎯 Expected Outcome

If the name field is empty, it will return "Name cannot be empty".

If the name contains numbers or special characters, it will return "Name must contain only letters".

🛠 Commands to Run the Project

Run Application

mvn clean spring-boot:run

Test API Using Postman or CURL
----------------------------------------------------------------------------------------------------------------------------------------
UC11 - User-Friendly Error Response for Validation Failures

Overview

In this use case, we enhance error handling by creating a centralized exception handling class using @ControllerAdvice. This ensures that validation errors return structured, user-friendly error messages instead of generic responses.

Steps to Implement

Create Exception Handler Class

Create a new class named GlobalExceptionHandler in the com.addressbook.exception package.

Annotate it with @ControllerAdvice to handle exceptions globally.

Handle Validation Errors

Implement an @ExceptionHandler for MethodArgumentNotValidException to handle validation failures. Extract meaningful error messages from the exception and return them in a structured response.

Modify the Controller to Enforce Validation

Ensure that DTO classes (like ContactDTO) contain validation annotations such as @NotEmpty and @Pattern.

The controller should use @Valid before @RequestBody to trigger validation.

Update Controller to Use Validation

Expected Error Response for Invalid Input

When a request contains invalid data (e.g., an empty name field), the API returns:

{ "name": "Name cannot be empty", "email": "Email cannot be empty" }
----------------------------------------------------------------------------------------------------------------------------------------

UC12: User-Friendly Error Handling

🎯 Objective

Enhance the Address Book application by throwing user-friendly errors when an Address Book ID is not found and handling such exceptions gracefully.

🛠️ Features Implemented

✅ Custom Exception for missing Address Book ID 🛑

✅ Global Exception Handler using @ExceptionHandler 🎯

✅ Proper Logging for better debugging 📜

✅ Tested All API Endpoints using cURL/Postman 🧪

📌 Custom Exception: AddressBookException

A custom exception is created to handle cases where an Address Book ID is not found.

🛠 Exception Handling using @ExceptionHandler

A global exception handler ensures that meaningful error messages are returned to the client.

🏗 Service Layer Implementation

Now, the Service Layer throws AddressBookException when a contact ID is not found.

🌍 Controller Layer (ContactController)

Updated DELETE API to return proper responses.

🔥 Testing the API Endpoints

All APIs were tested using cURL/Postman.

1️⃣ Create Contact (POST)

curl -X POST "http://localhost:8080/addressbook/add" -H "Content-Type: application/json" -d '{"name":"John Doe","email":"john@example.com","phone":"1234567890"}'

2️⃣ Get All Contacts (GET)

curl -X GET "http://localhost:8080/addressbook/getAll"

3️⃣ Get Contact by ID (GET)

curl -X GET "http://localhost:8080/addressbook/get/1"

4️⃣ Update Contact (PUT)

curl -X PUT "http://localhost:8080/addressbook/update/1" -H "Content-Type: application/json" -d '{"name":"Jane Doe","email":"jane@example.com","phone":"9876543210"}'

5️⃣ Delete Contact (DELETE)

curl -X DELETE "http://localhost:8080/addressbook/delete/1"

📌 If the ID does not exist, the API will return:

{
"message": "Address Book ID 1 not found!"
}

🏆 Conclusion

🎯 Implemented user-friendly error handling when a contact ID is not found.

🚀 Ensured smooth API responses using @ExceptionHandler.

✅ Successfully tested GET, POST, PUT, and DELETE calls.

🔥 Now, your Address Book App is robust and handles errors gracefully! 🎉
