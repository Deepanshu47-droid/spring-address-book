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

{
"name": "Deepanshu malviya",
"email": "Deepannshu@email.com",
"phone": "9876543210"
}

✅ Response (200 OK)

{
"message": "Contact added successfully!"
}

🔹 Invalid Input (Should Fail)

📌 POST /addressbook/database/contacts/add

{
"name": "Deep123",
"email": "deep@gmail.com",
"phone": "98765943940"
}

❌ Response (400 Bad Request)

{
"status": 400,
"error": "Bad Request",
"message": "Name must contain only letters"
}

🎯 Expected Outcome

If the name field is empty, it will return "Name cannot be empty".

If the name contains numbers or special characters, it will return "Name must contain only letters".

🛠 Commands to Run the Project

Run Application

mvn clean spring-boot:run

Test API Using Postman or CURL