package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    private ArrayList<T> newList;
    private T[] content;

    public ArrayUtility(T[] content) {
        this.content = content;
        newList = new ArrayList<>(Arrays.asList(content));
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T value) {

        mergeArray(arrayToMerge);
        return dupeMap().get(value);
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        mergeArray(arrayToMerge);

        T data = newList.get(0);

        for(T key: dupeMap().keySet()) {
            if (dupeMap().get(key) > dupeMap().get(data)) {
                data = key;
            }
        }
        return data;
    }

    public HashMap<T, Integer> dupeMap() {

        HashMap<T, Integer> duplicateCount = new HashMap<>();

        for (T e: newList) {
            if (!duplicateCount.keySet().contains(e)) {
                duplicateCount.put(e, 1);
            } else {
                duplicateCount.put(e, duplicateCount.get(e) + 1);
            }
        }

        return duplicateCount;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        return dupeMap().get(valueToEvaluate);
    }

    public void mergeArray(T[] arrayToMerge) {
        for (T e: arrayToMerge) {
            newList.add((e));
        }
    }


    public T[] removeValue(T valueToRemove) {
        ArrayList<T> valuesNotRemoved = new ArrayList<>();

        for (T data:newList) {
            if (!data.equals(valueToRemove)) {
                valuesNotRemoved.add(data);
            }
        }
        System.out.println(content.getClass().getComponentType());
        //was creating the new array but was empty.
        T[] objs =  (T[])Array.newInstance(content.getClass().getComponentType(), valuesNotRemoved.size());

        return valuesNotRemoved.toArray(objs);
    }
}
