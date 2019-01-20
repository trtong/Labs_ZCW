import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CaeserCipherTest {

    @Test
    public void testCaesar() {
        CaeserCipher cc = new CaeserCipher(23);


        String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String expected = "XYZABCDEFGHIJKLMNOPQRSTUVW";

        String actual = cc.encrypt(text);
        System.out.println(actual);
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testDecrypt() {
        CaeserCipher cc = new CaeserCipher(23);

        String text = "XYZABCDEFGHIJKLMNOPQRSTUVW";
        String exp = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        String actual = cc.decrypt(text);

        Assert.assertEquals(exp, actual);



    }
}