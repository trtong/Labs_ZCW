package io.zipcoder.interfaces;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {
    Student student;

    public StudentTest() {
        student = new Student(1234, "Zuko");
    }

    @Test
    public void testImplementation() {
        // Tests that student implements learner
        Assert.assertTrue(student instanceof Learner);

    }

    @Test
    public void testInheritence() {
        Assert.assertTrue(student instanceof Person);
    }

    @Test
    public void testLearn() {

        student.learn(10);

        Assert.assertEquals(10, student.getTotalStudyTime(), .05);
    }
}