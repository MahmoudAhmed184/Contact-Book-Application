package com.contactbook.controller;

import com.contactbook.model.ContactBookModel;
import com.contactbook.view.ContactBookView;

public class ContactBookController {
    private ContactBookModel contactBookModel;
    private ContactBookView contactBookView;

    public ContactBookController() {
        this.contactBookModel = new ContactBookModel();
        this.contactBookView = new ContactBookView(contactBookModel);
    }

    public void initialize() {
        contactBookView.addInsertListener(e -> insertContact());
        contactBookView.addClearListener(e -> contactBookView.clearTextFields());
        contactBookView.addDeleteListener(e -> deleteContact());
        contactBookView.setVisible(true);
    }

    private void insertContact() {
        String name = contactBookView.getName();
        String email = contactBookView.getEmail();
        String phoneNumber = contactBookView.getPhoneNumber();
        if (name.isBlank() || email.isBlank() || phoneNumber.isBlank()) {
            contactBookView.displayErrorMessage("Please enter all fields", "Try again");
        } else {
            contactBookView.clearTextFields();
            contactBookModel.addContact(name, email, phoneNumber);
            contactBookView.updateTable();
        }
    }

    private void deleteContact() {
        int index = contactBookView.getSelectedRow();
        if (index == -1) {
            contactBookView.displayErrorMessage("Please select a row to delete", "Try again");
        } else {
            contactBookModel.removeContact(index);
            contactBookView.updateTable();
        }
    }
}
