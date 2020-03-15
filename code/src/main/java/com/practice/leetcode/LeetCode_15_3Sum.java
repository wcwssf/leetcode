package com.practice.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: wang wei chao
 * @description: 三数之和
 * @date: 2020/3/15 7:18 下午
 * @version: 1.0.0
 */
public class LeetCode_15_3Sum {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4, -1, -1};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }

    /**
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new LinkedList<>();
        }
        Arrays.sort(nums);
        int sum = 0;
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0, len = nums.length; i < len - 2; i++) {
            // 去除可能得重复.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    // 寻找可能得其他解
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right++;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
