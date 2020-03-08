package com.practice.leetcode;

/**
 * @author: wang wei chao
 * @description: 旋转数组
 * @date: 2020/3/8 12:18 下午
 * @version: 1.0.0
 */
public class LeetCode_189_RotateArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        LeetCode_189_RotateArray instance = new LeetCode_189_RotateArray();
        instance.rotate(nums, 4);
        for (int a : nums) {
            System.out.print(a + " ");
        }
    }

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int secondStart = len - k;
        int firstEnd = secondStart - 1;
        reversArray(nums, 0, firstEnd);
        reversArray(nums, secondStart, len - 1);
        reversArray(nums, 0, len - 1);
    }

    private void reversArray(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
