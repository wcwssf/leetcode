package com.sam.wang.leetcode;

/**
 * @author: wang wei chao
 * @description: 删除重复有序的数组元素
 * @date: 2020/3/8 11:57 上午
 * @version: 1.0.0
 */
public class LeetCode_26_RemoveDuplicatesSortedArray {

    public static int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 0;
        int len = nums.length;
        while (fast < len) {
            if (nums[slow] == nums[fast]) {
                fast++;
            } else {
                slow++;
                nums[slow] = nums[fast];
                fast++;
            }
        }
        return slow + 1;
    }
}
