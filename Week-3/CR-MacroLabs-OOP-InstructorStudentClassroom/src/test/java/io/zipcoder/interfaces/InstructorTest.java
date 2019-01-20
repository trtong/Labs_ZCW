package io.zipcoder.interfaces;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class InstructorTest{
    Instructor instructor;
    Student student;
    Student student2;
    Student[] students;

    final double delta = 0.5;

    public InstructorTest() {
        instructor = new Instructor(1, "Nhu");
        student = new Student(12, "LuLu");
        student2 = new Student(13,  "Victoria");

        students = new Student[]{student, student2};
    }

    @Test
    public void testImplementation() {

        Assert.assertTrue(instructor instanceof Teacher);
    }

    @Test
    public void testInheritence() {
        Assert.assertTrue(instructor instanceof Person);
    }

    @Test
    public void testTeach() {
        instructor.teach(student, 5);

        Assert.assertEquals(5, student.getTotalStudyTime(), delta );
    }

    @Test
    public void testLecture() {

        instructor.lecture(students, 10);

        Assert.assertEquals(5, student2.getTotalStudyTime(), delta);

    }


}