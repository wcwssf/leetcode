package com.practice.leetcode;

/**
 * @author: wang wei chao
 * @description: TODO
 * @date: 2020/3/18 10:28 下午
 * @version: 1.0.0
 */
public class LeetCode_836_RectangleOverlap {

    public static void main(String[] args) {

    }

    /**
     * 检查位置：
     * 如果相交则在横坐标上
     * r1最大值 > r2最小值 即rec1[2] > rec1[0[;
     * r1最小值 < r2最大值 即rec1[0] < rec2[2]
     * <p>
     * 在纵坐标上
     * r1最大值 > r2最小值 即 rec1[3] > rec2[1]
     * r1最小值 < r2最大值 即 rec1[1] < rec2[3]
     *
     * @param rec1
     * @param rec2
     * @return
     */
    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return rec1[2] > rec2[0] && rec1[0] < rec2[2] && rec1[3] > rec2[1] && rec1[1] < rec2[3];
    }
}
