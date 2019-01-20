package com.zipcodewilmington.generic.identifiables;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author leon on 06/12/2018.
 */
public class ActionFigureTest {
    private ActionFigure actionFigure = new ActionFigure();

    @Before
    public void setUp() throws Exception {
        actionFigure.setId(100L);
    }

    @Test
    public void testImplementation() {
        Assert.assertTrue(actionFigure instanceof IdentifiableInterface);
    }

    @Test
    public void testGetIdentityType() {
        Assert.assertEquals(actionFigure.getIdentityType(), Long.class);
    }
}
