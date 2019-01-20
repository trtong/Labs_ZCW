public class CaeserCipher extends ROT13 {
    // takes in a shift and then returns an encoded string of the letter shift

    public CaeserCipher(int shift) {
        super.setShift(shift);
    }

    public String encrypt(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= 'a' && c <= 'z') {
                sb.append((char) ((c - 'a' + getShift()) % 26 + 'a'));

            } else if (c >= 'A'  && c <= 'Z') {
                sb.append((char)((c - 'A' + getShift()) % 26 + 'A'));

            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String decrypt(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= 'a' && c <= 'z') {
                sb.append((char) ((c + 'a' - getShift()) % 26 + 'a'));

            } else if (c >= 'A'  && c <= 'Z') {
                sb.append((char)((c + 'A' - getShift()) % 26 + 'A'));

            } else {
                sb.append(c);
            }
        }
        return sb.toString();

    }
}