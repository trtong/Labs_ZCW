package io.zipcoder.polymorphism;

import java.util.Scanner;

/**
 * Created by leon on 11/6/17.
 */
public class MainApplication {
    public static void main(String[] args) {
        // create scanner class for inputs
        Scanner keyboard = new Scanner(System.in);

        // numOfPets = Ask user how many pets they have
        System.out.print("How many pets do you have?");

        int numOfPets = keyboard.nextInt();
        // Create array of objects [numOfPets]
        if (numOfPets > 0) {
            Pet[] pets = new Pet[numOfPets];

            // What kind of pet each one is using a loop
            for (int i = 0; i < pets.length; i++) {
                System.out.print("What kind of pet do you have?\n\n");
                System.out.print("1: Dog\n2: Cat\n3: Duck\n4: Frog\n(Enter the key for the pet)\n");
                int petType = keyboard.nextInt();
                // Takes in the type and creates that object

                if (petType == 1) {
                    pets[i] = new Dog();
                    System.out.print("What is your dog's name?\n");
                    String petName = keyboard.next();
                    System.out.println("Pet Name: " + petName);
                    pets[i].setName(petName);

                } else if (petType == 2) {
                    pets[i] = new Cat();
                    System.out.print("What is your cat's name?\n");
                    String petName = keyboard.next();
                    pets[i].setName(petName);

                } else if (petType == 3) {
                    pets[i] = new Duck();
                    System.out.print("What is your duck's name?\n");
                    String petName = keyboard.next();
                    pets[i].setName(petName);

                } else if (petType == 4) {
                    pets[i] = new Frog();
                    System.out.print("What is your frog's name?\n");
                    String petName = keyboard.next();
                    pets[i].setName(petName);
                }
            }
            for (int i = 0; i < pets.length; i++) {
                System.out.print((i + 1) + ": " + pets[i].getName() + " says, \"" + pets[i].speak() + "\"\n");
            }
        } else {
            System.out.print("Invalid input. Exiting program.");
            System.exit(1);
        }
        // Ask what kind of pet
        // Option menu for types of pets.
        // Ask their name
        // Update the name
        // next iteration
    }

}
