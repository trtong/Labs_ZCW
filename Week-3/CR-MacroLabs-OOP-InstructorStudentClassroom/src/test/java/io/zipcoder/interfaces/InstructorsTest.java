package io.zipcoder.interfaces;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class InstructorsTest {

        @Test
        public void testSingletonInstance() {

            Instructors instance1 = Instructors.getInstance();
            Instructors instance2 = Instructors.getInstance();

            Assert.assertSame(instance1, instance2);
        }

        @Test
        public void testInitializationSetupInstructors() {

            Instructors instructors = Instructors.getInstance();

            Assert.assertSame(7, instructors.getArray().length);
        }

}