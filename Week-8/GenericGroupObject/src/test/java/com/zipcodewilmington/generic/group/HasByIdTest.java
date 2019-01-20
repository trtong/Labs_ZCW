package com.zipcodewilmington.generic.group;

import com.zipcodewilmington.generic.identifiables.ActionFigure;
import com.zipcodewilmington.generic.identifiables.IdentifiableInterface;
import com.zipcodewilmington.generic.identifiables.Person;
import org.junit.Assert;
import org.junit.Test;

import java.io.Serializable;
import java.util.Random;
import java.util.function.Supplier;

/**
 * @author leon on 05/12/2018.
 */
public class HasByIdTest {
    @Test
    public void test1() {
        test(1);
    }

    @Test
    public void test2() {
        test(2);
    }

    @Test
    public void testRandom() {
        test(1000);
    }

    private void test(Integer numberOfObjectsToAdd) {
        test(numberOfObjectsToAdd, Person::new);
        test(numberOfObjectsToAdd, ActionFigure::new);
    }

    private <TypeOfId extends Serializable> void test(Integer numberOfObjectsToAdd, Supplier<IdentifiableInterface<TypeOfId>> supplier) {
        // Given
        Group<TypeOfId, IdentifiableInterface<TypeOfId>> group = new Group<>();

        // when
        for (int i = 0; i < numberOfObjectsToAdd; i++) {
            IdentifiableInterface<TypeOfId> identifiable = supplier.get();
            group.insert(identifiable);
            // then
            Assert.assertTrue(group.has(identifiable.getIdentity()));
        }
    }
}
