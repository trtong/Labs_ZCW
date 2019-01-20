import java.util.*;

public class Arraz {

    public static Integer sumValuesOfArray(Integer[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static double sumDoublesOfArray(double[] arr) {
        double sum = 0.0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static Integer averageOfArray(Integer[] ints) {
        try {
            return (sumValuesOfArray(ints) / ints.length);
        } catch (ArithmeticException divideByZero) {
            return 0;
        }
    }

    public static double doubleAverageOfArray(double[] doubles) {
        return (sumDoublesOfArray(doubles) / doubles.length);
    }


    public static boolean containsValue(Integer[] ints, int val) {

        for (int i : ints) {
            if (i == val) {
                return true;
            }
        }

        return false;
    }

    public static Integer[] reverseArray(Integer[] ints2) {
        Integer[] ints = new Integer[ints2.length];
        int count = 0;
        for (int i = ints2.length - 1; i >= 0; i--) {
            ints[count] = ints2[i];
            count++;
        }
        return ints;
    }

    public static OddEven getOddEvensOfArray(Integer[] arr) {
        OddEven oe = new OddEven();
        for (int i : arr) {
            if (NumberUtils.isOdd(i)) {
                oe.incrementOdd();
            } else {
                oe.incrementEven();
            }
        }
        return oe;
    }

    public static Integer findIndexOf(Integer[] ints, Integer valueToFind) {
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == valueToFind) {
                return i;
            }
        }

        return -1;
    }

    public static Integer[] copyArrayByInterator(Integer[] arr) {
        Integer[] arr2 = new Integer[arr.length];
        Iterator interator = Arrays.asList(arr).listIterator();
        int i = 0;
        while (interator.hasNext()) {
            arr2[i++] = (Integer) interator.next();
        }

        return arr2;
    }

    public static Integer[] copyArrayByLoop(Integer[] intToCopy) {
        Integer[] loopArray = new Integer[intToCopy.length];

        for (int i = 0; i < intToCopy.length; i++) {
            loopArray[i] = intToCopy[i];
        }

        return loopArray;
    }


    private static int countElements(Integer[] ints2, int i) {
        int count = 0;
        for (int j = 0; j < ints2.length; j++) {
            if (ints2[j] == i) {
                count++;
            }
        }
        return (count > 0) ? count : -1;
    }

    private static boolean isCountNegative(int count) {
        return count < 0;
    }

    public static Integer[] removeElementFromArray(Integer[] ints2, int i) {
        int count = countElements(ints2, i);
        if (!isCountNegative(count)) {
            return getIntegers(ints2, i, count);
        }
        return ints2;
    }

    private static Integer[] getIntegers(Integer[] ints2, int i, int count) {
        Integer[] arr = new Integer[ints2.length - count];
        int indexArr = 0;
        for (Integer anInts2 : ints2) {
            if (anInts2 != i) {
                arr[indexArr++] = anInts2;
            }
        }
        return arr;
    }

    public static Integer[] insertIntoArrayAt(Integer[] ints, int index, Integer value) {
        if (!(index > ints.length)) {
            ints[index] = value;
            return ints;
        }

        return ints;
    }

    public static MaxMin findMaxMinOfArray(Integer[] arr) {
        MaxMin maxMin = new MaxMin();

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (Integer anArr : arr) {
            if (anArr != null) {
                if (anArr < min) {
                    min = anArr;
                } else if (anArr > max) {
                    max = anArr;
                }
            }
        }

        maxMin.setMax(max);
        maxMin.setMin(min);

        return maxMin;
    }

    public static Integer[] removeDupesFromArray(Integer[] arr) {
        Set<Integer> setNoDupes = new LinkedHashSet<Integer>(Arrays.asList(arr));
        return setNoDupes.toArray(new Integer[setNoDupes.size()]);
    }

    public static Integer find2ndLargestValueFromArray(Integer[] arr) {
        Set<Integer> setNoDupes = new TreeSet<Integer>(Arrays.asList(arr));
        Integer[] orderedArr = setNoDupes.toArray(new Integer[setNoDupes.size()]);

        if (orderedArr.length > 1) {
            return orderedArr[1];
        } else if (orderedArr.length == 1) {
            return orderedArr[0];
        } else {
            return null;
        }
    }

    public static ArrayList<Integer> makeMeAnArrayListFromArray(Integer[] arr) {
        return new ArrayList<Integer>(Arrays.asList(arr));
    }

    public static Integer[] makeMeAnArrayFromArrayList(ArrayList<Integer> arrayList) {
        return arrayList.toArray(new Integer[arrayList.size()]);
    }

    public static boolean check2ArraysForEqual(Integer[] ints, Integer[] ints1) {
        if (ints.length != ints1.length)  {
            return false;
        }
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] != ints1[i]) {
                return false;
            }
        }
        return true;
    }

    public static int averageArrayWithoutMaxMin(Integer[] arr) {
        MaxMin mm = findMaxMinOfArray(arr);
        Integer[] noMax = removeElementFromArray(arr, mm.getMax());
        Integer[] noMaxOrMin = removeElementFromArray(noMax, mm.getMin());

        return averageOfArray(noMaxOrMin);
    }

    public static boolean arrayHas65and77(Integer[] arr) {
        return makeMeAnArrayListFromArray(arr).contains(65) && makeMeAnArrayListFromArray(arr).contains(77);
    }

    public static boolean theTotalOfTensIs30(Integer[] arr) {
        int sum = 0;
        for (Integer i: arr
             ) {
            if (i % 10 == 0) {
                sum += i;
            }
        }

        return sum == 30;
    }

    public static TwoSmallest find2Smallest(Integer[] ints) {
        if (ints.length > 1) {
            TwoSmallest twoSmallest = new TwoSmallest();
            int smallest = findMaxMinOfArray(ints).getMin();
            twoSmallest.setSmallest(smallest);

            Integer[] secondSmallest = removeElementFromArray(ints, smallest);
            twoSmallest.setSecond_smallest(findMaxMinOfArray(secondSmallest).getMin());

            return twoSmallest;
        }
        return null;
    }

    public static Integer[] makeMeACopyPlease(Integer[] arr) {
        return copyArrayByInterator(reverseArray(arr));
    }

    private static Integer[] removeElementAtIndex(Integer[] arr, int index) {
        if (index > arr.length) { return arr; }

        Integer[] arr2 = new Integer[arr.length - 1];

        int arr2Index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != index) {
                arr2[arr2Index++] = arr[i];
            }
        }

        return arr2;
    }

    public static Integer[] removeLastItemAndCopy(Integer[] arr) {
        Integer[] arr2 = removeElementAtIndex(arr, arr.length -1);
        return copyArrayByInterator(arr2);
    }

    public static Integer[] removeFirstItemAndCopy(Integer[] arr) {
        return copyArrayByInterator(removeElementAtIndex(arr, 0));
    }

    public static Integer[] insert(Integer[] arr, int index, int value) {
        Integer[] newArray = new Integer[arr.length + 1];
        System.arraycopy(arr, 0, newArray, 0, index);
        System.arraycopy(arr, index, newArray,index + 1, newArray.length - (index + 1));
        newArray[index] = value;
        return newArray;
    }
    public static Integer[] insertAtStartAndCopy(Integer[] arr, int value) {
        return copyArrayByInterator(insert(arr, 0, value));
    }

    public static Integer[] insertAtEndAndCopy(Integer[] arr, int value) {
        return copyArrayByInterator((insert(arr, arr.length, value)));
    }


    public static Integer[] sortArrayIntoEvensThenOdds(Integer[] arr) {
        ArrayList<Integer> odds = new ArrayList<Integer>();
        ArrayList<Integer> evens = new ArrayList<Integer>();

        for (Integer i : arr) {
            if (NumberUtils.isOdd(i)) {
                odds.add(i);
            } else {
                evens.add(i);
            }
        }
        evens.addAll(odds);
        return makeMeAnArrayFromArrayList(evens);
    }
}

