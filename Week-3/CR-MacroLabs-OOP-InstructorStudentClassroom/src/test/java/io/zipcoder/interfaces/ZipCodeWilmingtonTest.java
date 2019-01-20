package io.zipcoder.interfaces;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ZipCodeWilmingtonTest {
    @Test
    public void testHostLecture() {

        ZipCodeWilmington zcwTest = ZipCodeWilmington.getInstance();
        Educator nhu = Educator.NHU;

        zcwTest.hostLecture(nhu, 5);

        Assert.assertEquals(0.1282, zcwTest.getStudents().getArray()[0].getTotalStudyTime(), .05);
    }

}
