package com.example.leetcode;

/**
 * Given a string, you need to reverse the order of characters in each word within a sentence
 * while still preserving whitespace and initial word order.
 * <p>
 * Note:
 * In the string, each word is separated by single space and there will not be any extra space in
 * the string.
 * <p>
 * Created by wangxiantao on 2017/8/13.
 */

public class ReverseWords {
    /**
     * Example
     * Input: "Let's take LeetCode contest"
     * Output: "s'teL ekat edoCteeL tsetnoc"
     */

    public static void main(String[] args) {
        String inputStr = "Let's take LeetCode contest";

        String outputStr = reverseWords(inputStr);

        System.out.println("The input string is :" + inputStr
                + "\nThe output string is :" + outputStr);
    }


    public static String reverseWords(String s) {
        String[] strings = s.split(" ");//用空格分割字符串

        StringBuffer res = new StringBuffer();

        for (String str : strings) {
            res.append(new StringBuffer(str).reverse().toString() + " "); //StringBuffer(str).reverse()取反放入res中
        }

        return res.toString().trim(); //res取出最后的空格并输出

    }
}
