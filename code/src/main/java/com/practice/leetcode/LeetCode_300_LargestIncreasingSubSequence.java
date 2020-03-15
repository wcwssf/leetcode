package com.practice.leetcode;

import java.util.Arrays;

/**
 * @author: wang wei chao
 * @description: 最长上升子序列
 * @date: 2020/3/15 8:39 下午
 * @version: 1.0.0
 */
public class LeetCode_300_LargestIncreasingSubSequence {

    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
    }

    /**
     * 二分查找解法
     *
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        int[] dp = new int[nums.length + 1];
        for (int val : nums) {
            // 查找所在下标
            // 没查到，会返回距离最近的high index 的负值:-( low +1) = - high;
            int index = Arrays.binarySearch(dp, 0, max, val);
            if (index < 0) {
                // -（- high index +1 ）= high index -1.
                index = -(index + 1);
            }
            // 替换
            dp[index] = val;
            // index == max(递增数组有效值的长度),当前值在dp中最大有效index = max，则说明，
            // 上一步动作是插入，非替换，数组长度增加了1,max ++(标志dp数组有效长度);
            if (index == max) {
                max++;
            }
        }
        return max;
    }

    /**
     * 真正的动态规划
     * dp[i] = max[dp[i],dp[i - n]+1],n = {0, i -1}
     *
     * @param nums
     * @return
     */
    public static int lengthOfLISTwo(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 存储源数组相应位置前最大的上升序列长度
        int[] dp = new int[nums.length];
        int max = 0;
        for (int index = 0, len = nums.length; index < len; index++) {
            // 初始化
            dp[index] = 1;
            for (int dpIndex = 0; dpIndex < index; dpIndex++) {
                if (nums[dpIndex] < nums[index]) {
                    // 重新赋值
                    dp[index] = Math.max(dp[index], dp[dpIndex] + 1);
                    max = Math.max(max, dp[index]);
                }
            }
        }
        return max;
    }
}
