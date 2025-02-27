📖 Address Book App - UC12: User-Friendly Error Handling

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