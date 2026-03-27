package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * UC5: Service implementation with in-memory List storage.
 * Stores Address Book data in a local ArrayList.
 * Uses AtomicLong for safe auto-increment of person IDs.
 */
@Service
public class AddressBookService implements IAddressBookService {

    private final List<AddressBookData> contactList = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    @Override
    public List<AddressBookData> getAllContacts() {
        return contactList;
    }

    @Override
    public AddressBookData getContactById(long personId) {
        return contactList.stream()
                .filter(contact -> contact.getPersonId() == personId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public AddressBookData createContact(AddressBookDTO contactDTO) {
        AddressBookData contact = new AddressBookData(
                idCounter.getAndIncrement(),
                contactDTO.getName(),
                contactDTO.getAddress(),
                contactDTO.getCity(),
                contactDTO.getPhoneNumber()
        );
        contactList.add(contact);
        return contact;
    }

    @Override
    public AddressBookData updateContact(long personId, AddressBookDTO contactDTO) {
        AddressBookData existingContact = getContactById(personId);
        if (existingContact != null) {
            existingContact.setName(contactDTO.getName());
            existingContact.setAddress(contactDTO.getAddress());
            existingContact.setCity(contactDTO.getCity());
            existingContact.setPhoneNumber(contactDTO.getPhoneNumber());
            return existingContact;
        }
        return null;
    }

    @Override
    public String deleteContact(long personId) {
        AddressBookData contact = getContactById(personId);
        if (contact != null) {
            contactList.remove(contact);
            return "Contact with id " + personId + " deleted successfully";
        }
        return "Contact with id " + personId + " not found";
    }
}
