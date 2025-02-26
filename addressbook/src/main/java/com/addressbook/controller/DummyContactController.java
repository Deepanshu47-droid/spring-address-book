package com.addressbook.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook/dummy")
public class DummyContactController {

    // Dummy GET Request - Fetch all contacts
    @GetMapping("/contacts/get/all")
    public String getAllDummyContacts() {
        return "Returning all contacts (Dummy Response)";
    }

    // Dummy POST Request - Add a new contact
    @PostMapping("/contacts/add")
    public String addDummyContact() {
        return "New contact added successfully (Dummy Response)";
    }

    // Dummy GET Request - Fetch contact by ID
    @GetMapping("/contacts/get/{id}")
    public String getDummyContactById(@PathVariable int id) {
        return "Returning contact with ID: " + id + " (Dummy Response)";
    }

    // Dummy PUT Request - Update contact by ID
    @PutMapping("/contacts/update/{id}")
    public String updateDummyContact(@PathVariable int id) {
        return "Updated contact with ID: " + id + " (Dummy Response)";
    }

    // Dummy DELETE Request - Delete contact by ID
    @DeleteMapping("/contacts/delete/{id}")
    public String deleteDummyContact(@PathVariable int id) {
        return "Deleted contact with ID: " + id + " (Dummy Response)";
    }
}
