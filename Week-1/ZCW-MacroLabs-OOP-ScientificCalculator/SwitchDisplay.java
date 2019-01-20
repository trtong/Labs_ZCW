
/**
 * Write a description of class SwitchDisplay here.
 *
 * Scientific Calculator Lab
 * 
 * Brings up the switch display menu
 * Binary
 * Octal
 * Decimal
 * Hexadecimal
 * 
 * Changes the mode for EVERYTHING
 * 
 * Find a way to store the input and the input as a diff base
 * then whenever the base is changed, display the base.
 * pass the input into the methods to return the string.
 * EVERY TIME AN INPUT IS PLACED, IT WILL BE DISPLAYED AS AN OCTAL
 * boolean baseChange == true; 
 *      display the changed display
 */
public class SwitchDisplay
{
    // instance variables - replace the example below with your own

    /**
     * Switch Display Mode method 
     * -> binary, octal, decimal, hexadecimal
     * switchDisplayMode() rotates through the options
     * switchDisplayMode(String mode) sets the display to the mode given
     */
    
    public void switchDisplay()
    {
            Console.println("Display Options" 
                             + "\n1: Binary"
                             + "\n2: Octal"
                             + "\n3: Decimal"
                             + "\n4: Hexadecimal"
                             + "\n5: Cancel - returns to Main Menu");
                         
    }

    /**
     * Converts the user input into corresponding base types
     */
    
    public String toBinary(double userInput) {
        
        return Integer.toBinaryString((int)userInput);
        
    }
    
    public String toOctal(double userInput) {
        
        return Integer.toOctalString((int)userInput);
        
    }
    
    public String toDecimal(int userInput) {
        
        return Integer.toString(userInput);
        
    }
    
    public String toHexa(int userInput) {
    
        return Integer.toHexString((int)userInput);
    
    }
}
