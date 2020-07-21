package com.practice.tree;

import com.practice.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: wang wei chao
 * @description: 前序遍历
 * @date: 2020/7/21 10:35 下午
 * @version: 1.0.0
 */
public class LeetCode_144_PreorderTraversal {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode root = node;
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(13);
        node.right = right;
        node.left = left;
        node = left;
        left = new TreeNode(10);
        node.left = left;
        left.right = new TreeNode(8);
        List<Integer> lists = preorderTraversal(root);
        System.out.println(lists);
    }

    /**
     * 先序遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> stack = new LinkedList();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.poll();
            res.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
    }

    /**
     * 递归先序遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversalRecursion(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        helper(root, result);
        return result;
    }

    /**
     * @param node
     * @param result
     */
    private static void helper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        helper(node.left, result);
        helper(node.right, result);
    }
}
