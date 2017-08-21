package com.example;

import com.example.util.TreeNode;

/**
 * Invert a binary tree.
 * <p>
 * Created by wangxiantao on 2017/8/21.
 */

public class InvertBinaryTree {
    
    /**
     * Example
     * origin tree
     * ---4
     * -/   \
     * 2     7
     * / \   / \
     * 1   3 6   9
     * <p>
     * to
     * --4
     * - /   \
     * 7     2
     * / \   / \
     * 9   6 3   1
     */


    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode(4);
        TreeNode<Integer> treeNode01 = new TreeNode(2);
        TreeNode<Integer> treeNode02 = new TreeNode(7);
        TreeNode<Integer> treeNode11 = new TreeNode(1);
        TreeNode<Integer> treeNode12 = new TreeNode(3);
        TreeNode<Integer> treeNode21 = new TreeNode(6);
        TreeNode<Integer> treeNode22 = new TreeNode(9);
        root.left = treeNode01;
        root.right = treeNode02;
        treeNode01.left = treeNode11;
        treeNode01.right = treeNode12;
        treeNode02.left = treeNode21;
        treeNode02.right = treeNode22;

        System.out.println("The origin TreeNode is ");
        TreeNode.printNode(root);

        System.out.println("The invert TreeNode is ");
        TreeNode.printNode(invertTree(root));
    }


    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        if (root.left != null) invertTree(root.left);
        if (root.right != null) invertTree(root.right);
        TreeNode tempTreeNode;
        tempTreeNode = root.left;
        root.left = root.right;
        root.right = tempTreeNode;

        return root;
    }
}
