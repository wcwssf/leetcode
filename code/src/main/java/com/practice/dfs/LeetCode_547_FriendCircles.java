package com.practice.dfs;

/**
 * @author: wang wei chao
 * @description: 朋友圈
 * @date: 2020/6/16 9:51 下午
 * @version: 1.0.0
 */
public class LeetCode_547_FriendCircles {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}
        };
        int circleNum = findCircleNum(matrix);
        System.out.println(circleNum);
    }

    /**
     * 深度优先搜索
     *
     * @param M
     * @return
     */
    public static int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                // 深度优先遍历
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    /**
     * 深度优先
     *
     * @param matrix
     * @param visited
     * @param i
     */
    private static void dfs(int[][] matrix, int[] visited, int i) {
        for (int j = 0; j < matrix.length; j++) {
            if (matrix[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(matrix, visited, j);
            }
        }
    }
}
