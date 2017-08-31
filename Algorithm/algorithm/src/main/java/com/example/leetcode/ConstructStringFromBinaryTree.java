package com.example.leetcode;

import com.example.util.TreeNode;

/**
 * You need to construct a string consists of parenthesis and integers from a binary tree with
 * the preorder traversing way.
 * <p>
 * The null node needs to be represented by empty parenthesis pair "()". And you need to omit all
 * the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the
 * string and the original binary tree.
 * <p>
 * Created by wangxiantao on 2017/8/24.
 */

public class ConstructStringFromBinaryTree {
    /**
     * Example 1:
     Input: Binary tree: [1,2,3,4]
     1
     /   \
     2     3
     /
     4

     Output: "1(2(4))(3)"

     Explanation: Originallay it needs to be "1(2(4)())(3()())",
     but you need to omit all the unnecessary empty parenthesis pairs.
     And it will be "1(2(4))(3)".
     */

    /**
     * Example 2:
     * Input: Binary tree: [1,2,3,null,4]
     * 1
     * /   \
     * 2     3
     * \
     * 4
     * <p>
     * Output: "1(2()(4))(3)"
     * <p>
     * Explanation: Almost the same as the first example,
     * except we can't omit the first parenthesis pair to break the one-to-one mapping
     * relationship between the input and the output.
     */

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        TreeNode treeNode02 = new TreeNode(3);
        treeNode02.left = new TreeNode(7);
        treeNode.right = treeNode02;
        TreeNode treeNode03 = new TreeNode(1);
        treeNode03.right = new TreeNode(4);
        treeNode.left = treeNode03;

        TreeNode.printNode(treeNode);

        System.out.println("The solution is "+tree2str(treeNode));
    }

    public static String tree2str(TreeNode t) {
        if (t == null) return "";

        String result = t.val + "";

        String left = tree2str(t.left);
        String right = tree2str(t.right);

        if (left.equals("") && right.equals("")) return result;
        if (left.equals("")) return result + "()" + "(" + right + ")";
        if (right.equals("")) return result + "(" + left + ")";

        return result+"("+left+")"+"("+right+")";
    }
}
