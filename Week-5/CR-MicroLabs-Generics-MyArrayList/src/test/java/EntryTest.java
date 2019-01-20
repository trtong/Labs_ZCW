import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EntryTest {
    MyEntry testEntry;

    @Before
    public void setUp() {
        testEntry = new MyEntry(1, "Tea");

    }

    @Test
    public void testGet() {
        String expValue = "Tea";
        Assert.assertEquals(expValue, testEntry.getValue());
    }

    @Test
    public void testSet() {
        String expValie = "Moolah";
        testEntry.setValue("Moolah");
        Assert.assertEquals(expValie, testEntry.getValue());
    }
}
