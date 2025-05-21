package com.collection.collections;

import java.util.Arrays;

/*
    variable argument: an array
 */
public class VariableArgument {

    public static void main(String[] args) {

        test();
        test(10);
        test(10, 20, 30);
        test(new int[] {10, 20, 30, 40});
    }

    // 1. max. 1 variable argument in arguments list
    // 2. variable argument must be at the end of the arguments list
    public static void test (int... nums) {
        System.out.println(nums.length);
        System.out.println(Arrays.toString(nums));
        System.out.println("===================================");
    }
}
