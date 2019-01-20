
/**
 * Write a description of class PayDay here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class PayDay
{
    /**
     * Variables needed
     * Name
     * HourlyRate
     * Hours worked
     * Deduction
     */
    
    public static String payDayInfo(String name, double rate, double hours, double deductionRate) {
        
        
        double grossPay = rate * hours;
        double deduction = grossPay * deductionRate;
        double netPay = grossPay - deduction;
        
        return String.format(name + " %.2f %.2f %.2f", grossPay, deduction, netPay);
        
    }
}
