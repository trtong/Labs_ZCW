package io.zipcoder.interfaces;

import static io.zipcoder.interfaces.Educator.*;

public class Instructors extends People<Instructor> {

    private static final Instructors INSTANCE = new Instructors();

    private Instructors() {

        personList.add(new Instructor(100, "Kristofer Younger"));
        personList.add(new Instructor(101, "Froilan Miranda"));
        personList.add(new Instructor(102, "L. Dolio Durant"));
        personList.add(new Instructor(103, "Leon Hunter"));
        personList.add(new Instructor(104, "Nhu Nguyen"));
        personList.add(new Instructor(105, "Dominique Clarke"));
        personList.add(new Instructor(105, "Wilhem Alcivar"));

    }

    @Override
    public Instructor[] getArray() {

        Instructor[] instructors = new Instructor[personList.size()];

        for (int i = 0; i < personList.size(); i++) {
            instructors[i] = (Instructor) personList.get(i);
        }

        return instructors;
    }

    public static Instructors getInstance() {
        return INSTANCE;
    }
}
