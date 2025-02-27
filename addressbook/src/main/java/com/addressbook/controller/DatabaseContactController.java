package com.addressbook.controller;

import com.addressbook.dto.ContactDTO;
import com.addressbook.model.Contact;
import com.addressbook.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook/database/contacts")
public class DatabaseContactController {

    private final ContactService contactService;

    public DatabaseContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    // Get all contacts
    @GetMapping("/get/all")
    public ResponseEntity<List<Contact>> getAllContacts() {
        return ResponseEntity.ok(contactService.getAllContactsDb());
    }

    // Get contact by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable Long id) {
        Contact contact = contactService.getContactByIdDb(id);
        return (contact != null) ? ResponseEntity.ok(contact) : ResponseEntity.notFound().build();
    }

    // Add a new contact
    @PostMapping("/add")
    public ResponseEntity<String> addContact(@Valid @RequestBody ContactDTO contactDTO) {
        return ResponseEntity.ok(contactService.addContactDb(contactDTO));
    }

    // Update contact by ID
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateContact(@PathVariable Long id, @Valid @RequestBody ContactDTO contactDTO) {
        return ResponseEntity.ok(contactService.updateContactDb(id, contactDTO));
    }

    // Delete contact by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable Long id) {
        return ResponseEntity.ok(contactService.deleteContactDb(id));
    }
}
