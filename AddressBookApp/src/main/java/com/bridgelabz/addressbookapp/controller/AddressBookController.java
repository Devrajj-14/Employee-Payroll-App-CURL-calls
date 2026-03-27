package com.bridgelabz.addressbookapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * UC2: REST Controller demonstrating all HTTP methods for Address Book.
 * Simple controller returning string messages to demonstrate connectivity.
 */
@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    /**
     * GET all contacts
     */
    @GetMapping("/")
    public ResponseEntity<String> getAllContacts() {
        return ResponseEntity.ok("GET: Address Book Service is running - returning all contacts");
    }

    /**
     * GET contact by ID
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<String> getContactById(@PathVariable long id) {
        return ResponseEntity.ok("GET: Fetching contact with id: " + id);
    }

    /**
     * POST - create new contact
     */
    @PostMapping("/create")
    public ResponseEntity<String> createContact(@RequestBody String contactData) {
        return ResponseEntity.ok("POST: Creating contact with data: " + contactData);
    }

    /**
     * PUT - update contact by ID
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateContact(@PathVariable long id, @RequestBody String contactData) {
        return ResponseEntity.ok("PUT: Updating contact with id " + id + " with data: " + contactData);
    }

    /**
     * DELETE contact by ID
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable long id) {
        return ResponseEntity.ok("DELETE: Deleting contact with id: " + id);
    }
}
