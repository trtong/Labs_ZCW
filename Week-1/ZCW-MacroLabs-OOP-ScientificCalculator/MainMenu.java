
/**
 * Scientific Calculator Lab
 * 
 * This class will create the instance of the "Main Menu"
 * 
 * This serves to display the options the user can take to use the calculator
 * 
 * 1: Basic Menu - 4 basic functions + - * /
 * 2: Advanced Menu - Exponents & inverse
 * 3: Scientific Menu - Base Conversions, Memory Functions, Trig Options
 * 
 * The point of this method is for the MAIN Application while loop.
 * Whenever the user opens the calculator OR completes an action
 * in the submenus, the calculator will return to this main menu.
 */
public class MainMenu
{
    /**
     * Method to display the main menu
     */
    
    public void mainMenuDisplay()
    {
        Console.println("\nCalculator Options:"
                         + "\n1: Basic Calculator (+ - * /)"
                         + "\n2: Advanced Calculator (Exponential Functions)"
                         + "\n3: Scientific Functions (Base Conversion, Memory, Trigonometry)"
                         + "\n4: Exit the calculator");
        
    }
}
