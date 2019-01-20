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
public class TestInstructorConfig {
    private Instructors tcUsaInstructors, tcUkInstructors, instructors;

    @Autowired
    private InstructorsConfig instructorConfig;

    @Before
    public void setup() {
        tcUsaInstructors = instructorConfig.tcUsaInstructors();
        tcUkInstructors = instructorConfig.tcUkInstructors();
        instructors = instructorConfig.instructors();
    }

    @Test
    public void testTcUsaInstructors() {
        assertEquals(tcUsaInstructors, instructorConfig.tcUsaInstructors());
        assertNotEquals(tcUsaInstructors, tcUkInstructors);
        assertNotEquals(tcUsaInstructors, instructors);
    }

    @Test
    public void testTcUkInstructors() {
        assertEquals(tcUkInstructors, instructorConfig.tcUkInstructors());
        assertNotEquals(tcUkInstructors, tcUsaInstructors);
        assertNotEquals(tcUkInstructors, instructors);
    }

    @Test
    public void testInstructors() {
        assertEquals(instructors, instructorConfig.instructors());
        assertNotEquals(instructors, tcUsaInstructors);
        assertNotEquals(instructors, tcUkInstructors);
    }
}