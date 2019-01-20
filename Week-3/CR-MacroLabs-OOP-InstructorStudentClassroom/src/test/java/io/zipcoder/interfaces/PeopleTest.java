package io.zipcoder.interfaces;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PeopleTest {

    Person p1;
    Person p2;
    Student s1;
    Instructor i1;

    Instructors instructors;
    Students students;

    public PeopleTest() {

        instructors = Instructors.getInstance();
        students = Students.getInstance();


        p1 = new Person(1, "bob");
        p2 = new Person(2, "joe");
        s1 = new Student(120, "mun");
        i1 = new Instructor(200, "min");

        students.add(s1);
    }

    @Test
    public void testAdd() {

        Assert.assertEquals(40, students.getCount());

    }

    @Test
    public void testRemoveByPerson() {

        students.remove(s1);

        Assert.assertEquals(39, students.getCount());
    }

    @Test
    public void testRemoveById() {


        long id = 10;
        students.remove(id);

        Assert.assertEquals(40, students.getCount());
    }

    @Test
    public void testRemoveAll() {

        instructors.removeAll();

        Assert.assertEquals(0, instructors.getCount());
    }
}