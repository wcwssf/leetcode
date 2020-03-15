package com.practice.leetcode;

import com.practice.leetcode.LeetCode_21_MergeSortedList.ListNode;

/**
 * @author: wang wei chao
 * @description: TODO
 * @date: 2020/3/15 11:31 上午
 * @version: 1.0.0
 */
public class LeetCode_61_RoateList {

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        ListNode head = node;
        int i = 0;
        while (i < 2) {
            node.next = new ListNode((i + 1));
            node = node.next;
            i++;
        }
        ListNode res = rotateRight(head.next, 4);
        LeetCode_21_MergeSortedList.print(res);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int len = 0;
        ListNode node = head;
        ListNode start = null;
        // fin len
        while (head != null) {
            head = head.next;
            len++;
        }
        if (k % len == 0) {
            return node;
        }
        k = len - (k % len);
        len = 1;
        head = node;
        while (head != null) {
            if (len == k) {
                start = head.next;
                head.next = null;
                break;
            }
            head = head.next;
            len++;
        }
        head = start;
        while (head.next != null) {
            head = head.next;
        }
        head.next = node;
        return start;
    }
}
