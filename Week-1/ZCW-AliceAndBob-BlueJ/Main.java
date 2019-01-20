/**
 * Trinh Tong
 * Lab - Alice and Bob
 * Using the scanner to take an input and then display the message 
 * with the user's keyboard input.
 */
import java.util.*; 

public class Main {

    public static void main(String[] args ){
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Please enter your name.");
        
        String name = keyboard.nextLine();
        
        String returnLine = "Hello, " + name + ".";
        
        if (name.equalsIgnoreCase("Alice")) {
            System.out.println(returnLine); 
        } else if (name.equalsIgnoreCase("Bob")) {
            System.out.println(returnLine); 
        } else {
            System.out.println("You aren't Alice or Bob!"); 
        }
    }  
        
}

