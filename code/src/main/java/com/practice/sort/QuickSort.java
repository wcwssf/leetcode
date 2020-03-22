package com.practice.sort;

/**
 * @author: wang wei chao
 * @description: 快排
 * @date: 2020/3/22 7:07 下午
 * @version: 1.0.0
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{89, 13, 12, 45, 9, 72, 34, 88, 13, 5, 289};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(nums);
    }

    /**
     * 分治法.每次找第一个数作为分治标准,把列表分为比标准大和比标准小的两部分
     *
     * @param nums
     * @param left
     * @param right
     */
    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int cur = nums[left];
        int r = right;
        int l = left + 1;
        while (true) {
            while (l <= r && nums[r] >= cur) r--;
            while (l <= r && nums[l] <= cur) l++;
            if (l >= r) {
                break;
            }
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
        nums[left] = nums[r];
        nums[r] = cur;
        quickSort(nums, left, r - 1);
        quickSort(nums, r + 1, right);
    }
}
