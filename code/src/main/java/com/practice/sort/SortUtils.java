package com.practice.sort;

/**
 * @author: wang wei chao
 * @description: TODO
 * @date: 2020/3/22 9:20 下午
 * @version: 1.0.0
 */
public class SortUtils {

    /**
     * 打印 一行
     *
     * @param nums
     */
    public static void print(int[] nums) {
        for (int v : nums) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    /**
     * 交换
     *
     * @param nums
     * @param from
     * @param to
     */
    public static void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}
