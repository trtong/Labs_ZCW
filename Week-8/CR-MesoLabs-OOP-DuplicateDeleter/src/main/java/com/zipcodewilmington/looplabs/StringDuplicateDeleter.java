package com.zipcodewilmington.looplabs;

import java.util.Arrays;

/**
 * Created by leon on 1/28/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class StringDuplicateDeleter extends DuplicateDeleter<String> {
    private ArrayUtils<String> arrayUtils;
    public StringDuplicateDeleter(String[] intArray) {
        super(intArray);
        arrayUtils = new ArrayUtils<>(intArray);
    }

    @Override
    public String[] removeDuplicates(int maxNumberOfDuplications) {
        return arrayUtils.removeDupes(super.array, maxNumberOfDuplications);
    }

    @Override
    public String[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        return arrayUtils.removeDupesExactly(super.array, exactNumberOfDuplications);
    }
}
