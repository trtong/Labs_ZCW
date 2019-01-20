/**
 * Trinh Tong
 * SumOfInput Lab 
 * 
 * Uses a while loop to continually ask the user for a valid input.
 * In this case, a valid input is > 0 as the lab 
 * asks for a sum of n (userInput) from 1 to n. 
 */
    
import java.util.*;
    
public class Main {

    public static void main(String[] args){
        Scanner keyboardInput = new Scanner(System.in);
        int sum = 0;
        boolean validNum = false;
        
        while (validNum == false) {  
            System.out.println("Enter a number, any number!");
            int userNum = keyboardInput.nextInt();
            
            if (userNum > 0) {
                for (int i = 1; i <= userNum; i++) {
                    sum += i;
                }
                System.out.println(sum); 
                validNum = true;
            } else {
                System.out.println("Ok, not that number. (must be > 0)");
            }
        }
    }
}

