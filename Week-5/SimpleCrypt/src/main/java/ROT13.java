import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {
    private int shift;

    ROT13(Character cs, Character cf) {
        shift = cf - cs;
        // With this constructor, we are finding how much to rotate by
        // UP TO CF, not including
    }

    ROT13() {
        shift = 13;
    }

    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

    public String crypt(String text) throws UnsupportedOperationException {
        StringBuilder sb = new StringBuilder();
        // only 26 letters in the alphabet, with the 13 shift, the crpt and encrypt are equal
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= 'a' && c <= 'm') {
                c += shift;
                sb.append(c);
            } else if (c >= 'A' && c <= 'M') {
                c += shift;
                sb.append(c);
            } else if (c >= 'n' && c <= 'z') {
                c -= shift;
                sb.append(c);
            } else if (c >= 'N' && c <= 'Z') {
                c -= shift;
                sb.append(c);
            } else {
                sb.append(c);
            }
        }
        // we are rotating each letter, not shifting
        return sb.toString();
    }

    public String encrypt(String text) {
        return crypt(text);
    }

    public String decrypt(String text) {
        return crypt(text);
    }

    public static String rotate(String s, Character c) {
        // shifting the string so that C is the first character
        // Find where c is
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                index = i;
                break;
            }
        }

        int rotation = index % s.length();

        return s.substring(rotation) + s.substring(0, index);
    }

}
