package com.practice.backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: wang wei chao
 * @description: N 皇后问题
 * @date: 2020/3/29 9:25 下午
 * @version: 1.0.0
 */
public class LeetCode_51_NQueens {


    public static List<List<String>> solveNQueens(int n) {
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        List<List<String>> res = new LinkedList<>();
        backTracking(0, queens, res);
        return res;
    }

    private static void backTracking(int row, int[] queens, List<List<String>> res) {
        for (int col = 0; col < queens.length; col++) {
            queens[row] = col;
            boolean safe = isSafe(queens, row, col);
            if (safe) {
                backTracking(row + 1, queens, res);
            }
            queens[row] = -1;
        }
    }

    private static boolean isSafe(int[] queens, int row, int col) {
        return false;
    }


    private static void addResult(List<List<String>> res, int[] queens) {

    }

    private static int place(int[] queens, int i, int n) {

        return 0;
    }
}
