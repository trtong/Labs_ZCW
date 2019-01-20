package com.zipcodewilmington.looplabs;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayUtils<T> {

    private T[] content;

    public ArrayUtils(T[] content) {
        this.content = content;
    }

    public T[] removeDuplicates(T[] arr, T value) {
        int countOfValue = countValues(arr, value);
        int index = 0;
        T[] arr2 =  (T[]) Array.newInstance(content.getClass().getComponentType(), arr.length - countOfValue);
        for (T i: arr
             ) {
            if (!i.equals(value)) {
                arr2[index++] = i;
            }
        }
        return arr2;
    }

    public int countValues(T[] arr, T value) {
        int countOfValue = 0;

        for (T t: arr
        ) {
            if (t.equals(value)) {
                countOfValue++;
            }
        }
        return countOfValue;
    }

    public T[] removeDupes(T[] arr, int maxNumberOfDuplications) {
        T[] arr2 = Arrays.copyOf(arr, arr.length);
        for (T i: arr2) {
            if ((countValues(arr2, i) >= maxNumberOfDuplications)) {
                arr2 = removeDuplicates(arr2, i);
            }
        }
        return arr2;
    }

    public T[] removeDupesExactly(T[] arr, int exactNumberOfDuplications) {

        T[] arr2 = Arrays.copyOf(arr, arr.length);
        for (T i: arr2
             ) {
            if ((countValues(arr2, i) == exactNumberOfDuplications)) {
                arr2 = removeDuplicates(arr2, i);
            }
        }

        return arr2;
    }

}
