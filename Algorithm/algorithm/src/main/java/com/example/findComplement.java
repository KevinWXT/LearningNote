package com.example;

/**
 * Given a positive integer, output its complement number.
 * The complement strategy is to flip the bits of its binary representation.
 * <p>
 * Note:
 * The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 * You could assume no leading zero bit in the integer’s binary representation.
 * <p>
 * Created by wangxiantao on 2017/8/11.
 */

public class findComplement {
    /**
     * Example 01
     *
     * Input: 5
     * Output: 2
     * Explanation: The binary representation of 5 is 101 (no leading zero bits),
     *              and its complement is 010. So you need to output 2.
     */


    /**
     * Example 02
     * <p>
     * Input: 1
     * Output: 0
     * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement
     * is 0. So you need to output 0.
     */


    public static void main(String[] args) {
        int num = 5;
        int complement = findComplement(num);

        System.out.println("The num is " + num + "\nThe complement is " + complement);
    }


    /**
     * for example:
     * 100110, its complement is 011001, the sum is 111111.
     * So we only need get the min number large or equal to num, then do substraction
     *
     * @param num
     * @return
     */
    private static int findComplement(int num) {
        int i = 0;
        int j = 0;

        while (i < num) {
            i += Math.pow(2, j);//Math.pow(a,b)表示a的b次方
            j++;
        }

        return i - num;
    }

}
