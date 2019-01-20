
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Double.NaN;
import static org.junit.Assert.*;

public class ArrazTest {

    private Integer[] ints = new Integer[] {4,5,102,6,-7,12,-32,92,8};
    private Integer[] ints2 = new Integer[] {6,10,31};
    private double[] doubles = new double[] {1.0, 0.5, 3.6, 38.4, 17.3, 62.0, 9.0, 3.375, 0.0, 3.14159};
    private double[] doubles2 = new double[] {1.5, 2.6, 10.6, -32.4, 2.0, -5.23, -0.1, 5.73, 1.03, 95.1413};
    private final Double DELTA = 0.0;

    @Test
    public void test1SumOfArray() {
        int expected = 190;
        assertEquals(expected, Arraz.sumValuesOfArray(ints));
    }

    @Test
    public void test2SumOfArray() {
        int expected = 47;
        assertEquals(expected, Arraz.sumValuesOfArray(ints2));
    }

    @Test
    public void test1SumOfArrayDbl() {
        Double expected = 138.31659000000002;
        assertEquals(expected, Arraz.sumDoublesOfArray(doubles));
    }

    @Test
    public void test2SumOfArrayDbl() {
        Double expected = 80.8713;
        assertEquals(expected, Arraz.sumDoublesOfArray(doubles2));
    }

    @Test
    public void test1AverageOfArray() {
        int expAvg = 21;
        assertEquals(expAvg, Arraz.averageOfArray(ints));
    }

    @Test
    public void test2AverageOfArray() {
        Integer[] zeroArray = {};
        assertEquals(0, Arraz.averageOfArray(zeroArray));
    }

    @Test
    public void test1doubleAverageOfArray() {
        double expAvg = 13.831659000000002;
        assertEquals(expAvg, Arraz.doubleAverageOfArray(doubles));
    }

    @Test
    public void test2doubleAverageOfArray() {
        double[] zero = {};
        assertEquals(NaN, Arraz.doubleAverageOfArray(zero) );
    }

    @Test
    public void test1containsValue() {
        int val = 12;
        assertTrue(Arraz.containsValue(ints, val));
    }

    @Test
    public void test2ContainsValue() {
        int val = 0;
        assertFalse(Arraz.containsValue(ints, val));
    }

    @Test
    public void test1reverseArray() {
        Integer[] expected = {31, 10, 6};
        assertTrue(Arrays.equals(expected, Arraz.reverseArray(ints2)));
    }

    @Test
    public void test2reverseArray() {
        Integer[] expected = {1};
        assertTrue(Arrays.equals(expected, Arraz.reverseArray(expected)));
    }

    @Test
    public void test1OddsEvenOfArray() {
        int expectedEven = 7;
        int expectedOdd = 2;

        OddEven oe = Arraz.getOddEvensOfArray(ints);
        assertEquals(expectedEven, oe.getEvens());
        assertEquals(expectedOdd, oe.getOdds());
    }

    @Test
    public void test2OddsEvenOfArray() {
        int expectedEven = 2;
        int expectedOdd = 1;

        OddEven oe = Arraz.getOddEvensOfArray(ints2);
        assertEquals(expectedEven, oe.getEvens());
        assertEquals(expectedOdd, oe.getOdds());
    }

    @Test
    public void test1FindIndexOf() {
        int expected = 2;
        int valueToFind = 102;

        assertEquals(expected, Arraz.findIndexOf(ints, valueToFind));
    }

    @Test
    public void test2FindIndexOf() {
        assertEquals(-1, Arraz.findIndexOf(ints2, 100));
    }

    @Test
    public void test1CopyArrayByIterator() {
        Integer[] intToCopy = new Integer[] {6,10,31};
        Integer[] copy = Arraz.copyArrayByInterator(intToCopy);

        assertTrue(Arrays.equals(intToCopy, copy));
    }

    @Test
    public void test2CopyArrayByIterator() {
        Integer[] intToCopy = new Integer[] {};
        Integer[] copy = Arraz.copyArrayByInterator(intToCopy);

        assertTrue(Arrays.equals(intToCopy, copy));
    }

    @Test
    public void test1CopyArrayByLoop() {
        Integer[] intToCopy = new Integer[] {};
        Integer[] copy = Arraz.copyArrayByLoop(intToCopy);

        assertTrue(Arrays.equals(intToCopy, copy));
    }

    @Test
    public void test2CopyArrayByLoop() {
        Integer[] intToCopy = new Integer[] {};
        Integer[] copy = Arraz.copyArrayByLoop(intToCopy);

        assertTrue(Arrays.equals(intToCopy, copy));
    }

    @Test
    public void test1removeElementFromArray() {
        Integer[] ints2remove6 = new Integer[] {10,31};
        Integer[] actual = Arraz.removeElementFromArray(ints2, 6);

        assertTrue(Arrays.equals(ints2remove6, actual));
    }

    @Test
    public void test2RemoveElementFromArray() {
        assertTrue(Arrays.equals(ints2, Arraz.removeElementFromArray(ints2, 0)));
    }

    @Test
    public void test1InsertIntoArrayAt() {
        int indexToInsert = 3;
        Integer valueToInsert = 10;

        Integer[] expected = {4,5,102,10, -7,12,-32,92,8};
        assertTrue(Arrays.equals(expected, Arraz.insertIntoArrayAt(ints, indexToInsert, valueToInsert)));
    }

    @Test
    public void test2InsertIntoArrayAt() {
        assertTrue(Arrays.equals(ints2, Arraz.insertIntoArrayAt(ints2, 100, 10)));
    }

    @Test
    public void test1findMaxMinOfArray() {
        Integer max = 31;
        Integer min = 6;

        assertEquals(max, Arraz.findMaxMinOfArray(ints2).getMax());
        assertEquals(min, Arraz.findMaxMinOfArray(ints2).getMin());
    }

    @Test
    public void test2findMaxMindOfArray() {
        Integer[] arr = {0, 0, 0, 0, 0};

        assertEquals(0, Arraz.findMaxMinOfArray(arr).getMax());
        assertEquals(0, Arraz.findMaxMinOfArray(arr).getMin());
    }

    @Test
    public void test1RemoveDupesFromArray() {
        Integer[] arr = {0, 0, 0, 0, 3, 3, 1, 1, 5};
        Integer[] exp = {0, 3, 1, 5};

        assertEquals(exp, Arraz.removeDupesFromArray(arr));
    }

    @Test
    public void test2RemoveDupesFromArray() {
        assertEquals(ints2, Arraz.removeDupesFromArray(ints2));
    }

    @Test
    public void test1find2ndLargestValueFromArray() {
        int expected = 10;
        assertEquals(expected, Arraz.find2ndLargestValueFromArray(ints2));
    }

    @Test
    public void test2Find2NdLargestValueFromArray() {
        int expected = -7;
        assertEquals(expected, Arraz.find2ndLargestValueFromArray(ints));
    }

    @Test
    public void testMakeMeAnArrayListFromArray() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(ints2));
        assertEquals(arrayList, Arraz.makeMeAnArrayListFromArray(ints2));
    }

    @Test
    public void test2MakeMeAnArrayListFromArray() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(ints));
        assertEquals(arrayList, Arraz.makeMeAnArrayListFromArray(ints));
    }

    @Test
    public void test1MakeMeAnArrayFromArrayList() {
        ArrayList<Integer> arrayList = Arraz.makeMeAnArrayListFromArray(ints);
        assertEquals(ints, Arraz.makeMeAnArrayFromArrayList(arrayList));
    }

    @Test
    public void test2MakeMeAnArrayFromArrayList() {
        ArrayList<Integer> arrayList = Arraz.makeMeAnArrayListFromArray(ints2);
        assertEquals(ints2, Arraz.makeMeAnArrayFromArrayList(arrayList));
    }

    @Test
    public void test1check2ArraysForEqual() {
        assertTrue(Arraz.check2ArraysForEqual(ints, ints));
    }

    @Test
    public void test2check2ArraysForEqual() {
        assertFalse(Arraz.check2ArraysForEqual(ints, ints2));
    }

    @Test
    public void test1AverageArrayWithoutMaxMin() {
        int expected = 10;
        assertEquals(expected, Arraz.averageArrayWithoutMaxMin(ints2));
    }

    @Test
    public void test2AverageArrayWithoutMaxMin() {
        int expected = 17;
        assertEquals(expected, Arraz.averageArrayWithoutMaxMin(ints));
    }

    @Test
    public void test1ArrayHas65and77() {
        assertFalse(Arraz.arrayHas65and77(ints2));
    }

    @Test
    public void test2ArrayHas65and77() {
        Integer[] arr = {65, 77};
        assertTrue(Arraz.arrayHas65and77(arr));
    }

    @Test
    public void test1theTotalOfTensIs30() {
        assertFalse(Arraz.theTotalOfTensIs30(ints));
    }

    @Test
    public void test2theTotalOfTensIs30() {
        Integer[] arr = {10, 10, 10};
        assertTrue(Arraz.theTotalOfTensIs30(arr));
    }

    @Test
    public void test1find2Smallest() {
        TwoSmallest smallest = new TwoSmallest(0, 1);
        Integer[] arr = {0, 1};
        assertEquals(smallest.getSmallest(), Arraz.find2Smallest(arr).getSmallest());
    }

    @Test(expected = NullPointerException.class)
    public void test2Find2Smallest() {
        Integer[] arr = {};
        Arraz.find2Smallest(arr);
        assertEquals(0, Arraz.find2Smallest(arr).getSecond_smallest());

        /* refactor to handle this */
    }

    @Test
    public void test1MakeMeACopyPlease() {
        Integer[] exp = Arraz.reverseArray(ints);
        assertEquals(exp, Arraz.makeMeACopyPlease(ints));
    }

    @Test
    public void test2MakeMeACopyPlease() {
        Integer[] exp = Arraz.reverseArray(ints2);
        assertEquals(exp, Arraz.makeMeACopyPlease(ints2));
    }

    @Test
    public void test1removeLastItemAndCopy() {
        Integer[] exp = {6, 10};
        assertEquals(exp, Arraz.removeLastItemAndCopy(ints2));
    }

    @Test
    public void test2RemoveLastItemAndCopy() {
        Integer[] exp = {4,5,102,6,-7,12,-32,92};
        assertEquals(exp, Arraz.removeLastItemAndCopy(ints));
    }

    @Test
    public void test1RemoveFirstItemAndCopy() {
        Integer[] exp = {10, 31};
        assertEquals(exp, Arraz.removeFirstItemAndCopy(ints2));
    }

    @Test
    public void test2RemoveFirstItemAndCopy() {
        Integer[] exp = {5,102,6,-7,12,-32,92,8};
        assertEquals(exp, Arraz.removeFirstItemAndCopy(ints));
    }

    @Test
    public void test1InsertAtStartAndCopy() {
        Integer[] exp = {1, 4, 5,102,6,-7,12,-32,92,8};
        Integer[] actual = Arraz.insertAtStartAndCopy(ints, 1);
        assertEquals(exp, actual);
    }

    @Test
    public void test2InsertAtStartAndCopy() {
        Integer[] exp = {5, 6, 10, 31};
        assertEquals(exp, Arraz.insertAtStartAndCopy(ints2,5));
    }

    @Test
    public void test1InsertAtEndAndCopy() {
        Integer[] exp = {4, 5,102,6,-7,12,-32,92,8, 1};
        assertEquals(exp, Arraz.insertAtEndAndCopy(ints, 1));
    }

    @Test
    public void test2InsertAtEndAndCopy() {
        Integer[] exp = {6, 10, 31, 5};
        assertEquals(exp, Arraz.insertAtEndAndCopy(ints2, 5));
    }

    @Test
    public void test1sortArrayIntoEvensThenOdds() {
        Integer[] exp = {6, 10, 31};
        assertEquals(exp, Arraz.sortArrayIntoEvensThenOdds(ints2));
    }

    @Test
    public void test2SortArrayIntoEvensThenodds() {
        Integer[] exp = {4, 102, 6, 12, -32, 92, 8, 5, -7};
        assertEquals(exp, Arraz.sortArrayIntoEvensThenOdds(ints));
    }
}