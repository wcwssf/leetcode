package com.practice.leetcode;

/**
 * @author: wang wei chao
 * @description: 设计双端队列
 * @date: 2020/3/10 12:39 下午
 * @version: 1.0.0
 */
public class LeetCode_641_DesignDequeue {

    public static void main(String[] args) {
        // set the size to be 3
        MyCircularDeque circularDeque = new MyCircularDeque(3);
        // return true
        boolean flag = circularDeque.insertLast(1);
        System.out.println(flag);
        // return true
        flag = circularDeque.insertLast(2);
        System.out.println(flag);
        // return true
        flag = circularDeque.insertFront(3);
        System.out.println(flag);
        // return false, the queue is full
        flag = circularDeque.insertFront(4);
        System.out.println(flag);
        // return 2
        int rear = circularDeque.getRear();
        System.out.println(rear);
        // return true
        boolean full = circularDeque.isFull();
        System.out.println(full);
        // return true
        boolean last = circularDeque.deleteLast();
        System.out.println(last);
        // return true
        flag = circularDeque.insertFront(4);
        System.out.println(flag);
        // return 4
        int front = circularDeque.getFront();
        System.out.println(front);
    }

    static class MyCircularDeque {

        int[] array;
        int capacity;
        int head = 0;
        int count = 0;
        int tail = 0;

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque(int k) {
            array = new int[k];
            capacity = k;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            array[head] = value;
            head = (head - 1 + capacity) % capacity;
            count++;
            return true;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            tail = (tail + 1) % capacity;
            array[tail] = value;
            count++;
            return true;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            head = (head + 1 + capacity) % capacity;
            count--;
            return true;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            tail = (tail - 1 + capacity) % capacity;
            count--;
            return true;
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            int index = (head + 1) % capacity;
            return array[index];
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            return array[tail];
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return count == 0;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            return capacity == count;
        }
    }
}
