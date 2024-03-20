package com.contactbook.model;

import java.util.ArrayList;

public class ContactBookModel {
    private final String[] headers = { "Name", "Email", "Phone Number" };
    private final ArrayList<Contact> contacts = new ArrayList<>();

    public String[][] getContacts() {
        return contacts.stream()
                .map(Contact::toArray)
                .toArray(String[][]::new);
    }

    public String[] getHeaders() {
        return this.headers;
    }

    public void addContact(String name, String email, String phoneNumber) {
        contacts.add(new Contact(name, email, phoneNumber));
    }

    public void removeContact(int index) {
        contacts.remove(index);
    }
}
