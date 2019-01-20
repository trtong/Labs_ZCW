import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;;
import java.io.FileReader;
import java.io.IOException;


public class AtbashCipherTest {

    @Test
    public void testCipher() {
        AtbashCipher cipher = new AtbashCipher();
        String test = "ABCDEF";
        String exp = "ZYXWVU";

        String actual = cipher.cipher(test);

        Assert.assertEquals(exp, actual);
    }

    @Test
    public void testFiles() throws IOException {

        AtbashCipher cipher = new AtbashCipher();

        String inputFile = "sonnet18.txt";
        String outputTest = "testFileOutput.txt";
        String decryptTest = "decryptedTestFile.txt";

        cipher.cipherFile(inputFile, outputTest);
        cipher.cipherFile(outputTest, decryptTest);

        BufferedReader bROriginal = new BufferedReader(new FileReader(inputFile));
        BufferedReader bRDecyphered = new BufferedReader(new FileReader(decryptTest));

        String originalLine;
        String decrpytLine;

        while ((originalLine = bROriginal.readLine()) != null) {
            decrpytLine = bRDecyphered.readLine();
            Assert.assertEquals(originalLine, decrpytLine);
        }


    }
}