package com.practice.array;

/**
 * @author: wang wei chao
 * @description: 顺时针选择图像90度
 * @date: 2020/4/13 9:49 下午
 * @version: 1.0.0
 */
public class LeetCode_48_RotateImage {

    public static void main(String[] args) {

    }

    /**
     * 先转置、每行左右交换
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        // 转置
        for (int i = 0, len = matrix.length; i < len; i++) {
            for (int j = i; j < len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 每行左右交换
        for (int i = 0, len = matrix.length; i < len; i++) {
            for (int j = 0; j < len / 2; j++) {
                int temp = matrix[i][len - j - 1];
                matrix[i][len - j - 1] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    /**
     * 顺时针选择可以看成:四个顶点依次交换位置
     *
     * @param matrix
     */
    public void rotateV2(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0, max = (matrix.length + 1) / 2; i < max; i++) {
            for (int j = 0, half = matrix.length / 2; j < half; j++) {
                int temp = matrix[len - 1 - j][i];
                matrix[len - 1 - j][i] = matrix[len - 1 - j][len - 1 - i];
                matrix[len - 1 - j][len - 1 - i] = matrix[j][len - 1 - j];
                matrix[j][len - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}
