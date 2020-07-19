package com.practice.array;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author: wang wei chao
 * @description: 合并区间
 * @date: 2020/7/19 9:11 下午
 * @version: 1.0.0
 */
public class LeetCode_56_MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1, 3},
                {2, 6},
                {8, 10},
                {12, 19}
        };
        int[][] merge = merge(intervals);
        for (int[] m : merge) {
            System.out.println("[" + m[0] + "," + m[1] + "]");
        }
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        LinkedList<int[]> res = new LinkedList<>();
        for (int i = 0; i < intervals.length; i++) {
            int l = intervals[i][0];
            int r = intervals[i][1];
            if (res.size() == 0 || l > res.getLast()[1]) {
                res.add(intervals[i]);
            } else {
                res.getLast()[1] = Math.max(res.getLast()[1], r);
            }

        }
        return res.toArray(new int[res.size()][2]);
    }
}
