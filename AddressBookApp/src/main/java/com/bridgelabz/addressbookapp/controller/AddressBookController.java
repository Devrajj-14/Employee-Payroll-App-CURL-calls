package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * UC3: REST Controller updated to use AddressBookDTO and AddressBookData model.
 * Uses ResponseEntity for all responses.
 */
@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    /**
     * GET all contacts
     */
    @GetMapping("/")
    public ResponseEntity<List<AddressBookData>> getAllContacts() {
        List<AddressBookData> contacts = new ArrayList<>();
        contacts.add(new AddressBookData(1L, "Sample Contact", "MG Road", "Bengaluru", "9876543210"));
        return ResponseEntity.ok(contacts);
    }

    /**
     * GET contact by ID
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<AddressBookData> getContactById(@PathVariable long id) {
        AddressBookData contact = new AddressBookData(id, "Sample Contact " + id, "MG Road", "Bengaluru", "9876543210");
        return ResponseEntity.ok(contact);
    }

    /**
     * POST - create new contact (accepts DTO, returns model)
     */
    @PostMapping("/create")
    public ResponseEntity<AddressBookData> createContact(@RequestBody AddressBookDTO contactDTO) {
        AddressBookData contact = new AddressBookData(1L, contactDTO.getName(),
                contactDTO.getAddress(), contactDTO.getCity(), contactDTO.getPhoneNumber());
        return ResponseEntity.ok(contact);
    }

    /**
     * PUT - update contact by ID (accepts DTO, returns updated model)
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<AddressBookData> updateContact(@PathVariable long id, @RequestBody AddressBookDTO contactDTO) {
        AddressBookData updatedContact = new AddressBookData(id, contactDTO.getName(),
                contactDTO.getAddress(), contactDTO.getCity(), contactDTO.getPhoneNumber());
        return ResponseEntity.ok(updatedContact);
    }

    /**
     * DELETE contact by ID
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable long id) {
        return ResponseEntity.ok("Contact with id " + id + " deleted successfully");
    }
}
