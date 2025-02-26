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