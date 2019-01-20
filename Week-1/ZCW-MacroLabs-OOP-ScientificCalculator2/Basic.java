

/**
 * Basic class to perform basic functions for our Graphing Calculator
 * (+, -, *, /)
 * Lauren Green
 * 10/19/18
 */
public class Basic
{
    double input1 = 0;
    double input2 = 0;
    String operation = "";
    double answer;
    
    public void Basic()
    {
        Console.println("Basic Calculator Options" 
                         + "\n1: Addition"
                         + "\n2: Subtraction"
                         + "\n3: Multiplication"
                         + "\n4: Division"
                         + "\n5: Cancel - returns to Main Menu");        

    }

    //addition method
    public double getSum(double x, double y) {
        answer = x + y;
        return answer;
    }
    
    //subtraction method
    public double getDiff(double x, double y) {
        answer = x - y;
        return answer;
    }
    
    //multiplication method
    public double getProduct(double x, double y) {
        answer = x * y;
        return answer;
    }
    
    //division method
    public double getQuotient(double x, double y) {
        answer = x / y;
        return answer;
    }
}

        