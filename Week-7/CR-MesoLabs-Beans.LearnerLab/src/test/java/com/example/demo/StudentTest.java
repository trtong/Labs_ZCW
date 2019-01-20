package com.example.demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {
    private Student trinh;

    @Before
    public void setUp() {
        trinh = new Student(2L, "Trinh");
    }

    @Test
    public void constructorInitializesAsExpected() {
        long id = 1L;
        String name = "student";

        Student student = new Student(id, name);

        assertEquals(id, student.getId());
        assertEquals(name, student.getName());
        assertEquals(0, student.getTotalStudyTime(), 0.0);
    }

    @Test
    public void testLearn() {
        double numberOfHours = 100;

        trinh.learn(numberOfHours);

        Assert.assertEquals(numberOfHours, trinh.getTotalStudyTime(), 0.0);
    }
}