UC8: Logging Configuration Based on Environment

📌 Overview

This use case (UC8) focuses on setting up logging configurations for different environments (Development, Staging, and Production) using Spring Boot's application.properties. The goal is to control logging levels, output destinations (console or file), and patterns dynamically based on the active profile.

🛠 Steps to Implement Logging Based on Environment

1️⃣ Add the Required Dependency in pom.xml

Add the Spring Boot logging dependency to ensure proper logging configuration.

<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-logging</artifactId>
</dependency>

2️⃣ Define the Active Profile in application.properties

In the common application.properties file, specify the active profile as dev (default environment).

📍File: src/main/resources/application.properties

spring.profiles.active=dev

This means the application will use application-dev.properties unless another profile (staging or prod) is specified.

3️⃣ Create Logging Configurations for Each Environment

🔹 Development (application-dev.properties)

📍 File: src/main/resources/application-dev.properties


# Log everything (for debugging)

logging.level.root=DEBUG

# Print logs to the console

logging.file.name=logs/dev.log

logging.pattern.console=%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n

logging.pattern.file=%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n

🔹 Staging (application-staging.properties)

📍 File: src/main/resources/application-staging.properties



# Only log WARN and higher (to reduce noise)

logging.level.root=WARN

# Write logs to a staging log file

logging.file.name=logs/staging.log

logging.pattern.file=%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n

🔹 Production (application-prod.properties)

📍 File: src/main/resources/application-prod.properties


# Log only ERROR level messages

logging.level.root=ERROR

# Write logs to a production log file

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