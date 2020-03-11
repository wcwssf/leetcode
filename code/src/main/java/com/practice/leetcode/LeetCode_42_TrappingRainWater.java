package com.practice.leetcode;

import java.util.Stack;

/**
 * @author: wang wei chao
 * @description: 接雨水
 * @date: 2020/3/11 4:12 下午
 * @version: 1.0.0
 */
public class LeetCode_42_TrappingRainWater {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trap = trapTwo(nums);
        System.out.println(trap);
    }

    public static int trap(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int water = 0;
        int index = 0;
        while (index < height.length) {
            if (stack.isEmpty() || height[index] <= height[stack.peek()]) {
                stack.push(index++);
            } else {
                int popIndex = stack.pop();
                if (!stack.isEmpty()) {
                    int min = Math.min(height[index], height[stack.peek()]);
                    // 计算面积
                    water = water + (min - height[popIndex]) * (index - stack.peek() - 1);
                }
            }
        }
        return water;
    }

    public static int trapTwo(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int left = 0, right = height.length - 1;
        int maxLeft = 0, maxRight = 0;
        int water = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > maxLeft) {
                    maxLeft = height[left];
                } else {
                    // 计算和最高点的差距，直接作为盛水多少，由于有height[right]保证两边可以接住水
                    water += maxLeft - height[left];
                }
                left++;
            } else {
                if (height[right] > maxRight) {
                    maxRight = height[right];
                } else {
                    water += maxRight - height[right];
                }
                right--;
            }
        }
        return water;
    }
}
