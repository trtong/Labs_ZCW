package com.zipcodewilmington.arrayutility;

import org.junit.Assert;

public class Tester {

    public static void main(String[] args) {
        int expected = 4;
        int actual = maxBlock("ooooYY");

        System.out.println(actual);

    }

    public boolean twoTwo(int[] nums) {
        boolean isTwo = true;
        if (nums.length == 0) {
            return isTwo;
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 2) {
                if ((nums[i-1] != 2) || (nums[i+1] != 2)) {
                    isTwo = false;
                }
            }
        }
        return isTwo;
    }


}
