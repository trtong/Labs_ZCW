package io.zipcoder.interfaces;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EducatorTest {

    @Test
    public void testImplementation() {

        Students students = Students.getInstance();

        Educator educator = Educator.KRIS;

        educator.lecture(students.getArray(), 10);

        Assert.assertEquals(10, educator.getTimeWorked(), 0.5);

    }
}