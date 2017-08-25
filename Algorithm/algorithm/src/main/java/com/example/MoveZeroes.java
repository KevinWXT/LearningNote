package com.example;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the
 * relative order of the non-zero elements.
 * <p>
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3,
 * 12, 0, 0].
 * <p>
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * <p>
 * Created by wangxiantao on 2017/8/25.
 */

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};

        System.out.println("the result is :");
        int[] result = moveZeroes2(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ",");
        }
    }

    public static int[] moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) return nums;

        int count = 0;
        for (int i = 0; i < nums.length; ) {
            if (nums[i] == 0) {
                for (int j = i; j < nums.length - count - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                count++;
                if (count + i >= nums.length) break;
                nums[nums.length - count] = 0;
            } else {
                i++;
            }
        }

        return nums;
    }

    private static int[] moveZeroes2(int[] nums) {
        if (nums == null || nums.length < 1) return nums;

        int insertPos = 0;
        for (int num : nums) {
            if (num != 0) nums[insertPos++] = num;
        }
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }

        return nums;
    }
}
