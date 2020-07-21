package com.practice.tree;

import com.practice.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: wang wei chao
 * @description: 二叉树的层次遍历
 * @date: 2020/7/21 9:38 下午
 * @version: 1.0.0
 */
public class LeetCode_102_LevelOrderTraversal {

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
        List<List<Integer>> lists = levelOrder(root);
        lists.stream().forEach(v -> System.out.println(v));
    }


    /**
     * 层次遍历
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            res.add(new LinkedList<>());
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                res.getLast().add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }
        return res;
    }
}
