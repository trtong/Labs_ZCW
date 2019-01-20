package com.zipcodewilmington.singlylinkedlist;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.xml.soap.Node;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {
    SinglyLinkedList<Integer> list;

    public SinglyLinkedListTest() {
        list = new SinglyLinkedList<Integer>();

    }

    @Before
    public void setUp() {
        list.add(10);
        list.add(30);
        list.add(5);
        list.add(20);
    }

    @Test
    public void testAdd() {
        Integer expected = 10;

        Assert.assertEquals(expected, list.get(0));
    }


    @Test
    public void testRemove() {

        list.remove(1);

        Assert.assertEquals((Integer) 5, list.get(1));
    }

    @Test
    public void testGet() {

        Integer expected = 30;

        Assert.assertEquals(expected,list.get(1));
    }

    @Test
    public void testSize() {

        Assert.assertEquals((Integer) 4, list.size());
    }

    @Test
    public void testContains() {
        Assert.assertTrue(list.contains(10));
    }

    @Test
    public void testCopy() {
        boolean match = true;
        SinglyLinkedList<Integer> newList = list.copy();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != newList.get(i)) {
                match = false;
                break;
            }
        }

        Assert.assertTrue(match);
    }

    @Test
    public void testFind() {

        Assert.assertEquals( -1, list.find(100));

    }

    @Test
    public void testSort() {
        list.sort();

        Integer[] expected = {5, 10, 20, 30};
        list.print();
        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(list.get(i), expected[i]);
        }

    }
}
