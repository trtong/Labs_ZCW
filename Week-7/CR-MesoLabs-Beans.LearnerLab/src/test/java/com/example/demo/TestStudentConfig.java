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
public class TestStudentConfig {
    private Students currentStudents, previousStudents;

    @Autowired
    private StudentConfig studentConfig;

    @Before
    public void setup() {
        currentStudents = studentConfig.currentStudents();
        previousStudents = studentConfig.previousStudents();
    }

    @Test
    public void testCurrentStudents() {
        assertEquals(currentStudents, studentConfig.currentStudents());
        assertNotEquals(currentStudents, previousStudents);
    }

    @Test
    public void testPreviousStudents() {
        assertEquals(previousStudents, studentConfig.previousStudents());
        assertNotEquals(previousStudents, currentStudents);
    }
}
