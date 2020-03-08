package com.practice.leetcode;

/**
 * @author: wang wei chao
 * @description: 合并两个有序数组
 * @date: 2020/3/8 1:40 下午
 * @version: 1.0.0
 */
public class LeetCode_88_MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 8, 9, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        merge(nums1, 5, nums2, 3);
        for (int a : nums1) {
            System.out.print(a + " ");
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int indexInFirstArr = 0;
        int len = 0;
        int total = m + n;
        int indexInSecondArr = 0;
        while (indexInSecondArr < n) {
            if (indexInFirstArr >= total) {
                if (indexInSecondArr <= n) {
                    System.arraycopy(nums2, indexInSecondArr, nums1, total - (n - indexInSecondArr), n - indexInSecondArr);
                }
                break;
            }
            while (indexInFirstArr < total && nums1[indexInFirstArr] <= nums2[indexInSecondArr]) {
                indexInFirstArr++;
            }
            while (indexInFirstArr < total && indexInSecondArr < n && nums2[indexInSecondArr] <= nums1[indexInFirstArr]) {
                indexInSecondArr++;
                len++;
            }
            if (len == 0) {
                continue;
            }
            System.arraycopy(nums1, indexInFirstArr, nums1, indexInFirstArr + len, (total - indexInFirstArr - len));
            System.arraycopy(nums2, indexInSecondArr - len, nums1, indexInFirstArr, len);
            indexInFirstArr = indexInFirstArr + len;
            len = 0;
        }
    }
}
