package io.zipcoder.interfaces;

import java.util.ArrayList;

public class ZipCodeWilmington {

    private static final ZipCodeWilmington INSTANCE = new ZipCodeWilmington();
    private static final Students students = Students.getInstance();
    private static final Instructors instructors = Instructors.getInstance();

    private ZipCodeWilmington() {

    }

    public static ZipCodeWilmington getInstance() {
        return INSTANCE;
    }

    public void hostLecture(Teacher teacher, double numberOfHours) {

        Student[] studentList = students.getArray();

        teacher.lecture(studentList, numberOfHours);

    }

    public Students getStudents() {
        return students;
    }

    public Instructors getInstructors() {
        return instructors;
    }

    public void hostLecture(long id, double numberOfHours) {


        for (int i = 0; i < instructors.getCount(); i++) {
            if (instructors.personList.get(i).getId() == id) {
                instructors.personList.get(i).lecture(students.getArray(), numberOfHours);
            }
        }

    }
}
