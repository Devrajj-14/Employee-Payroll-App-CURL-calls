package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;

import java.util.List;

/**
 * UC4: Service interface for Address Book operations.
 * Defines the contract for business logic layer.
 */
public interface IAddressBookService {

    /**
     * Get all contacts
     */
    List<AddressBookData> getAllContacts();

    /**
     * Get contact by ID
     */
    AddressBookData getContactById(long personId);

    /**
     * Create a new contact from DTO
     */
    AddressBookData createContact(AddressBookDTO contactDTO);

    /**
     * Update an existing contact by ID from DTO
     */
    AddressBookData updateContact(long personId, AddressBookDTO contactDTO);

    /**
     * Delete contact by ID
     */
    String deleteContact(long personId);
}
