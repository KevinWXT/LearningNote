package com.example;

/**
 * The Hamming distance between two integers is the number of positions at which the
 * corresponding bits are different.
 * Given two integers x and y, calculate the Hamming distance.
 * Note: 0 ≤ x, y < 2^31.
 * <p>
 * Created by wangxiantao on 2017/8/9.
 */

public class HammingDistance {

    public static void main(String args[]) {
        int x = 1;
        int y = 4;

        int result = hammingDistance(x, y);
        System.out.println("first method----x is:" + x + " ,y is: " + y
                + "  ; the hammingDistance is " + result);


        result = hammingDistance2(x, y);
        System.out.println("second method----x is:" + x + " ,y is: " + y
                + "  ; the hammingDistance is " + result);
    }


    private static int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    private static int hammingDistance2(int x, int y) {
        int xor = x ^ y, count = 0;
        for (int i = 0; i < 32; i++) {
            count += (xor >> i) & 1;
        }
        return count;
    }
}
