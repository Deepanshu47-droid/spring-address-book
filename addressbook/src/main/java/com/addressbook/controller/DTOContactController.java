package com.addressbook.controller;

import com.addressbook.dto.ContactDTO;
import com.addressbook.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/addressbook/dto")
public class DTOContactController {
    private List<Contact> contacts = new ArrayList<>();

    @GetMapping("/contacts/get/all")
    public ResponseEntity<List<Contact>> getAllContacts() {
        log.info("Fetching all contacts...");
        return ResponseEntity.ok(contacts);
    }

    @GetMapping("/contacts/get/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable Long id) {
        log.info("Fetching contact with ID: {}", id);
        for (Contact contact : contacts) {
            if (contact.getId().equals(id)) {
                return ResponseEntity.ok(contact);
            }
        }
        log.error("Contact with ID {} not found!", id);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/contacts/add")
    public ResponseEntity<String> addContact(@RequestBody ContactDTO contactDTO) {
        Contact newContact = new Contact((long) (contacts.size() + 1), contactDTO.getName(), contactDTO.getEmail(), contactDTO.getPhone());
        contacts.add(newContact);
        log.info("New contact added: {}", newContact);
        return ResponseEntity.ok("Contact added successfully!");
    }

    @PutMapping("/contacts/update/{id}")
    public ResponseEntity<String> updateContact(@PathVariable Long id, @RequestBody ContactDTO contactDTO) {
        for (Contact contact : contacts) {
            log.info("Updating contact with ID: {}", id);
            if (contact.getId().equals(id)) {
                contact.setName(contactDTO.getName());
                contact.setEmail(contactDTO.getEmail());
                contact.setPhone(contactDTO.getPhone());
                log.info("Contact updated successfully: {}", contact);
                return ResponseEntity.ok("Contact updated successfully!");
            }
        }
        log.error("Contact with ID {} not found!", id);
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/contacts/delete/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable Long id) {
        log.info("Deleting contact with ID: {}", id);
        if (contacts.removeIf(contact -> contact.getId().equals(id))) {
            log.info("Contact with ID {} deleted successfully!", id);
            return ResponseEntity.ok("Contact deleted successfully!");
        }
        log.error("Contact with ID {} not found!", id);
        return ResponseEntity.notFound().build();
    }
}
