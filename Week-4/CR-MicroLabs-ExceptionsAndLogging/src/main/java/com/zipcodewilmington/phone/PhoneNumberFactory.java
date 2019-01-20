package com.zipcodewilmington.phone;

import com.zipcodewilmington.exceptions.InvalidPhoneNumberFormatException;

import java.util.Random;
import java.util.logging.Logger;

/**
 * Created by leon on 5/1/17.
 */
public final class PhoneNumberFactory {
    private static final Logger logger = Logger.getGlobal();

    private PhoneNumberFactory() {
        /** This constructor is private
         *  This class is uninstantiable */
    }

    /**
     * @param phoneNumberCount - number of PhoneNumber objects to instantiate
     * @return array of randomly generated PhoneNumber objects
     */ //TODO - Implement logic
    public static PhoneNumber[] createRandomPhoneNumberArray(int phoneNumberCount) {

        PhoneNumber[] phoneBook =  new PhoneNumber[phoneNumberCount];

        for (int i = 0; i < phoneNumberCount; i++) {
            phoneBook[i] = createRandomPhoneNumber();
        }

        return phoneBook;
    }


    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    public static PhoneNumber createRandomPhoneNumber() {
        Random randomGen = new Random();
        int areaCode = randomGen.nextInt(900) + 100;

        int centralOfficeCode = randomGen.nextInt(900) + 100;

        int phoneLineCode = randomGen.nextInt(8999) + 1000;
        System.out.println("area Code: " + areaCode + "\tCentral office: " + centralOfficeCode + "\tPhoneLine: " + phoneLineCode);

        return createPhoneNumberSafely(areaCode, centralOfficeCode, phoneLineCode);
    }


    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODO - if input is valid, return respective PhoneNumber object, else return null
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) {
        PhoneNumber returnNumber = null;
        try {
            StringBuilder builder = new StringBuilder();
            builder.append("(" + areaCode + ")-" + centralOfficeCode + "-" + phoneLineCode);
            returnNumber = createPhoneNumber(builder.toString());
            return returnNumber;
        } catch (InvalidPhoneNumberFormatException e) {
            logger.info(returnNumber + " is not a valid phone number.");
            return null;
        }
    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODO - Add throws statement to method signature
    public static PhoneNumber createPhoneNumber(String phoneNumberString) throws InvalidPhoneNumberFormatException {

        PhoneNumber returnNumber = null;
        returnNumber = new PhoneNumber(phoneNumberString);
        logger.info("Attempting to create a new PhoneNumber object with a value of " + returnNumber);

        return returnNumber;
    }
}
