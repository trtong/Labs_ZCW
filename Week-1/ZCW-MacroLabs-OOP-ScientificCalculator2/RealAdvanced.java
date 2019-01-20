
/**
 * Method for the RealAdvanced class
 *
 * @Michelle DiMarino
 * @10.21.18
 */

import java.util.*;

public class RealAdvanced
{

    public void realAdvanced()
    {
        Console.println("Please Select one of the following Calculations: " +"\n"+
            "1: x^2" + "\n"+
            "2: x^y" + "\n"+
            "3: 1/x" + "\n"+
            "4: Switch Sign of x" + "\n"+
            "5: Absolute Value of x" + "\n"+
            "6: Square Root of x" + "\n"+
            "7: Factorial x!"+"\n"+
            "8: Return to Main Menu");

    }
    // method to find x^2
    public double squared(double x){
        return Math.pow(x,2);
    }
    // method to find x^y
    public double exponent(double x, double y){
        return Math.pow(x,y);
    }
    // method to find the inverse of x
    public double inverse(double x){
        return 1/x;
    }
    // method to switch sign of x
    public double opposite(double x){
        double opposite1 = -1 * x;
        return opposite1;
    }
    public double absoluteValue(double x){
        return Math.abs(x);
    }
public double sqrt(double x){
    return Math.sqrt(x);
}
public double factorial(double x){
    double answer = 1;
    for (double i = x; i >0; i--){
        answer = answer * i;
    }
    return answer;
}
}
