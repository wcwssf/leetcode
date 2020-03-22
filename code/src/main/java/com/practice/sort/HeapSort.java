package com.practice.sort;

/**
 * @author: wang wei chao
 * @description: 堆排序
 * @date: 2020/3/22 5:37 下午
 * @version: 1.0.0
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] nums = new int[]{89, 239, 12, 45, 9, 323, 88, 13, 5, 289};
        heapSort(nums);
        SortUtils.print(nums);
    }

    /**
     * 堆排序(顺序:大顶堆)
     *
     * @param nums
     */
    public static void heapSort(int[] nums) {
        // 构建堆
        createHeap(nums, nums.length - 1);
        // 排序:调整堆
        int index = nums.length - 1;
        while (index >= 0) {
            swapVal(nums, 0, index);
            index--;
            createHeap(nums, index);
        }
    }

    /**
     * 构建堆
     *
     * @param nums
     * @param lastIndex last index
     */
    private static void createHeap(int[] nums, int lastIndex) {
        if (lastIndex == 0) {
            return;
        }
        // 找到父节点(最后一个非叶子节点)
        int parentIndex = findParent(lastIndex);
        for (int index = parentIndex; index >= 0; index--) {
            adjust(nums, index, lastIndex);
        }
    }

    private static void adjust(int[] nums, int parentIndex, int lastIndex) {
        int left = parentIndex * 2 + 1;
        int right = left + 1;
        int maxIndex = left;
        if (right <= lastIndex && nums[left] < nums[right]) {
            maxIndex = right;
        }
        if (nums[parentIndex] < nums[maxIndex]) {
            swapVal(nums, parentIndex, maxIndex);
        }
    }

    /**
     * 交换(判断过程)
     *
     * @param nums
     * @param parentIndex
     * @param leftChild
     * @param rightChild
     * @param lastIndex
     */
    private static void swap(int[] nums, int parentIndex, int leftChild, int rightChild, int lastIndex) {
        int maxIndex = parentIndex;
        if (leftChild <= lastIndex && nums[parentIndex] < nums[leftChild]) {
            maxIndex = leftChild;
        }
        if (rightChild <= lastIndex && nums[parentIndex] < nums[rightChild]) {
            maxIndex = rightChild;
        }
        if (maxIndex != parentIndex) {
            // 调整
            swapVal(nums, parentIndex, maxIndex);
        }
    }

    /**
     * 交换
     *
     * @param nums
     * @param parentIndex
     * @param maxIndex
     */
    private static void swapVal(int[] nums, int parentIndex, int maxIndex) {
        int temp = nums[parentIndex];
        nums[parentIndex] = nums[maxIndex];
        nums[maxIndex] = temp;
    }


    /**
     * 寻找父节点下标
     *
     * @param index
     * @return
     */
    private static int findParent(int index) {
        return (index - 1) / 2;
    }


}
