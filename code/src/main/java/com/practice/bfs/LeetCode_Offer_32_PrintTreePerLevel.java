package com.practice.bfs;

import com.practice.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: wang wei chao
 * @description: 剑指offer 32题,从上到下之子打印树
 * @date: 2020/6/27 10:38 下午
 * @version: 1.0.0
 */
public class LeetCode_Offer_32_PrintTreePerLevel {

    public static void main(String[] args) {

    }

    /**
     * 分层打印
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> dp = new LinkedList<>();
        dp.offer(root);

        while (!dp.isEmpty()) {
            List<Integer> levelRes = new LinkedList<>();
            for (int i = dp.size(); i > 0; i--) {
                TreeNode poll = dp.poll();
                if (res.size() % 2 == 0) {
                    levelRes.add(poll.val);
                } else {
                    levelRes.add(0, poll.val);
                }
                if (poll.left != null) {
                    dp.add(poll.left);
                }
                if (poll.right != null) {
                    dp.add(poll.right);
                }
            }
            res.add(levelRes);
        }
        return res;
    }
}
