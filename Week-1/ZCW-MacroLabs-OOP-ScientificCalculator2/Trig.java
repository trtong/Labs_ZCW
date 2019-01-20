
/**
 * Trig class to perform trig function for our Graphing Calculator
 * (sin, cos, tan, inverses, degree to radian)
 * Lauren Green
 * 10/19/18
 */
public class Trig
{
    double input = 0.0;
    double answer;
    String operation = "";

    public void trigFunctions()
    {
        Console.println("Trigonometry Calculator Options" 
            + "\n1: sin"
            + "\n2: cosin"
            + "\n3: tan"
            + "\n4: arcsin"
            + "\n5: arccosin"
            + "\n6: arctan"
            + "\n7: log"
            + "\n8: Cancel - returns to Main Menu");   

        
    }

    //Sin method
    public double calcSin(double x) {
        answer = Math.sin(x);
        return answer;
    }

    //Cos method
    public double calcCos(double x) {
        answer = Math.cos(x);
        return answer;
    }

    //Tan method
    public double calcTan(double x) {
        answer = Math.tan(x);
        return answer;
    }

    //Arcsin method
    public double calcArcsin(double x) {
        answer = Math.asin(x);
        return answer;
    }

    //Arccos method
    public double calcArccos(double x) {
        answer = Math.acos(x);
        return answer;
    }

    //Arctan method
    public double calcArctan(double x) {
        answer = Math.atan(x);
        return answer;
    }

    //Log Method
    public double calcLog(double x) {
        answer = Math.log10(x);
        return answer;
    }
    
    //Converting from Radians to Degrees
    public double toDegrees(double answer) 
    {
        double conversion = Math.toDegrees(answer);
        answer = conversion;
        return answer;

    }
    
    
}

