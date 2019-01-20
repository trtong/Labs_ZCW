package com.zipcodewilmington;

import com.sun.deploy.util.ArrayUtil;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {

        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {

        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {

        return array[array.length - 1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {

        return array[array.length - 2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        boolean checker = false;

        for (String word: array) {
            if (word.equals(value)) {
                checker = true;
                break;
            }
        }

        return checker;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {

        String[] reversedString = new String[array.length];

        for (int i = array.length - 1, j = 0; i >= 0; i--, j++) {
            reversedString[j] = array[i];
        }
        return reversedString;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        boolean palindromToken = false;
        String[] reversedArray = StringArrayUtils.reverse(array);

        for (int i = 0; i < array.length; i++) {
            if (reversedArray[i].equals(array[i]) == true) {
                palindromToken = true;
            }
        }
        return palindromToken;
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {

        boolean finderToken = true;

        StringBuilder stringMaker = new StringBuilder();
        for (String word: array) {
            stringMaker.append(word);
        }

        String fullArrayString = stringMaker.toString().toLowerCase();

        char find = 'a';

        while (finderToken && find <= 'z') {
            if (fullArrayString.indexOf(find) == -1) {
                finderToken = false;
            }
            find++;
        }

        return finderToken;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int counter = 0;
        for (String word: array) {
            if (word.equals(value) == true) {
                counter += 1;
            }
        }
        return counter;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {

        ArrayList<String> removedWordsArrayList = new ArrayList<String>(Arrays.asList(array));

        for (int i = 0; i < removedWordsArrayList.size(); i++) {
            if (removedWordsArrayList.get(i) == valueToRemove ) {
                removedWordsArrayList.remove(i);
            }
        }

        String[] newArray = new String[removedWordsArrayList.size()];

        newArray = removedWordsArrayList.toArray(newArray);

        return newArray;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {

        String[] newArray = new String[array.length];
        String compare = "";
        int newLength = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(compare) == false) {
                compare = array[i];
                newArray[newLength] = compare;
                newLength++;
            }
        }
        return Arrays.copyOf(newArray, newLength);
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {

        String[] newArray = new String[array.length];
        String firstCompare = array[0];
        String secondCompare = array[0];

        int newLength = 0;

        for (int i = 1; i < array.length; i++) {

            if (!array[i].equals(firstCompare)) {
                firstCompare = array[i];

                newArray[newLength] = secondCompare;

                secondCompare = array[i];

                newLength++;

            } else {
                secondCompare += array[i];
            }
        }

        newArray[newLength] = secondCompare;

        return Arrays.copyOf(newArray,  newLength + 1);
    }


}
