package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2.
 * Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 * <p>
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2.
 * If it does not exist, output -1 for this number.
 * <p>
 * Note:
 * All elements in nums1 and nums2 are unique.
 * The length of both nums1 and nums2 would not exceed 1000.
 * <p>
 * Created by wangxiantao on 2017/8/14.
 */

public class NextGreaterElement {
    /**
     * Example 1
     *
     * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
     * Output: [-1,3,-1]
     * Explanation:
     * For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
     * For number 1 in the first array, the next greater number for it in the second array is 3.
     * For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
     */

    /**
     * Example 2
     * <p>
     * Input: nums1 = [2,4], nums2 = [1,2,3,4].
     * Output: [3,-1]
     * Explanation:
     * For number 2 in the first array, the next greater number for it in the second array is 3.
     * For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
     */

    public static void main(String[] args) {
        int[] findNums = new int[]{2, 4};
        int[] nums = new int[]{1, 2, 3, 4};

        int[] result = nextGreaterElement(findNums, nums);
        System.out.println("The result is:");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static int[] nextGreaterElement(int[] findNums, int[] nums) {
        HashMap<Integer, Integer> findNumMap = new HashMap<>();
        HashMap<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < findNums.length; i++) {
            findNumMap.put(i, findNums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], i);
        }

        for (int i = 0; i < findNums.length; i++) {
            int position = numMap.get(findNums[i]);
            int index = -1;
            for (int j = position; j < nums.length; j++) {
                if (nums[j] > findNums[i]) {
                    index = nums[j];
                    break;
                }
            }
            findNums[i] = index;
        }
        return findNums;
    }
}
