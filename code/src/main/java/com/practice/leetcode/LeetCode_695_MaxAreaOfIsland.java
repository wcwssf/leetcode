package com.practice.leetcode;

/**
 * @author: wang wei chao
 * @description: 求最大岛屿面积
 * @date: 2020/3/15 6:40 下午
 * @version: 1.0.0
 */
public class LeetCode_695_MaxAreaOfIsland {

    public static void main(String[] args) {
        int[][] region = new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}
        };
        int area = maxAreaOfIsland(region);
        System.out.println(area);
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0, rl = grid.length; i < rl; i++) {
            for (int j = 0, cl = grid[i].length; j < cl; j++) {
                max = Math.max(getArea(grid, i, j), max);
            }
        }
        return max;
    }

    /**
     * 获取面积
     * 当前岛屿面积 + 上、下、左、右 四个方向深度遍历的面积.
     *
     * @param grid
     * @param row
     * @param col
     * @return
     */
    private static int getArea(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length || grid[row][col] == 0) {
            return 0;
        }
        // 标志已经访问过(同水)
        grid[row][col] = 0;
        // 深度遍历过程
        return 1 + getArea(grid, row - 1, col)
                + getArea(grid, row + 1, col)
                + getArea(grid, row, col + 1)
                + getArea(grid, row, col - 1);
    }
}
