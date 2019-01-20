package com.zipcodewilmington.generic.group;

import com.zipcodewilmington.generic.identifiables.ActionFigure;
import com.zipcodewilmington.generic.identifiables.Person;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author leon on 06/12/2018.
 * there is meaning to the madness
 * ( ͡☉ ͜ʖ ͡☉)
 */
public class GetIdentityTypeTest {
    private Group<String, Person<String>> personGroup = new Group<>();
    private Group<Long, ActionFigure<Long>> actionFigureGroup = new Group<>();

    @Test
    public void testGetIdentityType() { // ༼∵༽ ༼⍨༽ ༼⍢༽ ༼⍤༽
        Assert.assertEquals(personGroup.getIdentityType(), String.class);
        Assert.assertEquals(actionFigureGroup.getIdentityType(), Long.class);
    }

    @Test
    public void testGetIdentifiableType() { // ヽ༼ ಠ益ಠ ༽ﾉ
        Assert.assertEquals(personGroup.getIdentifiableType(), Person.class);
        Assert.assertEquals(actionFigureGroup.getIdentifiableType(), ActionFigure.class);
    }
}
