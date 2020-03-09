package com.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wang wei chao
 * @description: 两数之和
 * @date: 2020/3/9 9:42 下午
 * @version: 1.0.0
 */
public class LeetCode_1_TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, len = nums.length; i < len; i++) {
            int cur = nums[i];
            int diff = target - cur;
            Integer index = map.get(diff);
            if (index == null) {
                map.put(nums[i], i);
            } else {
                return new int[]{i, index};
            }
        }
        return null;
    }
}
