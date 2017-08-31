package com.example.leetcode;

/**
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 * <p>
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 * <p>
 * 1.All letters in this word are capitals, like "USA".
 * 2. All letters in this word are not capitals, like "leetcode".
 * 3.Only the first letter in this word is capital if it has more than one letter, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 * <p>
 * Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 * <p>
 * Created by wangxiantao on 2017/8/20.
 */

public class DetectCapital {
    /**
     * Example 1
     *
     * Input: "USA"
     * Output: True
     */

    /**
     * Input: "FlaG"
     * Output: False
     */

    public static void main(String[] args) {
        String word1= "USA";
        String word2 = "FlaG";

        //Solution 1
        System.out.println("Solution 1,the word1 is "+word1+",the usage is "+detectCapitalUse(word1));
        System.out.println("Solution 1,the word2 is "+word2+",the usage is "+detectCapitalUse(word2));

        //Solution 2
        System.out.println("\nSolution 2,the word1 is "+word1+",the usage is "+detectCapitalUse2(word1));
        System.out.println("Solution 2,the word2 is "+word2+",the usage is "+detectCapitalUse2(word2));
    }


    public static boolean detectCapitalUse(String word) {
        return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
    }

    public static boolean detectCapitalUse2(String word) {
        int index = 0;
        for (int i = 0; i < word.length(); i++)
            if (Character.isUpperCase(word.charAt(i))) index++;
        if (index == 1) return Character.isUpperCase(word.charAt(0));
        return index == 0 || index == word.length();
    }
}
