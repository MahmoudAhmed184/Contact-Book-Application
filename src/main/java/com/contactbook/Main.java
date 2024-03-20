package com.contactbook;

import com.contactbook.controller.ContactBookController;

public class Main {
    public static void main(String[] args) {
        ContactBookController contactBookController = new ContactBookController();
        contactBookController.initialize();
    }
}
