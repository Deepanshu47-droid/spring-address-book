package com.addressbook.service;

import com.addressbook.dto.ContactDTO;
import com.addressbook.model.Contact;
import com.addressbook.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ContactService {
    private List<Contact> contacts = new ArrayList<>();

    private final ContactRepository contactRepository;

    // Get All Contacts
    public List<Contact> getAllContacts() {

        log.info("Fetching all contacts...");
        return contacts;
    }

    // Get Contact by ID
    public Contact getContactById(Long id) {
        log.info("Fetching contact with ID: {}", id);
        return contacts.stream().filter(contact -> contact.getId().equals(id)).findFirst().orElse(null);
    }

    // Add New Contact
    public String addContact(ContactDTO contactDTO) {
        Contact newContact = new Contact((long) (contacts.size() + 1), contactDTO.getName(), contactDTO.getEmail(), contactDTO.getPhone());
        contacts.add(newContact);
        log.info("Added new contact: {}", newContact);
        return "Contact added successfully!";
    }

    // Update Contact
    public String updateContact(Long id, ContactDTO contactDTO) {
        for (Contact contact : contacts) {
            if (contact.getId().equals(id)) {
                log.info("Updating contact with ID: {}", id);
                contact.setName(contactDTO.getName());
                contact.setEmail(contactDTO.getEmail());
                contact.setPhone(contactDTO.getPhone());
                log.info("Contact updated: {}", contact);
                return "Contact updated successfully!";
            }
        }
        log.error("Contact with ID {} not found!", id);
        return "Contact not found!";
    }

    // Delete Contact
    public String deleteContact(Long id) {
        boolean removed = contacts.removeIf(contact -> contact.getId().equals(id));
        if (removed) {
            log.info("Deleted contact with ID: {}", id);
            return "Contact deleted successfully!";
        } else {
            log.error("Failed to delete. Contact with ID {} not found!", id);
            return "Contact not found!";
        }
    }

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    // Get All Contacts
    public List<Contact> getAllContactsDb() {
        log.info("Fetching all contacts from database...");
        return contactRepository.findAll();
    }

    // Get Contact by ID
    public Contact getContactByIdDb(Long id) {
        log.info("Fetching contact with ID from database: {}", id);
        return contactRepository.findById(id).orElse(null);
    }

    // Add New Contact
    public String addContactDb(ContactDTO contactDTO) {
        Contact newContact = new Contact(null, contactDTO.getName(), contactDTO.getEmail(), contactDTO.getPhone());
        contactRepository.save(newContact);
        log.info("Added new contact to database: {}", newContact);
        return "Contact added successfully to database!";
    }

    // Update Contact
    public String updateContactDb(Long id, ContactDTO contactDTO) {
        Optional<Contact> contactOptional = contactRepository.findById(id);
        if (contactOptional.isPresent()) {
            Contact contact = contactOptional.get();
            log.info("Updating contact with ID from database: {}", id);
            contact.setName(contactDTO.getName());
            contact.setEmail(contactDTO.getEmail());
            contact.setPhone(contactDTO.getPhone());
            contactRepository.save(contact);
            return "Contact updated successfully in database!";
        } else {
            log.error("Contact with ID {} not found in database!", id);
            return "Contact not found in database!";
        }
    }

    // Delete Contact
    public String deleteContactDb(Long id) {
        if (contactRepository.existsById(id)) {
            contactRepository.deleteById(id);
            log.info("Deleted contact with ID from database: {}", id);
            return "Contact deleted successfully from database!";
        } else {
            log.error("Failed to delete. Contact with ID {} not found in database!", id);
            return "Contact not found in database!";
        }
    }
}

