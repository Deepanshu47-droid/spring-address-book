📜 UC7: Logging with Lombok in Address Book

📝 Overview

In this use case, we integrate Lombok to simplify logging in the application. By using the @Slf4j annotation, we can enable logging without manually creating logger instances. The logging levels, file locations, and patterns are configured in the application.properties file based on the active profile (dev, staging, production).

🔧 Steps to Implement

1️⃣ Add Lombok Dependency

Ensure that Lombok is added to your pom.xml file:

<dependency>

<groupId>org.projectlombok</groupId>

<artifactId>lombok</artifactId>

<version>1.18.28</version>

<scope>provided</scope>

</dependency>

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

log.info("Info message");
log.debug("Debug message");
log.error("Error message");

The logging behavior (console or file output) depends on profile settings.

✅ Testing

After setting up, verify logs by running the application and checking the console or log files based on profile settings.

🎯 Summary

✔ Integrated Lombok for simplified logging

✔ Used @Slf4j to avoid manual logger creation

✔ Defined logging properties per environment

✔ Configured application.properties to set logging behavior

🚀 Now, logging is easy and efficient in our Address Book application!