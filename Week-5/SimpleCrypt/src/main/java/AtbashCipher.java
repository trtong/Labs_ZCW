import java.io.*;

import java.util.HashMap;
import java.util.stream.Stream;


public class AtbashCipher{

    private static final String abc = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
    private static final String cba = "ZzYyXxWwVvUuTtSsRrQqPpOoNnMmLlKkJjIiHhGgFfEeDdCcBbAa";
    private static final HashMap<Character, Character> key = new HashMap<>();

    public AtbashCipher() {
        createKey();
    }

    private void createKey() {
        char[] abcArr = abc.toCharArray();
        char[] cbaArr = cba.toCharArray();

        for (int i = 0; i < abcArr.length; i++) {
            key.put(abcArr[i], cbaArr[i]);
        }
    }

    public static String cipher(String s) {
        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (key.containsKey(charArray[i])) {
                charArray[i] = key.get(charArray[i]);
            }
        }
        return charArrayToString(charArray);
    }

    public  static String charArrayToString(char[] chars) {
        StringBuilder sb = new StringBuilder();
        for (char c: chars) {
            sb.append(c);
        }
        return sb.toString();
    }

    public void cipherFile(String filePathIn, String filePathOut) throws FileNotFoundException {
        String inFile = fileToString(filePathIn);

        PrintStream file = new PrintStream(new File(filePathOut));
        PrintStream console = System.out;

        System.setOut(file);

        String swappedChars = Stream.of(inFile)
                .map(AtbashCipher::cipher)
                .reduce("", String::concat);

        System.out.println(swappedChars);
        System.setOut(console);
    }


    private String fileToString(String filePath) throws FileNotFoundException {

        File file = new File(filePath);

        FileReader fReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fReader);

        StringBuilder sb = new StringBuilder();
        String line;

        try {
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
        }

        return sb.toString();
    }

}
