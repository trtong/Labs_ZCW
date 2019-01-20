         
        
        
public class NumberUtilities {
    /**
     * Takes in one parameter "stop" to create a string of numbers, starting
     * from 0 to stop, not including stop.
     */    
        
        public static String getRange(int stop) {
            String numberRange = "";
            
            for (int i = 0; i < stop; i++) {
            numberRange += i;
        }
        
        return numberRange;
    }
    
    /**
     * Takes 2 parameters to dictate the range of the string.
     */
    public static String getRange(int start, int stop) {
        String numberRange = "";
        
        for (int i = start; i < stop; i++) {
            numberRange += i;
        }
        
        return numberRange;
    }

    /**
     * Uses the iterator to step and create the numbers in the range.
     */
    public static String getRange(int start, int stop, int step) {
        String numberRange = "";
        
        for (int i = start; i < stop; i += step) {
            numberRange += i;
        }
        
        return numberRange;
    }
    
    /**
     * Uses the modulus operator to check for even/odd numbers to add to the 
     * numberRange string.
     */
    public static String getEvenNumbers(int start, int stop) {
        String numberRange = "";
        
        for (int i = start; i < stop; i += 1) {
            if (i % 2 == 0) {
                numberRange += i; 
            }
        }
        
        return numberRange;
    }

    /**
     * See "getEvenNumbers"
     */
    public static String getOddNumbers(int start, int stop) {
        String numberRange = "";
        
        for (int i = start; i < stop; i += 1) {
            if (i % 2 == 1) {
                numberRange += i; 
            }
        }
        
        return numberRange;
    }

    /**
     * Uses Math.pow to raise i to a specific power, then casts it to an int 
     * so it can be passed into the string to be returned.
     */
    public static String getExponentiations(int start, int stop, int exponent) {
        String numberRange = "";
        
        for (int i = start; i <= stop; i += 1) {
            int intNum = (int) Math.pow(i, exponent);
            numberRange += intNum;

        }
        
        return numberRange;
    }
    }

