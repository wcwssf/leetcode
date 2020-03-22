package com.practice.sort;

/**
 * @author: wang wei chao
 * @description: 冒泡排序, 每次找最大或者最新往后放或者往前放
 * @date: 2020/3/22 9:08 下午
 * @version: 1.0.0
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = new int[]{89, 13, 12, 45, 9, 72, 34, 88, 13, 5, 289};
        bubbleSort(nums);
        SortUtils.print(nums);
    }

    /**
     * 冒泡排序, 每次找最大或者最新往后放或者往前放
     *
     * @param nums
     */
    public static void bubbleSort(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            boolean moveFlag = true;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    SortUtils.swap(nums, j, j + 1);
                    moveFlag = false;
                }
            }
            if (moveFlag) {
                break;
            }
        }
    }
}
