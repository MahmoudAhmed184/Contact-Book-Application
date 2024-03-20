package com.contactbook.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import com.contactbook.model.ContactBookModel;

public class ContactBookView extends JFrame {
    private JButton insertButton, clearButton, deleteButton;
    private JTextField nameField, emailField, phoneNumberField;
    private JTable tableContacts;
    private DefaultTableModel model;
    private ContactBookModel contactBookModel;

    public ContactBookView(ContactBookModel contactBookModel) {
        this.contactBookModel = contactBookModel;
        initialize();
    }

    private void initialize() {
        JLabel myContactsLabel = new JLabel("My Contacts");
        myContactsLabel.setFont(new Font("Segue Print", Font.BOLD, 24));
        myContactsLabel.setBounds(465, 10, 150, 30);

        this.add(myContactsLabel);
        this.add(createContactInformationPanel());
        this.add(createTablePanel());

        this.setTitle("Contacts Book");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(0x9370db));
        this.setSize(1080, 720);
    }

    private JLabel createLabel(String name, Bounds bounds, Font font) {
        JLabel label = new JLabel(name);
        label.setBounds(bounds.x, bounds.y, bounds.width, bounds.height);
        label.setFont(font);
        return label;
    }

    private JTextField createTextField(Bounds bounds, Font font) {
        JTextField textField = new JTextField();
        textField.setBounds(bounds.x, bounds.y, bounds.width, bounds.height);
        textField.setFont(font);
        return textField;
    }

    private JButton createButton(String name, Bounds bounds) {
        JButton button = new JButton(name);
        button.setBounds(bounds.x, bounds.y, bounds.width, bounds.height);
        return button;
    }

    private JPanel createContactInformationPanel() {
        final Font DEFAULT_FONT = new Font("Segue Print", Font.BOLD, 16);

        JPanel contactsPanel = new JPanel();
        contactsPanel.setLayout(null);
        contactsPanel.setBounds(0, 200, 380, 380);
        contactsPanel.setBackground(new Color(0x9370db));

        contactsPanel.add(createLabel("Contacts", new Bounds(10, 0, 370, 30), DEFAULT_FONT));

        contactsPanel.add(createLabel("Name", new Bounds(10, 60, 370, 30), DEFAULT_FONT));
        contactsPanel.add(createLabel("Email", new Bounds(10, 120, 370, 30), DEFAULT_FONT));
        contactsPanel.add(createLabel("Phone", new Bounds(10, 180, 370, 30), DEFAULT_FONT));

        nameField = createTextField(new Bounds(70, 60, 300, 30), DEFAULT_FONT);
        contactsPanel.add(nameField);

        emailField = createTextField(new Bounds(70, 120, 300, 30), DEFAULT_FONT);
        contactsPanel.add(emailField);

        phoneNumberField = createTextField(new Bounds(70, 180, 300, 30), DEFAULT_FONT);
        contactsPanel.add(phoneNumberField);

        insertButton = createButton("Insert", new Bounds(50, 240, 120, 50));
        contactsPanel.add(insertButton);
        clearButton = createButton("Clear", new Bounds(210, 240, 120, 50));
        contactsPanel.add(clearButton);
        deleteButton = createButton("Delete", new Bounds(110, 310, 140, 50));
        contactsPanel.add(deleteButton);
        return contactsPanel;
    }

    private JPanel createTablePanel() {
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new GridLayout(1, 1));
        tablePanel.setBounds(420, 200, 640, 480);
        tablePanel.setBackground(new Color(0x9370db));
        tablePanel.add(createTable());
        return tablePanel;
    }

    private JScrollPane createTable() {
        model = new DefaultTableModel(contactBookModel.getContacts(), contactBookModel.getHeaders());
        tableContacts = new JTable();
        tableContacts.setModel(model);
        tableContacts.setFont(new Font("Segue Print", Font.BOLD, 16));
        return new JScrollPane(tableContacts);
    }

    public String getName() {
        return nameField.getText();
    }

    public String getEmail() {
        return emailField.getText();
    }

    public String getPhoneNumber() {
        return phoneNumberField.getText();
    }

    public int getSelectedRow() {
        return tableContacts.getSelectedRow();
    }

    public void updateTable() {
        model = new DefaultTableModel(contactBookModel.getContacts(), contactBookModel.getHeaders());
        tableContacts.setModel(model);
    }

    public void addInsertListener(ActionListener listenForInsertButton) {
        insertButton.addActionListener(listenForInsertButton);
    }

    public void addClearListener(ActionListener listenForClearButton) {
        clearButton.addActionListener(listenForClearButton);
    }

    public void addDeleteListener(ActionListener listenForDeleteButton) {
        deleteButton.addActionListener(listenForDeleteButton);
    }

    public void displayErrorMessage(String errorMessage, String title) {
        JOptionPane.showMessageDialog(null, errorMessage, title, JOptionPane.ERROR_MESSAGE);
    }

    public void clearTextFields() {
        nameField.setText("");
        emailField.setText("");
        phoneNumberField.setText("");
    }

    private static class Bounds {
        int x;
        int y;
        int width;
        int height;

        Bounds(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
    }
}
