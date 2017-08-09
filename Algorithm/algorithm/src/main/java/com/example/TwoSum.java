package com.example;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a
 * specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same
 * element twice.
 * <p>
 * <p>
 * Created by wangxiantao on 2017/8/8.
 */

public class TwoSum {

    /**
     * Example
     * <p>
     * Given nums = [2, 7, 11, 15], target = 9,
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     */


    public static void main(String args[]) {
        int[] nums = new int[]{2, 7, 11, 15,3,5,222,36};
        int target = 16;
        int[] numResults = twoSum(nums, target);
        System.out.println("first method----the result is " + numResults[0] + " and " + numResults[1]);

        int[] numResults2 = twoSum2(nums, target);
        System.out.println("second method----the result is " + numResults2[0] + " and " + numResults2[1]);
    }

    /**
     * Method 1:Brute Force
     * Time complexity : O(n^2)
     * Space complexity: O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[j] + nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    /**
     * Method 2:Two-pass Hash Table
     * Time complexity : O(n)
     * Space complexity : O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
