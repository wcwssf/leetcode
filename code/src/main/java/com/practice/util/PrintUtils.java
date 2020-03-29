package com.practice.util;

import com.practice.common.ListNode;
import com.practice.common.TreeNode;

import java.util.Stack;

/**
 * @author: wang wei chao
 * @description: TODO
 * @date: 2020/3/29 5:48 下午
 * @version: 1.0.0
 */
public class PrintUtils {

    /**
     * 打印链表
     *
     * @param node
     */
    public static void printLinkedNode(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
        }
    }

    public static void printTreeNode(TreeNode node) {
        if (node == null) {
            System.out.println();
            return;
        }
        System.out.print(node.val + " ");
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node.left);
        stack.push(node.right);
        while (!stack.isEmpty()) {
            TreeNode left = stack.pop();
            TreeNode right = stack.pop();
            if (left != null) {
                System.out.print(left.val + " ");
                stack.push(left.left);
                stack.push(left.right);
            } else {
                System.out.print("# ");
            }
            if (right != null) {
                System.out.print(right.val + " ");
                stack.push(right.left);
                stack.push(right.right);
            } else {
                System.out.println("# ");
            }

        }
    }
}
