package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestClassroomConfig {
    private Classroom currentCohort, previousCohort;
    private Instructors currentInstructors, previousInstructors;
    private Students currentStudents, previousStudents;

    @Autowired
    private ClassroomConfig classroomConfig;

    @Before
    public void setup() {
        Instructor instructor1 = new Instructor(0L, "Instructor 1");
        Instructor instructor2 = new Instructor(1L, "Instructor 2");
        Instructor instructor3 = new Instructor(2L, "Instructor 3");
        Instructor instructor4 = new Instructor(3L, "Instructor 4");

        Student student1 = new Student(100L, "Student 1");
        Student student2 = new Student(101L, "Student 2");
        Student student3 = new Student(102L, "Student 3");
        Student student4 = new Student(103L, "Student 4");

        currentInstructors = new Instructors(instructor1, instructor2);
        currentStudents = new Students(student1, student2);

        previousInstructors = new Instructors(instructor3, instructor4);
        previousStudents = new Students(student3, student4);

        currentCohort = classroomConfig.currentCohort(currentInstructors, currentStudents);
        previousCohort = classroomConfig.previousCohort(previousInstructors, previousStudents);
    }

    @Test
    public void testCurrentCohort() {
        assertEquals(currentCohort, classroomConfig.currentCohort(currentInstructors, currentStudents));
        assertNotEquals(currentCohort, previousCohort);
    }

    @Test
    public void testPreviousCohort() {
        assertEquals(previousCohort, classroomConfig.previousCohort(previousInstructors, previousStudents));
        assertNotEquals(previousCohort, currentCohort);
    }
}
