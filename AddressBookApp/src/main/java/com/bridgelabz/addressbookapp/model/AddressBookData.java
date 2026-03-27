package com.bridgelabz.addressbookapp.model;

/**
 * UC3: Model class representing an Address Book record.
 * Acts as the domain entity used throughout the application layers.
 */
public class AddressBookData {

    private long personId;
    private String name;
    private String address;
    private String city;
    private String phoneNumber;

    public AddressBookData() {
    }

    public AddressBookData(long personId, String name, String address, String city, String phoneNumber) {
        this.personId = personId;
        this.name = name;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "AddressBookData{personId=" + personId
                + ", name='" + name + "'"
                + ", address='" + address + "'"
                + ", city='" + city + "'"
                + ", phoneNumber='" + phoneNumber + "'}";
    }
}
