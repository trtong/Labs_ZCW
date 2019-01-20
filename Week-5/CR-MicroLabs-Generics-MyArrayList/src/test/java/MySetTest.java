import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MySetTest {

    MySet<Integer> mySet;

    @Before
    public void setUp() {
        mySet = new MySet<>();

    }

    @Test
    public void testAddUnique() {
        Integer expectedOutput = 1;
        mySet.add(1);
        Assert.assertEquals(expectedOutput, mySet.getMyArrayList()[mySet.getSize()-1]);
    }

    @Test
    public void testAddNotUnique() {

        int expectedSize = 2;
        mySet.add(1);
        mySet.add(2);
        mySet.add(1);

        Assert.assertEquals(expectedSize, mySet.getSize());
    }

    @Test
    public void testContainsTrue() {

        mySet.add(1);
        mySet.add(2);
        mySet.add(5);
        mySet.add(10);

        Assert.assertTrue(mySet.contains(2));
    }

    @Test
    public void testContainsFalse() {
        mySet.add(1);
        mySet.add(2);
        mySet.add(5);
        mySet.add(10);

        Assert.assertFalse(mySet.contains(3));
    }

    @Test
    public void testHasNextFalse() {
        Assert.assertFalse(mySet.iterator().hasNext());
    }

    @Test
    public void testHasNextTrue() {
        mySet.add(1);
        mySet.add(2);
        mySet.add(5);
        mySet.add(10);

        Assert.assertTrue(mySet.iterator().hasNext());
    }

    @Test
    public void testIteratorNext() {
        Integer expectedNext = 1;
        mySet.add(1);

        Assert.assertEquals(expectedNext, mySet.iterator().next());
    }

    @Test
    public void testIteratorRemove() {
        mySet.add(1);
        mySet.add(2);
        mySet.add(5);
        mySet.add(10);

        mySet.iterator().remove();

        Assert.assertFalse(mySet.contains(1));
    }

//    @Test
//    public void testContainsAllFalse() {
//        MySet<Integer> inputSet = new MySet<>();
//        inputSet.add(1);
//        inputSet.add(2);
//        inputSet.add(3);
//        inputSet.add(4);
//
//        Object[] inputArray = inputSet.getMyArrayList();
//
//        for (Object i: inputArray
//             ) {
//            System.out.println(i);
//        }
//        // Checks if all the values are in the set, if not add the values;
//        Assert.assertFalse(mySet.containsAll(inputArray));
//
//    }
}
