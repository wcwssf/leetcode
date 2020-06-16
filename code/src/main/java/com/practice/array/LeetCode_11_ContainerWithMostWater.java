package com.practice.array;

/**
 * @author: wang wei chao
 * @description: 盛水最多的容器
 * @date: 2020/6/16 9:09 下午
 * @version: 1.0.0
 */
public class LeetCode_11_ContainerWithMostWater {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int area = maxArea(arr);
        System.out.println(area);
    }

    /**
     * 双指针
     * 移动较短的指针
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = Integer.MIN_VALUE;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(area, maxArea);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
