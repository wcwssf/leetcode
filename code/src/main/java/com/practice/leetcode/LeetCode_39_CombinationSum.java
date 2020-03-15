package com.practice.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: wang wei chao
 * @description: 组合总和.结束条件，路径，可选列表
 * @date: 2020/3/15 4:41 下午
 * @version: 1.0.0
 */
public class LeetCode_39_CombinationSum {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 6};
        List<List<Integer>> lists = combinationSum(nums, 7);
        System.out.println(lists);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        dfs(candidates, target, 0, result, path);
        return result;
    }

    /**
     * @param candidates
     * @param target
     * @param start
     * @param result
     * @param path
     */
    private static void dfs(int[] candidates, int target, int start, List<List<Integer>> result, LinkedList<Integer> path) {
        // 结束条件，当前路径不可行
        if (target < 0) {
            return;
        }
        // 结束条件，当前路径是正解，加入结果
        if (target == 0) {
            result.add(new LinkedList<>(path));
            return;
        }
        for (int i = start, len = candidates.length; i < len; i++) {
            int candidate = candidates[i];
            // 结果集从小到大(去重，剪枝)
            if (target < candidates[i]) {
                break;
            }
            path.add(candidate);
            dfs(candidates, target - candidate, i, result, path);
            path.removeLast();
        }
    }
}
