package com.example.demo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InstructorTest {
    private Student trinh, jared;
    private Instructor nhu;
    private double hoursCounter;
    private People<Student> students;

    @Before
    public void setUp() {
        trinh = new Student(100L, "Trinh");
        jared = new Student(101L, "Jared");

        nhu = new Instructor(500L, "Nhu");

        students = new Students(jared, trinh);
        hoursCounter = 0.0;
    }

    @Test
    public void constructorInitializesAsExpected() {
        long id = 0L;
        String name = "instructor";

        Instructor instructor = new Instructor(id, name);

        assertEquals(id, instructor.getId());
        assertEquals(name, instructor.getName());
    }

    @Test
    public void testTeachIncreasesTotalStudyTime() {
        for (int i = 0; i < 10; i++) {
            nhu.teach(trinh, i);
            hoursCounter += i;
            assertEquals(hoursCounter, trinh.getTotalStudyTime(), 0.0);
        }
    }

    @Test
    public void testLectureIncreasesTotalStudyTime() {
        for (double i = 0.0; i < 10; i += 1.1) {
            nhu.lecture(students, i);
            hoursCounter += i;
            students.forEach(student -> assertEquals(hoursCounter / students.size(), student.getTotalStudyTime(), 0.01));
        }
    }
}