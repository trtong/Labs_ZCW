package io.zipcoder.interfaces;

import java.util.ArrayList;

public final class Students extends People<Student> {

    private static final Students INSTANCE = new Students();

    private Students() {
        personList.add(new Student(1, "Ned Redmond"));
        personList.add(new Student(2, "Seth Abrams"));
        personList.add(new Student(3, "Akeem Cherry"));
        personList.add(new Student(4, "Whitney Martinez"));
        personList.add(new Student(5, "Nira Parikh"));
        personList.add(new Student(6, "Connor Dunnigan"));
        personList.add(new Student(7, "Christian Sheridan"));
        personList.add(new Student(8, "Curtis Cook"));
        personList.add(new Student(9, "Nuridalia Hernandez"));
        personList.add(new Student(10, "Brandon DeFrancis"));
        personList.add(new Student(11, "De'Jon Johnson"));
        personList.add(new Student(12, "Demetrius Murray"));
        personList.add(new Student(13, "Elliott Stansbury"));
        personList.add(new Student(14, "Nathan Hall"));
        personList.add(new Student(15, "Jae Joson"));
        personList.add(new Student(16, "Jacob Anderson"));
        personList.add(new Student(17, "Jose Bedolla"));
        personList.add(new Student(18, "Jenn Chao"));
        personList.add(new Student(19, "Jennifer Tinkler"));
        personList.add(new Student(20, "Jonathan Hinds"));
        personList.add(new Student(21, "Jay Samuels"));
        personList.add(new Student(22, "Jevit Tith"));
        personList.add(new Student(23, "Lauren Green"));
        personList.add(new Student(24, "Kate Moore"));
        personList.add(new Student(25, "Michelle DiMarino"));
        personList.add(new Student(26, "Maggie Pierse"));
        personList.add(new Student(27, "Nick Satinover"));
        personList.add(new Student(28, "Chaitali Patel"));
        personList.add(new Student(29, "Yesoda Sanka"));
        personList.add(new Student(30, "Saurav Kamath"));
        personList.add(new Student(31, "Sam Bhutani"));
        personList.add(new Student(32, "Soujanya Buragapu"));
        personList.add(new Student(33, "Steffon Williams"));
        personList.add(new Student(34, "Zavon Malone"));
        personList.add(new Student(35, "Thuy Kong"));
        personList.add(new Student(36, "Thulasi Puppala"));
        personList.add(new Student(37, "Trinh Tong"));
        personList.add(new Student(38, "William Brown"));
        personList.add(new Student(39, "Xzavia Cuello"));

    }

    public static Students getInstance() {
        return INSTANCE;
    }

    public Student[] getArray() {
        Student[] students = new Student[personList.size()];

        for (int i = 0; i < personList.size(); i++) {
            students[i] = (Student) personList.get(i);
        }

        return students;
    }
}
