package io.zipcoder.interfaces;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class StudentsTest {
    @Test
    public void testSingletonInstance() {

        Students instance1 = Students.getInstance();
        Students instance2 = Students.getInstance();

        Assert.assertSame(instance1, instance2);
    }

    @Test
    public void testInitializationSetupStudents() {

        Students students = Students.getInstance();

        Assert.assertSame(39, students.getArray().length);
    }
}