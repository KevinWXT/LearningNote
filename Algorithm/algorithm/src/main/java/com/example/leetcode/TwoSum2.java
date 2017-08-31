package com.example.leetcode;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such
 * that they add up to a specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the
 * target, where index1 must be less than index2. Please note that your returned answers (both
 * index1 and index2) are not zero-based.
 * <p>
 * You may assume that each input would have exactly one solution and you may not use the same
 * element twice.
 * <p>
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * <p>
 * <p>
 * Created by wangxiantao on 2017/8/26.
 */

public class TwoSum2 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 13;
        int[] numResults = twoSum(nums, target);
        System.out.println("the result is " + numResults[0] + " and " + numResults[1]);
    }

    private static int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (numbers[l] + numbers[r] != target) {
            if (numbers[l] + numbers[r] > target) {
                r--;
            } else {
                l++;
            }
        }
        return new int[]{l + 1, r + 1};
    }
}
