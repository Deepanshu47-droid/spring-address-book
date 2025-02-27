UC11 - User-Friendly Error Response for Validation Failures

Overview

In this use case, we enhance error handling by creating a centralized exception handling class using @ControllerAdvice. This ensures that validation errors return structured, user-friendly error messages instead of generic responses.

Steps to Implement

Create Exception Handler Class

   Create a new class named GlobalExceptionHandler in the com.addressbook.exception package.

   Annotate it with @ControllerAdvice to handle exceptions globally.

Handle Validation Errors

   Implement an @ExceptionHandler for MethodArgumentNotValidException to handle validation failures.
   Extract meaningful error messages from the exception and return them in a structured response.

Modify the Controller to Enforce Validation

   Ensure that DTO classes (like ContactDTO) contain validation annotations such as @NotEmpty and @Pattern.

   The controller should use @Valid before @RequestBody to trigger validation.

Update Controller to Use Validation

Expected Error Response for Invalid Input

When a request contains invalid data (e.g., an empty name field), the API returns:


{
"name": "Name cannot be empty",
"email": "Email cannot be empty"
}
