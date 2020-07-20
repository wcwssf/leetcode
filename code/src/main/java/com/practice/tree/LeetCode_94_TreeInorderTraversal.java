package com.practice.tree;

import com.practice.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author: wang wei chao
 * @description: 中序遍历
 * @date: 2020/7/20 10:42 下午
 * @version: 1.0.0
 */
public class LeetCode_94_TreeInorderTraversal {

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
        List<Integer> integers = inorderTraversalThreadTree(root);
        System.out.println(integers);
    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversalRecursion(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        recursionHelper(root, list);
        return list;
    }

    private static void recursionHelper(TreeNode node, List<Integer> result) {
        if (node.left != null) {
            recursionHelper(node.left, result);
        }
        result.add(node.val);
        if (node.right != null) {
            recursionHelper(node.right, result);
        }
    }

    /**
     * 栈.当前节点先进栈，循环找左节点直到为空，则输出当前节点。出栈，输出数值，当前节点为出栈节点的有节点
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversalStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
        }
        return result;
    }

    /**
     * 线索二叉树
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversalThreadTree(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                result.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode t = cur.left;
                while (t.right != null) {
                    t = t.right;
                }
                t.right = cur;
                TreeNode tmp = cur;
                cur = cur.left;
                tmp.left = null;
            }
        }
        return result;
    }
}
