package com.practice.array;

/**
 * @author: wang wei chao
 * @description: 二维矩阵搜索
 * @date: 2020/6/15 9:52 下午
 * @version: 1.0.0
 */
public class LeetCode_240_Search2dMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 25;
        boolean find = searchMatrix(matrix, target);
        System.out.println(find);
    }

    /**
     * 二分查找
     * 从右上开始搜索。
     * 也可以从左下开始搜索
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length - 1;
        int startCol = matrix[0].length - 1;
        int startRow = 0;
        while (startCol >= 0 && startRow <= row) {
            int comp = matrix[startRow][startCol];
            if (comp == target) {
                return true;
            }
            if (target < comp) {
                startCol--;
            } else {
                startRow++;
            }
        }
        return false;
    }

    /**
     * 一维的二维搜索
     *
     * @param array
     * @param target
     * @return
     */
    private static boolean search1dMatrix(int[] array, int target, int low, int high) {
        if (low > high) {
            return false;
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == target) {
                return true;
            } else if (array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
