public class FizzBuzz {
    public static String of(int number) {

        String result = "";
        // Fizz Buzz game
        // if % 3 == 0, then fizz
        // if % 5 == 0, then Buzz
        // if % 5 == 0 && %3 == 0, then FizzBuzz
        // else number to string
        if (number % 3 == 0 && number % 5 == 0) {
            result = "FizzBuzz";
        } else if (number % 3 == 0) {
            result = "Fizz";
        } else if (number % 5 == 0) {
            result = "Buzz";
        } else {
            result = Integer.toString(number);
        }

        return result;

        }
    }
