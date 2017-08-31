package com.example.leetcode;

/**
 * Given two strings s and t which consist of only lowercase letters.
 * <p>
 * String t is generated by random shuffling string s and then add one more letter at a random
 * position.
 * <p>
 * Find the letter that was added in t.
 * <p>
 * Created by wangxiantao on 2017/8/23.
 */

public class FindTheDifference {
    /**
     * Example:
     * <p>
     * Input:
     * s = "abcd"
     * t = "abcde"
     * <p>
     * Output:
     * e
     * <p>
     * Explanation:
     * 'e' is the letter that was added.
     */

    public static void main(String[] args) {
        String s = "abcedfg";
        String t = "abcdefgl";


        System.out.println("The String s is:" + s + "\nThe String t is:" + t +
                "\nThe difference between two string is " + findTheDifference(s, t));
    }

    private static char findTheDifference(String s, String t) {
        int charCodeS = 0, charCodeT = 0;
        for (int i = 0; i < s.length(); i++) charCodeS += s.charAt(i);
        for (int i = 0; i < t.length(); i++) charCodeT += t.charAt(i);
        return (char) (charCodeT - charCodeS);
    }
}