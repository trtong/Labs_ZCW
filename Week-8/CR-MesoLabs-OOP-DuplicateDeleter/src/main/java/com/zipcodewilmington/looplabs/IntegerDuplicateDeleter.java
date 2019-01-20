package com.zipcodewilmington.looplabs;

import java.util.Arrays;

/**
 * Created by leon on 1/29/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class IntegerDuplicateDeleter extends DuplicateDeleter<Integer> {

    private ArrayUtils<Integer> arrayUtils;
    public IntegerDuplicateDeleter(Integer[] intArray) {
        super(intArray);
         arrayUtils = new ArrayUtils<>(intArray);
    }

    @Override
    public Integer[] removeDuplicates(int maxNumberOfDuplications) {
        return arrayUtils.removeDupes(super.array, maxNumberOfDuplications);
    }

    @Override
    public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        return arrayUtils.removeDupesExactly(super.array, exactNumberOfDuplications);
    }
}
