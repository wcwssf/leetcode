package com.practice.bfs;


import com.practice.common.TreeNode;
import org.openjdk.jol.info.ClassLayout;

import java.util.Stack;

/**
 * @author: wang wei chao
 * @description: 对称树. BFS解法
 * @date: 2020/3/29 4:58 下午
 * @version: 1.0.0
 */
public class LeetCode_101_SymmetricTree {

    public static void main(String[] args) {
        LeetCode_101_SymmetricTree symmetricTree = new LeetCode_101_SymmetricTree();
        System.out.println(ClassLayout.parseInstance(symmetricTree).toPrintable());
        synchronized (symmetricTree){
            System.out.println(ClassLayout.parseInstance(symmetricTree).toPrintable());
        }
        TreeNode root = new TreeNode(1);
        TreeNode node = root;
        node.left = new TreeNode(2);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right.left = new TreeNode(4);
        node.right.right = new TreeNode(3);
        boolean symmetric = isSymmetric(root);
        System.out.println(symmetric);
    }

    /**
     * 广度优先遍历.(迭代)
     *
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.isEmpty()) {
            TreeNode left = stack.pop();
            TreeNode right = stack.pop();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }
        return true;
    }
}
