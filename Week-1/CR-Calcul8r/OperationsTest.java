import org.junit.Test;
import org.junit.Assert;

public class OperationsTest {
    @Test
    public void testAdd() throws Exception {
        Assert.assertEquals(2, Operations.add(1, 1));
    }

    @Test
    public void testSubtract() throws Exception {
        Assert.assertEquals(0, Operations.subtract(1, 1));
    }

    @Test
    public void testMultiply() throws Exception {
        Assert.assertEquals(4, Operations.multiply(2, 2));
    }
}
