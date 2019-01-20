
import java.util.Scanner;
import java.util.*;
/**
 * Created by leon on 2/9/18.
 */
public class Console {

    public static void main(String[] args) {

        // Create all instances of classes to be used for this program
        MainMenu mainMenu = new MainMenu();
        Basic basicCalc = new Basic();
        RealAdvanced advCalc = new RealAdvanced();
        SciCalc scientificCalc = new SciCalc();
        MemoryFunc memory = new MemoryFunc();
        SwitchDisplay baseChange = new SwitchDisplay();
        Trig trigMenu = new Trig();

        // Menu Input
        String menuInput = " ";
        // Giant while loop that links back to main menu
        while (!menuInput.equals("4")) {
            mainMenu.mainMenuDisplay();
            menuInput = Console.getStringInput("Enter the calculator you want to use by key. (ie. 1 for basic, etc.)");

            switch (menuInput) {
                // Basic Calculator
                case "1":
                basicCalc.Basic();

                double basicInput1 = 0,
                basicInput2 = 0;

                String basicMode = Console.getStringInput("Enter the mode: ");

                if (memory.memoryChanged != true) {
                    basicInput1 = Console.getDoubleInput("Enter the first input: ");
                    basicInput2 = Console.getDoubleInput("Enter the second input: ");
                } else if (memory.memoryChanged == true) {
                    String useMemory = Console.getStringInput("Do you want to use the stored memory value? Y or N: ").toLowerCase();
                    if (useMemory.equals("y")) {
                        String whichBasInput = Console.getStringInput("Which input? 1 or 2 or both").toLowerCase();
                        if (whichBasInput.equals("1")) {
                            basicInput1 = memory.memory;
                            basicInput2 = Console.getDoubleInput("Enter the second input: ");
                        } else if (whichBasInput.equals("2")) {
                            basicInput2 = memory.memory;
                            basicInput1 = Console.getDoubleInput("Enter the first input: ");
                        } else if (whichBasInput.equals("both")) {
                            basicInput1 = memory.memory;
                            basicInput2 = memory.memory;
                        }
                    } else {
                        basicInput1 = Console.getDoubleInput("Enter the first input: ");
                        basicInput2 = Console.getDoubleInput("Enter the second input: ");
                    }
                }

                double basicAnswer = 0;
                if (basicMode.equals("1")) {
                    basicAnswer = basicCalc.getSum(basicInput1, basicInput2);

                    //subtraction
                } else if (basicMode.equals("2")) {
                    basicAnswer = basicCalc.getDiff(basicInput1, basicInput2);

                    //multiplication
                } else if (basicMode.equals("3")) {
                    basicAnswer = basicCalc.getProduct(basicInput1, basicInput2);

                    //division
                } else if (basicMode.equals("4")) {
                    //error message when trying to divide by 0.
                    if (basicInput2 == 0) {
                        Console.println("undefined");
                        basicAnswer = Double.NaN;
                        //Insert return to main menu.
                    } else {
                        basicAnswer = basicCalc.getQuotient(basicInput1, basicInput2);
                    }
                } else if (basicMode.equals("5")) {

                    break;

                } else {
                    //error if wrong input was entered
                    basicAnswer = Double.NaN;
                    Console.println("Invalid Input");
                }

                Console.println(Double.toString(basicAnswer));

                break;

                case "2":

                advCalc.realAdvanced();
                String mode = Console.getStringInput("Enter the mode: ");
                double advInput1 = 0,
                advInput2 = 0;
                // checking if user wants to use memory
                if (memory.memoryChanged != true) {
                    advInput1 = Console.getDoubleInput("Enter the first input: ");
                } else if (memory.memoryChanged == true) {
                    String useMemory = Console.getStringInput("Do you want to use the stored memory value? Y or N: ").toLowerCase();
                    if (useMemory.equals("y")) {
                        advInput1 = memory.memory;
                    } else if (useMemory.equals("n")) {
                        advInput1 = Console.getDoubleInput("Enter the first input: ");
                    }
                }

                double advAnswer = 0;
                if (mode.equals("1")){
                    advAnswer = advCalc.squared(advInput1);

                }else if (mode.equals("2")){

                    // checking if user wants to use memory
                    if (memory.memoryChanged != true) {
                        advInput2 = Console.getDoubleInput("Enter the exponent value: ");
                    } else if (memory.memoryChanged == true) {
                        String useMemory = Console.getStringInput("Do you want to use the stored memory value? Y or N: ").toLowerCase();
                        if (useMemory.equals("y")) {
                            advInput2 = memory.memory;
                        } else if (useMemory.equals("n")) {
                            advInput2 = Console.getDoubleInput("Enter the first input: ");
                        }
                    }
                    advAnswer = advCalc.exponent(advInput1,advInput2);

                }else if (mode.equals("3")){
                    if (advInput1 == 0) {
                        Console.println("undefined");
                        advAnswer = Double.NaN;
                    } else {
                        advAnswer = advCalc.inverse(advInput1);
                    }
                }else if (mode.equals("4")){
                    advAnswer = advCalc.opposite(advInput1);
                }else if (mode.equals("5")){
                    advAnswer = advCalc.absoluteValue(advInput1);
                }else if (mode.equals("6")){
                    advAnswer = advCalc.sqrt(advInput1);
                }else if (mode.equals("7")){
                    advAnswer = advCalc.factorial(advInput1);

                }else if (mode.equals("8")) {
                    break;
                }else{
                    Console.println("Invalid input");
                }

                Console.println(Double.toString(advAnswer));
                break;

                case "3":

                // Sends to Scientific Calculator Functions
                // displays the menu for scientific calc
                scientificCalc.toSciMenu();
                String sciMenuInput = Console.getStringInput("Enter the function you'd like to use by key.");
                // if statement to use various calc functions
                if (sciMenuInput.equals("1")) {
                    // Base Conversions
                    // while loop for display
                    String baseMode = "";

                    baseChange.switchDisplay();
                    String baseAnswer = "";
                    baseMode = Console.getStringInput("Enter the desired display mode: ");
                    double userInput = 0;

                    if (memory.memoryChanged != true) {
                        userInput = (Console.getDoubleInput("Enter the exponent value: "));
                    } else if (memory.memoryChanged == true) {
                        String useMemory = Console.getStringInput("Do you want to use the stored memory value? Y or N: ").toLowerCase();
                        if (useMemory.equals("y")) {
                            userInput = memory.memory;
                        } else if (useMemory.equals("n")) {
                            userInput = Console.getDoubleInput("Enter the number you want to convert to selected base: ");
                        }
                    }

                    switch (baseMode) {
                        case "1":
                        baseAnswer = baseChange.toBinary((int)userInput);

                        case "2":
                        baseAnswer = baseChange.toOctal((int)userInput);

                        case "3":
                        baseAnswer = baseChange.toDecimal((int)userInput);

                        case "4":
                        baseAnswer = baseChange.toHexa((int)userInput);

                        case "5":
                        break;

                        default:
                        Console.println("Invalid Input");
                        break;
                    }

                    Console.println(baseAnswer);

                    break;

                } else if (sciMenuInput.equals("2")) {
                    // Memory
                    // access memory menu
                    memory.memoryMenu();

                } else if (sciMenuInput.equals("3")) {
                    // To Trig Menu
                    trigMenu.trigFunctions();
                    String trigMode = Console.getStringInput("Enter trignometric function by key: (ie. 1 for sin)");

                    double trigInput = 0;

                    if (memory.memoryChanged != true) {
                        trigInput = Console.getDoubleInput("Enter the input for the trignometric function: ");
                    } else if (memory.memoryChanged == true) {
                        String useMemory = Console.getStringInput("Do you want to use the stored memory value? Y or N: ").toLowerCase();
                        if (useMemory.equals("y")) {
                            trigInput = memory.memory;
                        } else if (useMemory.equals("n")) {
                            trigInput = Console.getDoubleInput("Enter the input for the trignometric function: ");
                        }
                    }

                    double trigAnswer;
                    if (trigMode.equals("1")) {
                        trigAnswer = trigMenu.calcSin(trigInput);

                        //COS
                    } else if (trigMode.equals("2")) {
                        trigAnswer = trigMenu.calcCos(trigInput);

                        //TAN
                    } else if (trigMode.equals("3")) {
                        trigAnswer = trigMenu.calcTan(trigInput);

                        //ARCSIN
                    } else if (trigMode.equals("4")) {
                        trigAnswer = trigMenu.calcArcsin(trigInput);

                        //ARCCOS
                    } else if (trigMode.equals("5")) {
                        trigAnswer = trigMenu.calcArccos(trigInput);

                        //ARCTAN
                    } else if (trigMode.equals("6")) {
                        trigAnswer = trigMenu.calcArctan(trigInput);

                    } else if (trigMode.equals("7")) {
                        trigAnswer = trigMenu.calcLog(trigInput);

                    } else if (trigMode.equals("8")) {
                        break;

                    } else {
                        //Error message if input does not match options, loops back to the top so they can try again.
                        trigAnswer = Double.NaN;

                    }

                    String trigAnswerString = Double.toString(trigAnswer);
                    Console.println(trigAnswerString);

                    String trigDefRad =  Console.getStringInput("Do you want to convert your answer from radians to degrees?"
                            + "\nEnter Y or N").toLowerCase();

                    if (trigDefRad.equals("y") ) {
                        double convertAnswer = trigMenu.toDegrees(trigAnswer);
                        Console.println(Double.toString(convertAnswer));
                    }
                    break;
                } else {
                    break;
                }
                break;

                case "4":
                // Quits the calculator
                break;
            }

        }
    }

    public static void print(String output, Object... args) {
        System.out.printf(output, args);
    }

    public static void println(String output, Object... args) {
        print(output + "\n", args);
    }

    public static String getStringInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        println(prompt);
        String userInput = scanner.nextLine();
        return userInput;
    }

    public static Integer getIntegerInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        println(prompt);
        Integer userInput = scanner.nextInt();
        return userInput;
    }

    public static Double getDoubleInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        println(prompt);
        Double userInput = scanner.nextDouble();
        return userInput;
    }
}
