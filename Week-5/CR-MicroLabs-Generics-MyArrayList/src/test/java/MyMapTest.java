import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyMapTest {
    MyMap testMap;

    @Before
    public void setUp() throws Exception {
        testMap = new MyMap<Integer, String>();
    }

    @Test
    public void testPut() {
        int expectedSize = 2;
        testMap.put(100, "T-Shirt");
        testMap.put(100, "T-Shirt");

        Assert.assertEquals(expectedSize, testMap.getMyEntries().getSize());
    }

    @Test
    public void testGetValue() {
        testMap.put(100, "T-Shirt");
        String expectedValue = "T-Shirt";

        Assert.assertEquals(expectedValue, testMap.get(100));
    }

    @Test
    public void testKeySet() {
        // adds a new entry to the map
        testMap.put(100, "T-Shirt");
        testMap.put(100, "T-Shirt");
        testMap.put(100, "T-Shirt");

        testMap.getMyEntries().getMyArrayList();

        MyArrayList<Integer> keys = testMap.keySet();
        for (int i = 0; i < testMap.getMyEntries().getSize(); i++) {
            System.out.println(keys.get(i));
        }

        Assert.assertEquals(testMap.getMyEntries().getSize(), keys.getSize());

        }

    @Test
    public void testValues() {

        testMap.put(100, "T-Shirt M");
        testMap.put(200, "T-Shirt XL");
        testMap.put(300, "T-Shirt S");
        testMap.put(400, "T-Shirt SM");
        testMap.put(500, "T-Shirt LL");
        testMap.put(600, "T-Shirt OO");

        MyArrayList<String> values = testMap.valueSet();
        for (int i = 0; i < testMap.getMyEntries().getSize(); i++) {
            System.out.println(values.get(i));
        }

        Assert.assertEquals(testMap.getMyEntries().getSize(), values.getSize());
    }


}

