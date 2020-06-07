package com.practice.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author: wang wei chao
 * @description: 选择数据流中的中位数
 * @date: 2020/6/7 7:10 下午
 * @version: 1.0.0
 */
public class LeetCode_295_FindMidFromDataStream {

    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
        finder.addNum1(1293);
        finder.addNum1(234);
        double median2 = finder.findMedian1();
        System.out.println(median2);
        finder.addNum1(930);
        System.out.println(finder.findMedian1());
        finder.addNum1(123);
        System.out.println(finder.findMedian1());
        finder.addNum1(124);
        System.out.println(finder.findMedian1());
    }

    static class MedianFinder {

        // 每次求中时sort
        private List<Integer> list = new ArrayList<>();
        // 插入时维护顺序
        private ArrayList<Integer> sortedList = new ArrayList<>();
        // 双堆维护中位数
        private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {

        }

        public void addNum(int num) {
            list.add(num);
        }

        public void addNum1(int num) {
            int size = sortedList.size();
            if (size == 0) {
                sortedList.add(num);
                return;
            }
            insertIntoSortedList(num);
        }

        /**
         * 寻找正确插入位置.
         *
         * @param num
         */
        private void insertIntoSortedList(int num) {
            int size = sortedList.size();
            int low = 0;
            int high = size - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                Integer m = sortedList.get(mid);
                if (num > m) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            sortedList.add(low, num);
        }

        public void addNum2(int num) {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
        }

        public double findMedian() {
            // 排序
            Collections.sort(list);
            int size = list.size();
            return (size & 1) == 1 ? list.get(size / 2) : (list.get(size / 2) + list.get(size / 2 - 1)) / 2;
        }

        public double findMedian1() {
            int size = sortedList.size();
            return (size & 1) == 1 ? (double) sortedList.get(size / 2) : (double) sortedList.get(size / 2) / 2.0d + (double) sortedList.get(size / 2 - 1) / 2.0d;
        }

        public double findMedian2() {

            return maxHeap.size() > minHeap.size() ? (double) maxHeap.peek() : ((double) (minHeap.peek() + maxHeap.peek())) / 2.0d;
        }
    }
}
