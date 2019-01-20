package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by leon on 1/23/18.
 */

public class PhoneBookTest {

    PhoneBook testPhonebook;
    ArrayList<String> expectedNumbers;

    public PhoneBookTest() {
        testPhonebook = new PhoneBook();
        testPhonebook.addPerson("Trinh", "1-800-888-8888");
        expectedNumbers = new ArrayList<>();
        expectedNumbers.add("1-800-888-8888");
    }

    @Test
    public void testHasEntry() {
        // Given
        boolean expectedEntry = true;
        String name = "Trinh";

        // When
        boolean actualEntry = testPhonebook.hasEntry(name);

        // Then
        Assert.assertEquals(expectedEntry, actualEntry);
    }

    @Test
    public void testAddNumberToEntry() {
        // Given
        expectedNumbers.add("1-700-777-7777");
        String key = "Trinh";

        // When
        testPhonebook.addNumbersToList(key, "1-700-777-7777");

        ArrayList<String> actualNumbers = testPhonebook.phoneList.get(key);
        // Then
        Assert.assertEquals(expectedNumbers,actualNumbers);
    }

    @Test
    public void testLookupByName() {
        // Given

        String name = "Trinh";

        // When
        String actualNumber = testPhonebook.lookupByName(name);

        // Then
        Assert.assertEquals(expectedNumbers.toString(), actualNumber);
    }

    @Test
    public void testRemove() {
        // Given
        boolean expectedReturn = false;
        String name = "Trinh";

        // When
        testPhonebook.removeRecord(name);
        boolean actualReturn = testPhonebook.hasEntry(name);

        // Then

        Assert.assertEquals(expectedReturn, actualReturn);
    }

    // Tested and working above
    @Test
    public void testReverseLookup() {
        // Given
        String number = "1-800-888-8888";
        String expectedName = "Trinh";

        // When
        String actualName = testPhonebook.reverseLookup(number);

        // Then
        Assert.assertEquals(expectedName,actualName);
    }

    @Test
    public void testReverseLookupFail() {
        // Given
        String number = "1-700-777-7777";
        String expectedName = "Invalid Phone Number.";

        // When
        String actualName = testPhonebook.reverseLookup(number);

        // Then
        Assert.assertEquals(expectedName,actualName);
    }

    @Test
    public void testListAll() {
        // Given
        String expectedList = "Trinh 1-800-888-8888";

        // When
        String actualList = testPhonebook.listAll();
        // Then

        Assert.assertEquals(expectedList, actualList);
    }
}
