package com.zipcodewilmington;

/**
 * Created by leon on 1/24/18.
 */
public class PersonHandler {
    private final Person[] personArray;

    public PersonHandler(Person[] personArray) {
        this.personArray = personArray;
    }

    public String whileLoop() {
        String result = "";
        int counter = 0;
        // assume there is a `counter`
        // while `counter` is less than length of array
            // begin loop
        while (counter < personArray.length) {
            Person newPerson = personArray[counter];
            result += newPerson;
            counter++;
        }
                // use `counter` to identify the `current Person` in the array
                // get `string Representation` of `currentPerson`
                // append `stringRepresentation` to `result` variable
            // end loop
        return result;
    }

    public String forLoop() {
        String result = "";
        // identify initial value
        // identify terminal condition
        // identify increment
        for (int counter = 0; counter < personArray.length; counter++) {
            Person newPerson = personArray[counter];
            result += newPerson;
        }

        // use the above clauses to declare for-loop signature
            // begin loop
                // use `counter` to identify the `current Person` in the array
                // get `string Representation` of `currentPerson`
                // append `stringRepresentation` to `result` variable
            // end loop

        return result;
    }

    public String forEachLoop() {
        String result = "";
        // identify array's type
        // array type = person
        // identify array's variable-name

        // use the above discoveries to declare for-each-loop signature
            // begin loop
        for (Person person: personArray) {
            result += person;
        }
         // This was wrong, why?
            // because I was trying to append the whole array and not the object "person"
//        for (Person person: personArray) {
//            result += personArray;
//        }


                // get `string Representation` of `currentPerson`
                // append `stringRepresentation` to `result` variable
            // end loop

        return result;
    }


    public Person[] getPersonArray() {
        return personArray;
    }
}
