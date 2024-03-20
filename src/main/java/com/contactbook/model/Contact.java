package com.contactbook.model;

public class Contact {
    private String name;
    private String email;
    private String phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phone) {
        this.phoneNumber = phone;
    }

    public String[] toArray() {
        return new String[] { name, email, phoneNumber };
    }

    public Contact(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phone;
    }
}
