package com.example.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given a List of words,
 * return the words that can be typed using letters of alphabet on only one row's of American
 * keyboard like the image below.
 * <p>
 * Note:
 * You may use one character in the keyboard more than once.
 * You may assume the input string will only contain letters of alphabet.
 * <p>
 * origin url:https://leetcode.com/problems/keyboard-row/description/
 * <p>
 * Created by wangxiantao on 2017/8/12.
 */

public class KeyBoardRow {
    /**
     * Example
     * <p>
     * Input: ["Hello", "Alaska", "Dad", "Peace"]
     * Output: ["Alaska", "Dad"]
     */

    public static void main(String[] args) {
        String[] strs = new String[]{"iloveu","dat","dad","top","hello"};
        String[] res = findWords(strs);

        System.out.print("the input strings is :");
        for(String s:strs){
            System.out.print(s+",");
        }

        System.out.print("the OutPut strings is :");
        for(String s:res){
            System.out.print(s+",");
        }
    }


    public static String[] findWords(String[] words) {
        String[] strs = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<strs.length; i++){
            for(char c: strs[i].toCharArray()){
                map.put(c, i);
            }
        }
        List<String> res = new LinkedList<>();
        for(String w: words){
            if(w.equals("")) continue;
            int index = map.get(w.toUpperCase().charAt(0));
            for(char c: w.toUpperCase().toCharArray()){
                if(map.get(c)!=index){
                    index = -1;
                    break;
                }
            }
            if(index!=-1) res.add(w);
        }
        return res.toArray(new String[0]);
    }

}
