package com.zipcodewilmington.phonebook;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        String userMode = "";
        System.out.print("Welcome to your phone book!");

        while (!userMode.equals("exit")) {
        Scanner userInput = new Scanner(System.in);
        System.out.print("\n1: Add Contact" +
                "\n2: Add Phone Number to Contact" +
                "\n3: Delete Contact" +
                "\n4: Lookup Contact by Name" +
                "\n5: Lookup Contact by Phone #" +
                "\n6: Print all contacts" +
                "\nExit: Quit Phonebook\n\n");

        userMode = userInput.next().toLowerCase();


            switch (userMode) {
                case "1":
                    // Adding Contact
                    System.out.print("What is the contact's name?");
                    String newName = userInput.next();
                    System.out.print("What is the contact's phone number?");
                    String newNumber = userInput.next();

                    phoneBook.addPerson(newName, newNumber);

                    break;

                case "2":
                    // Adding phone # to contact
                    System.out.print("What is the contact's name?");
                    String addName = userInput.next();
                    System.out.print("What is the contact's additional phone number?");
                    String addNumber = userInput.next();

                    phoneBook.addNumbersToList(addName, addNumber);

                    break;

                case "3":
                    // Deleting a contact
                    System.out.print("What is the contact's name to delete?");
                    String deleteName = userInput.next();

                    phoneBook.removeRecord(deleteName);

                    break;

                case "4":
                    // Lookup by name
                    System.out.print("What is the contact's name to lookup?");
                    String lookupName = userInput.next();

                    System.out.print(phoneBook.lookupByName(lookupName));

                    break;

                case "5":
                    // Lookup by number
                    System.out.print("What is the phone number to lookup?");
                    String lookupNumber = userInput.next();

                    System.out.print(phoneBook.reverseLookup(lookupNumber));

                    break;

                case "6":
                    // Print all contacts
                    System.out.print(phoneBook.listAll());

                    break;

                default:
                    break;
            }
        }

        System.exit(1);
    }
}
