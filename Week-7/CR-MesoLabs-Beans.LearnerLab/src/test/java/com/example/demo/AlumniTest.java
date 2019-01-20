package com.example.demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlumniTest {
    private Alumni alumni;
    private Instructors instructors;
    private Students previousCohort;
    private final double DELTA = 0.0;

    @Before
    public void setUp() {

        Instructor instructor1 = new Instructor(0L, "Instructor 1");
        Instructor instructor2 = new Instructor(1L, "Instructor 2");
        instructors = new Instructors(instructor1, instructor2);

        Student jared = new Student(100L, "jared");
        Student earHat = new Student(200L, "catHat");

        previousCohort = new Students(jared, earHat);

        alumni = new Alumni(previousCohort, instructors);
        alumni.executeBootCamp();
    }

    @Test
    public void testExecuteBootcamp() {

        int numberOfInstructors = instructors.size();
        int numberOfStudents = previousCohort.size();
        double numberOfHoursToTeachEachStudent = 1200;
        double numberOfHoursToTeach = numberOfHoursToTeachEachStudent * numberOfStudents;
        double numberOfHoursPerInstructor = numberOfHoursToTeach / numberOfInstructors;
        double actualHours = 0;

        for (Student s:previousCohort) {
            actualHours += s.getTotalStudyTime();
            Assert.assertEquals(numberOfHoursPerInstructor, s.getTotalStudyTime()*2, DELTA);
        }

        Assert.assertEquals(numberOfHoursToTeachEachStudent, actualHours, DELTA);
    }
}
