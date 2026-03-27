package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * UC4: Service implementation for Address Book.
 * Contains business logic, delegated from the controller.
 * Placeholder logic for now; UC5 will add in-memory list storage.
 */
@Service
public class AddressBookService implements IAddressBookService {

    @Override
    public List<AddressBookData> getAllContacts() {
        List<AddressBookData> contacts = new ArrayList<>();
        contacts.add(new AddressBookData(1L, "Sample Contact", "MG Road", "Bengaluru", "9876543210"));
        return contacts;
    }

    @Override
    public AddressBookData getContactById(long personId) {
        return new AddressBookData(personId, "Sample Contact " + personId, "MG Road", "Bengaluru", "9876543210");
    }

    @Override
    public AddressBookData createContact(AddressBookDTO contactDTO) {
        return new AddressBookData(1L, contactDTO.getName(),
                contactDTO.getAddress(), contactDTO.getCity(), contactDTO.getPhoneNumber());
    }

    @Override
    public AddressBookData updateContact(long personId, AddressBookDTO contactDTO) {
        return new AddressBookData(personId, contactDTO.getName(),
                contactDTO.getAddress(), contactDTO.getCity(), contactDTO.getPhoneNumber());
    }

    @Override
    public String deleteContact(long personId) {
        return "Contact with id " + personId + " deleted successfully";
    }
}
