package com.zipcodewilmington.phonebook;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */

public class PhoneBook {

    TreeMap<String, ArrayList<String>> phoneList = new TreeMap<>();
    Set<String> allNames = phoneList.keySet();

    public void addNumbersToList(String key, String number) {

        this.phoneList.get(key).add(number);
    }

    public void addPerson(String key, String number) {

        ArrayList<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add(number);
        this.phoneList.put(key, phoneNumbers);
    }

    public boolean hasEntry(String nameToFind) {

        return this.phoneList.containsKey(nameToFind);
    }

    public String phoneNumberFormatter(String number) {

        return number.replace("[", "").replace("]", "");
    }


    public String lookupByName(String lookupName) {
        for (String key: allNames) {
            if (key.equals(lookupName)) {
                return this.phoneList.get(lookupName).toString();
            }
        }

        return "Invalid Name.";
    }

    public void removeRecord(String nameToRemove) {

        phoneList.remove(nameToRemove);
    }

    public String reverseLookup(String lookupNumber) {

        for (String key : allNames) {
            for (String numbers : phoneList.get(key)) {
                if (this.phoneNumberFormatter(numbers).equals(lookupNumber)) {
                return key;
                }
            }
        }
        return "Invalid Phone Number.";
    }

    public String listAll() {
        StringBuilder listAll = new StringBuilder();

        for (String key: allNames) {
            listAll.append(key + " " + phoneList.get(key));
        }

        return this.phoneNumberFormatter(listAll.toString());
    }
}
