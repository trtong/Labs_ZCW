package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class WordCountTest {

    WordCount wc;
    HashMap<String, Integer> allWords;
    HashMap<String, Integer> sorted;
    Path path;


    public WordCountTest() {
        wc = new WordCount();
        String fileName = "romeoAndJuliet.txt";
        path = wc.printPath(fileName);
    }

    @Test
    public void test() throws IOException {

        int expected = 3796;
        allWords = wc.countWordsHashMap(path);
        sorted = wc.sortedHashMap(allWords);

        int actual = sorted.get("the");


        Assert.assertEquals(expected, actual);

        System.out.println(sorted);

    }




}