package com.example.leetcode;

import java.util.List;

/**
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * <p>
 * <p>
 * Created by wangxiantao on 2017/8/22.
 */

public class SumofTwoIntegers {
    /**
     * Example:
     * Given a = 1 and b = 2, return 3.
     */

    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        System.out.println("The num a is " + a + ",the num b is " + b + "\nThe sum is " + getSum(a, b));
    }

    /**
     * First, we can use "and"("&") operation between a and b to find a carry.
     * <p>
     * carry = a & b, then carry = 0001
     * <p>
     * Second, we can use "xor" ("^") operation between a and b to find the different bit, and assign it to a,
     * <p>
     * Then, we shift carry one position left and assign it to b, b = 0010.
     * <p>
     * Iterate until there is no carry (or b == 0)
     */
    public static int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }

        return a;
    }
}
