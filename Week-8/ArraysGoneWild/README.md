# ArraysGoneWild

This is a series of java array problems to prove your array knowledge.

__You may ONLY use the information in the DocumentationOnArrays folder only...__

## NO GOOGLE on this lab.

At this point you should be able to write up these methods without searching for code patterns
on google.

## NO STACK-OVERFLOW on this lab.

At this point you should be able to write up these methods without searching for code patterns
on StackOverflow.

At this point in the cohort, you should be able to glance at the problem, write a couple tests,
nd then implement the method.

### For each problem.

For each of these problems, you need to write the method itself, and two tests for each method. 
If the method is named `sumValuesOfArray`, you should write two test methods:
* test1sumValuesOfArray
* test2sumValuesOfArray

### Problem list

Write a method in the Arraz class for each of these:

* sum values of an array of integers `sumValuesOfArray`
* sum values of an array of doubles `sumDoublesOfArray`
* calculate the average value of an integer array - return an integer `averageOfArray`
* calculate the average value of an double array - return an double `doubleAverageOfArray`
* to test if an integer array contains a specific value, pass both array and value as arguments `containsValue`
* reverse an array of integer values `reverseArray`
* find the number of even and odd integers in a given array of integers `getOddEvensOfArray`, return an object of type
```java
public class OddEven{
    public int odds;
    public int evens;
}
```

* find the index of an array element, pass both array and value as arguments `findIndexOf`
* copy an array by iterating the array `copyArrayByInterator`
* copy an array by looping thru the array `copyArrayByLoop`
* remove a specific element from an array `removeElementFromArray`
* insert an element into an array a specific position `insertIntoArrayAt`
* find the maximum and minimum value of an array `findMaxMinOfArray` return a 
```java
public class MaxMin{
    public int max;
    public int min;
}
```
* remove duplicate elements from an array, return new array `removeDupesFromArray` (make it an array of Integers)
* find the second largest element in an array of Doubles `find2ndLargestValueFromArray`

* convert an array to ArrayList `makeMeAnArrayListFromArray`
* convert an ArrayList to an array `makeMeAnArrayFromArrayList`
* test the equality of two arrays `check2ArraysForEqual`
* compute the average value of an array of integers except the largest and smallest values (be thinking
of code re-use for this one) `averageArrayWithoutMaxMin`
* check if an array of integers contains two specified elements: 65 and 77, returns a boolean `arrayHas65and77`
* check if the sum of all the 10's in the array is exactly 30. Return false if the condition does not satisfy, otherwise true. `theTotalofTensIs30`
* find smallest and second smallest elements of a given array

* copy an array of integers, reverse it, and return it. `makeMeACopyPlease`
* remove the last element from an array of integers, return a copy `removeLastItemAndCopy`
* remove the first element from an array of integers, return a copy `removeFirstItemAndCopy`
* insert a new element at the start of an array, return a copy `insertAtStartAndCopy`
* insert a new element at the end of an array, return a copy `insertAtEndAndCopy`

* separate even and odd numbers of an given array of integers. Put all even numbers first, and then odd numbers `sortArrayIntoEvensThenOdds`

If you need an array of ints use this one.
```java
int[] spiffyHandyIntArray = new int[] {4,5,102,6,-7,12,-32,92,8};
```


If you need an array of Doubles use this one.
```java
Double[] spiffyHandyDoubleArray = new Double[] {1.0, 0.5, 3.6, 38.4, 17.3, 62.0, 9.0, 3.375, 0, 3.14159};
```

__But, if you don't like these arrays, feel free to make your own.__