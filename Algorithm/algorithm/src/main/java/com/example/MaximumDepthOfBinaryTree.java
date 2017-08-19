package com.example;

/**
 * Given a binary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root node down to the
 * farthest leaf node.
 * <p>
 * Created by wangxiantao on 2017/8/19.
 */

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        MergeBinaryTrees.TreeNode treeNode = new MergeBinaryTrees.TreeNode(2);
        MergeBinaryTrees.TreeNode treeNode02 = new MergeBinaryTrees.TreeNode(3);
        treeNode02.left = new MergeBinaryTrees.TreeNode(7);
        treeNode02.right = new MergeBinaryTrees.TreeNode(11);
        treeNode.right = treeNode02;
        MergeBinaryTrees.TreeNode treeNode03 = new MergeBinaryTrees.TreeNode(1);
        treeNode03.left = new MergeBinaryTrees.TreeNode(9);
        treeNode03.right = new MergeBinaryTrees.TreeNode(4);
        treeNode.left = treeNode03;

        System.out.println("the  TreeNode is: \n");
        MergeBinaryTrees.BTreePrinter.printNode(treeNode);

        System.out.println("the maximum depth of treeNode is " + maxDepth(treeNode));
    }

    public static int maxDepth(MergeBinaryTrees.TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
