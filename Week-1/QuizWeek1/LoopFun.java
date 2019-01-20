public class LoopFun
{

    /**
     * Given a number, return the factorial of that number.
     * For example, given 5, the factorial is 5 x 4 x 3 x 2 x 1 which should return 120.
     * @param number
     * @return the factorial of the number
     */
    public int factorial(int number){

        int counter = number;
        for (int i = number - 1; i > 1; i --) {
            counter = counter * i;
        }

        return counter;
    }

    /**
     * Given a phrase, get the acronym of that phrase. Acronym is the combination of
     * the first character of each word in upper case.
     * For example, given "Ruby on Rails", this method will return "ROR"
     * @param phrase
     * @return Upper case string of the first letter of each word
     */
    public String acronym(String phrase) {

        String upperAcro = "";

        String[] words = phrase.split(" ");

        // cycle through and grab each char @ 0 and return to string

        for (int i = 0; i < words.length; i++) {
            upperAcro += Character.toString(words[i].charAt(0));
        }

        return upperAcro.toUpperCase();

    }

    /**
     * To prevent anyone from reading our messages, we can encrypt it so it will only be readable by its
     * intended audience. This method encrypt the message by shifting the letter by 3 characters. If the character is
     * at the end of the alphabet, it will wraps around.
     * For example:
     *  'a' => 'd'
     *  'w' => 'z'
     *  'x' => 'a'
     *  'y' => 'b'
     * @param word
     * @return the encrypted string by shifting each character by three character
     */
    public String encrypt(String word) {
        // encoder of full alphabet
        String encoder = "abcdefghijklmnopqrstuvwxyz";
        String decryptMessage = "";
        int encodeMove = 3;

        // nested for loop to check chars to chars of the string
        for (int i = 0; i < word.length(); i++){
            // this loop checks char @ i and compares to the encoder string
            for (int j = 0; j < encoder.length(); j++) {
                // cycles through encoder and finds the position in the encoder
                // loops back to front, if j == encoder.length();
                // j = 0
                if (word.charAt(i) == (encoder.charAt(j))) {
                    if (j >= 23) {

                        int k = j;
                        int end = encoder.length() - 1;
                        // add until it hits 26, then reinitialize to -1 (for case "x"  it should be at index 0)
                        for (int l = 0; l <= 2; l++) {
                            if ( k == end ) {
                                k = -1;
                            }
                            k ++;
                        }

                        decryptMessage += Character.toString(encoder.charAt(k));
                    } else {
                        decryptMessage += Character.toString(encoder.charAt(j+3));
                    }
                }
            }

        }
        // if statement to wrap around

        return decryptMessage;
    }
}
