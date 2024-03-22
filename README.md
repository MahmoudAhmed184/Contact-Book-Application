# Contact Book Application

## Table of Contents
1. [Overview](#overview)
2. [Features](#features)
3. [Structure](#structure)
4. [Getting Started](#getting-started)
5. [Usage](#usage)
6. [Contributing](#contributing)

## Overview

The Contact Book Application is a Java-based application that allows users to manage their contacts. It follows the Model-View-Controller (MVC) design pattern and uses Swing for the graphical user interface.

## Features

- Add new contacts
- Delete existing contacts

## Structure

The application is divided into three packages:

1. `com.contactbook.model`: Contains the `Contact` and `ContactBookModel` classes.
2. `com.contactbook.view`: Contains the `ContactBookView` class.
3. `com.contactbook.controller`: Contains the `ContactBookController` class.

### Model Package

- The `Contact` class represents a contact with a name, email, and phone number. It provides getter and setter methods for these fields.

- The `ContactBookModel` class represents a contact book. It maintains a list of contacts and provides methods to add and remove contacts.

### View Package

- The `ContactBookView` class represents the user interface of the application. It extends `JFrame` and contains fields and buttons for user interaction.

### Controller Package

- The `ContactBookController` class acts as an intermediary between the `ContactBookModel` and `ContactBookView`. It handles the logic for inserting and deleting contacts.

## Getting Started

### Prerequisites

- Java Runtime Environment (JRE) 11 or later

### Installation

1. Clone the repository
   ```sh
   git clone https://github.com/MahmoudAhmed184/Contact-Book-Application.git
   ```
2. Open the project in Visual Studio Code.
3. Open the `Main.java` file.
4. Click on the `Run` button in the upper right corner of the editor (or press `F5`). This will compile and run the `Main` class.


## Usage

- Adding a Contact: Enter the contact’s name, email, and phone number in the designated text fields and click the “Insert” button.
- Deleting a Contact: Select the contact you want to remove in the table and click the “Delete” button.

## Contributing

We welcome contributions! For major changes, please open an issue first to discuss what you would like to change. Feel free to fork the repository and create a pull request with your changes.
