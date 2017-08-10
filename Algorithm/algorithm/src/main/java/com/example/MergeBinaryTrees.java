package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given two binary trees and imagine that when you put one of them to cover the other,
 * some nodes of the two trees are overlapped while the others are not.
 * <p>
 * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap,
 * then sum node values up as the new value of the merged node.
 * Otherwise, the NOT null node will be used as the node of new tree.
 * <p>
 * Note: The merging process must start from the root nodes of both trees.
 * <p>
 * Created by wangxiantao on 2017/8/10.
 */

public class MergeBinaryTrees {
    /**
     * Example
     * Input:
     * Tree 1                     Tree 2
     * ---1                      ----2
     * --/ \                     -- / \
     * -3   2                    - 1   3
     * -/                        -- \   \
     * -5                        -   4   7
     * Output:
     * Merged tree:
     * --- 3
     * -- / \
     * - 4   5
     * -/ \   \
     * -5   4   7
     **/


    public static void main(String args[]) {
        //第一个treeNode
        TreeNode t1 = new TreeNode(1);
        t1.right = new TreeNode(2);
        TreeNode treeNode01 = new TreeNode(3);
        treeNode01.left = new TreeNode(5);
        t1.left = treeNode01;

        //第二个treeNode
        TreeNode t2 = new TreeNode(2);
        TreeNode treeNode02 = new TreeNode(3);
        treeNode02.left = new TreeNode(7);
        t2.right = treeNode02;
        TreeNode treeNode03 = new TreeNode(1);
        treeNode03.right = new TreeNode(4);
        t2.left = treeNode03;

        //打印第一个treeNode
        System.out.println("the fist TreeNode is: \n");
        BTreePrinter.printNode(t1);
        //打印第二个treeNode
        System.out.println("the second TreeNode is: \n");
        BTreePrinter.printNode(t2);
        //打印合并后的treeNode
        System.out.println("the merge TreeNode is: \n");
        BTreePrinter.printNode(mergeTrees(t1, t2));
    }


    /**
     * Time complexity : O(n)
     * Space complexity : O(n)
     *
     * @param t1
     * @param t2
     * @return
     */
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;

        int val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
        TreeNode newNode = new TreeNode(val);

        newNode.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        newNode.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);

        return newNode;
    }


    static class TreeNode<T> {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    /**
     * 打印二叉树的方法
     */
    static class BTreePrinter {

        public static <T extends Comparable<?>> void printNode(TreeNode<T> root) {
            int maxLevel = BTreePrinter.maxLevel(root);

            printNodeInternal(Collections.singletonList(root), 1, maxLevel);
        }

        private static <T extends Comparable<?>> void printNodeInternal(List<TreeNode<T>> nodes,
                                                                        int level, int maxLevel) {
            if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
                return;

            int floor = maxLevel - level;
            int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
            int firstSpaces = (int) Math.pow(2, (floor)) - 1;
            int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

            BTreePrinter.printWhitespaces(firstSpaces);

            List<TreeNode<T>> newNodes = new ArrayList<TreeNode<T>>();
            for (TreeNode<T> node : nodes) {
                if (node != null) {
                    System.out.print(node.val);
                    newNodes.add(node.left);
                    newNodes.add(node.right);
                } else {
                    newNodes.add(null);
                    newNodes.add(null);
                    System.out.print(" ");
                }

                BTreePrinter.printWhitespaces(betweenSpaces);
            }
            System.out.println("");

            for (int i = 1; i <= endgeLines; i++) {
                for (int j = 0; j < nodes.size(); j++) {
                    BTreePrinter.printWhitespaces(firstSpaces - i);
                    if (nodes.get(j) == null) {
                        BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                        continue;
                    }

                    if (nodes.get(j).left != null)
                        System.out.print("/");
                    else
                        BTreePrinter.printWhitespaces(1);

                    BTreePrinter.printWhitespaces(i + i - 1);

                    if (nodes.get(j).right != null)
                        System.out.print("\\");
                    else
                        BTreePrinter.printWhitespaces(1);

                    BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
                }

                System.out.println("");
            }

            printNodeInternal(newNodes, level + 1, maxLevel);
        }

        private static void printWhitespaces(int count) {
            for (int i = 0; i < count; i++)
                System.out.print(" ");
        }

        private static <T extends Comparable<?>> int maxLevel(TreeNode<T> node) {
            if (node == null)
                return 0;

            return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right))
                    + 1;
        }

        private static <T> boolean isAllElementsNull(List<T> list) {
            for (Object object : list) {
                if (object != null)
                    return false;
            }

            return true;
        }

    }
}
