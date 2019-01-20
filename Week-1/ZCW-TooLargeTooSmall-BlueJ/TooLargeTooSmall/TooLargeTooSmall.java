
/**
* Guessing game 
* prompts user to guess a mystery number
* after every guess, "Too large" "Too small" "Correct"
* when terminating, display # of guesses
* if the same number is used, it counts as 1 guess
*/

import java.util.*;

public class TooLargeTooSmall {
    public static int randomNumGenerator(){
        // this section starts the game by letting the user select
        // a game mode
        Random num = new Random();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Welcome to the guessing game... \n"
                            + "Select a mode \n" 
                            + "1: Easy (Number between 1-10)\n"
                            + "2: Normal (Number between 1-20)\n"
                            + "3: Hard (Number between 1-50)\n"
                            + "Select by inputing the number");
                            
        int gameMode = keyboard.nextInt();
        
        int min = 0;
        int max = 0;
    
        switch (gameMode) {
            
            case 2: min = 1;
                    max = 20;
                    break;
            case 3: min = 1;
                    max = 50;
                    break;
            default: min = 1;
                     max = 10;
                     break;
            
        }
        
        int guessMe = num.nextInt((max - min) + 1) + min;
        
        return guessMe;
    }

    public static void guessing() {
        
        int numberToGuess = randomNumGenerator();
    
        boolean guessFound = false;
        
        int guessCounter = 0,
            previousGuess = 0;
        
        Scanner keyboard = new Scanner(System.in);
        // While loop until guess is correct.
        // guess checker - will check guess against other guesses
        // boolean, if currentGuess = previousGuess, repeatGuess = true/false
        
        while (guessFound == false) {
            // guess found - returns win message and how many guesses
            System.out.println("What's your guess?!");
            int currentGuess = keyboard.nextInt();
            
            // if statement to check if guess is correct
            
            if (currentGuess == numberToGuess) {
                System.out.println("You guessed the right number!" 
                                    + "\n" 
                                    + "It took you this many guesses: "
                                    + guessCounter);
                guessFound = true;

            } else {
                // check guess against previous guess update counter
                if (currentGuess != previousGuess) {
                    guessCounter++;
                    previousGuess = currentGuess;
                }
                if (currentGuess > numberToGuess) {
                    System.out.println("Number was too large!");
                } else {
                    System.out.println("Number was too small!");
                }
                System.out.println("That wasn't the right answer. Guess again!");
            }
        }
    }
}
