package com.example.leetcode;

import java.util.Arrays;

/**
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer,
 * say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 * <p>
 * Note:
 * n is a positive integer, which is in the range of [1, 10000].
 * All the integers in the array will be in the range of [-10000, 10000].
 * <p>
 * Created by wangxiantao on 2017/8/11.
 */

public class ArrayPartition {
    /**
     * Example
     * <p>
     * Input: [1,4,3,2]
     * Output: 4
     * Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
     */


    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 3, 2,4,3,5,6,7,8};
        System.out.println("The array is :");
        for (int n : nums) {
            System.out.print(n + " ,");
        }

        int pairSum = arrayPairSum(nums);
        System.out.println("The maximum sum of pairs  is " + pairSum);
    }


    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i += 2) {
            result += nums[i];
        }
        System.out.println("\n");
        for (int i = 0; i < nums.length; i += 2) {
            System.out.println("the pair " + (i / 2) + " is :(" + nums[i] + " , " + nums[i + 1] + ")");
        }
        return result;
    }
}
