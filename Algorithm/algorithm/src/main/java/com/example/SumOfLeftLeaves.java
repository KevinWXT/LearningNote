package com.example;

import com.example.util.TreeNode;

/**
 * Find the sum of all left leaves in a given binary tree.
 * <p>
 * Created by wangxiantao on 2017/8/28.
 */

public class SumOfLeftLeaves {
    /**
     * Example:
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * <p>
     * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
     */

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode02 = new TreeNode(3);
        treeNode02.left = new TreeNode(7);
        treeNode02.right = new TreeNode(11);
        treeNode.right = treeNode02;
        TreeNode treeNode03 = new TreeNode(9);
//        treeNode03.left = new TreeNode(9);
//        treeNode03.right = new TreeNode(4);
        treeNode.left = treeNode03;

        System.out.println("the  TreeNode is: \n");
        TreeNode.printNode(treeNode);

        System.out.println("the sumOfLeftLeaves of treeNode is " + sumOfLeftLeaves(treeNode));
    }

    private static int sumOfLeftLeaves(TreeNode treeNode) {
        if (treeNode == null) return 0;
        int sumResult = 0;
        if (treeNode.left != null) {
            if (treeNode.left.left == null && treeNode.left.right == null) {
                sumResult += treeNode.left.val;
            } else {
                sumResult += sumOfLeftLeaves(treeNode.left);
            }
        }

        sumResult +=sumOfLeftLeaves(treeNode.right);
        
        return sumResult;
    }
}
