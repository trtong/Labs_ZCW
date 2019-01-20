import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyArrayListTest {
    MyArrayList<String> stringList;
    @Before
    public void setUp() {

        stringList = new MyArrayList<>();
        stringList.add("Wilhelm spilled the tea");
    }

    @Test
    public void testAdd() {

        int expectedSize = 1;

        Assert.assertEquals(expectedSize, stringList.getSize());
    }

    @Test
    public void testAddatIndex() {

        String expectedString = "Dolio Rollio";

        stringList.add("Wilhelm spilled the tea");
        stringList.add("Wilhelm spilled the tea");
        stringList.add("the table got wet :(");
        stringList.add("Nhu got more tears to fill up her tea");


        stringList.add(1, "Dolio Rollio");
        Assert.assertTrue(expectedString.equals(stringList.get(1)));

    }

    @Test
    public void testGet() {
        String expectedString = "Wilhelm spilled the tea";
        Assert.assertTrue(expectedString.equals(stringList.get(stringList.getSize()-1)));

    }

    @Test
    public void testRemove() {
        int expectedSize = 0;
        stringList.remove("Wilhelm spilled the tea");
        Assert.assertEquals(expectedSize, stringList.getSize());
    }

    @Test
    public void testSet() {
        String expectedString = "they moved the table";

        stringList.add("Wilhelm spilled the tea");
        stringList.add("Wilhelm spilled the tea");
        stringList.add("the table got wet :(");
        stringList.add("Nhu got more tears to fill up her tea");
        stringList.add("Wilhelm spilled the tea");
        stringList.add("Wilhelm spilled the tea");

        stringList.set(5, "they moved the table");

        Assert.assertEquals(expectedString, stringList.get(5));
    }

    @Test
    public void testClear() {
        int expectedSize = 0;
        stringList.add("Wilhelm spilled the tea");
        stringList.add("Wilhelm spilled the tea");
        stringList.add("the table got wet :(");
        stringList.add("Nhu got more tears to fill up her tea");
        stringList.add("Wilhelm spilled the tea");
        stringList.add("Wilhelm spilled the tea");

        stringList.clear();
        Assert.assertEquals(expectedSize, stringList.getSize());
    }

    @Test
    public void testIsEmpty() {
        Assert.assertFalse(stringList.isEmpty());
    }

    @Test
    public void testContainsTrue() {
        String expectedString = "Wilhelm spilled the tea";

        Assert.assertTrue(stringList.contains(expectedString));
    }

    @Test
    public void testContainsFalse() {
        String expectedString = "they moved the table";
        Assert.assertFalse(stringList.contains(expectedString));
    }

    @Test
    public void testIndexOf() {
        String findMe = "Nhu got more tears to fill up her tea";
        stringList.add("Wilhelm spilled the tea");
        stringList.add("the table got wet :(");
        stringList.add("Nhu got more tears to fill up her tea");
        stringList.add("Wilhelm spilled the tea");

        int expectedIndex = 3;

        Assert.assertEquals(expectedIndex, stringList.indexOf(findMe));
    }
}
