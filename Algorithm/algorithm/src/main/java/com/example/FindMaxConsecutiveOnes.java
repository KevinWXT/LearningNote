package com.example;

import java.util.HashMap;

/**
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 * <p>
 * Note:
 * <p>
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 * <p>
 * Created by wangxiantao on 2017/8/18.
 */

public class FindMaxConsecutiveOnes {
    /**
     * Input: [1,1,0,1,1,1]
     * Output: 3
     * Explanation: The first two digits or the last three digits are consecutive 1s.
     * The maximum number of consecutive 1s is 3.
     */


    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 0, 1, 1, 1};

        int result = findMaxConsecutiveOnes(nums);
        System.out.println("The maximum number of consecutive  is " + result);

    }


    public static int findMaxConsecutiveOnes(int[] nums) {
        if(nums==null||nums.length<=1)return 0;
        int result = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                result = Math.max(count, result);
            }
            else count = 0;
        }

        return result;
    }
}
