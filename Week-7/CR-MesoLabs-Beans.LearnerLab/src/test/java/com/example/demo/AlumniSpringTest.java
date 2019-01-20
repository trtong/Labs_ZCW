package com.example.demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AlumniSpringTest {
    private Instructors instructors;
    private Students previousCohort;

    @Autowired
    Alumni alumni;

    @Autowired
    StudentConfig studentConfig;

    @Autowired
    InstructorsConfig instructorsConfig;

    @Before
    public void setUp() {
        instructors = instructorsConfig.instructors();
        previousCohort = studentConfig.previousStudents();
    }

    @Test
    public void testSamePreviousCohort() {
        Assert.assertEquals(alumni.getPreviousStudents(), previousCohort);
    }

    @Test
    public void testSameInstructors() {
        Assert.assertEquals(alumni.getInstructors(), instructors);
    }
}