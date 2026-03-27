package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import com.bridgelabz.addressbookapp.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * UC4: REST Controller with Service Layer injection.
 * All business logic is delegated to IAddressBookService via @Autowired.
 */
@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private IAddressBookService addressBookService;

    /**
     * GET all contacts
     */
    @GetMapping("/")
    public ResponseEntity<List<AddressBookData>> getAllContacts() {
        List<AddressBookData> contacts = addressBookService.getAllContacts();
        return ResponseEntity.ok(contacts);
    }

    /**
     * GET contact by ID
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<AddressBookData> getContactById(@PathVariable long id) {
        AddressBookData contact = addressBookService.getContactById(id);
        return ResponseEntity.ok(contact);
    }

    /**
     * POST - create new contact (accepts DTO, returns model)
     */
    @PostMapping("/create")
    public ResponseEntity<AddressBookData> createContact(@RequestBody AddressBookDTO contactDTO) {
        AddressBookData contact = addressBookService.createContact(contactDTO);
        return ResponseEntity.ok(contact);
    }

    /**
     * PUT - update contact by ID (accepts DTO, returns updated model)
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<AddressBookData> updateContact(@PathVariable long id, @RequestBody AddressBookDTO contactDTO) {
        AddressBookData updatedContact = addressBookService.updateContact(id, contactDTO);
        return ResponseEntity.ok(updatedContact);
    }

    /**
     * DELETE contact by ID
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable long id) {
        String message = addressBookService.deleteContact(id);
        return ResponseEntity.ok(message);
    }
}
