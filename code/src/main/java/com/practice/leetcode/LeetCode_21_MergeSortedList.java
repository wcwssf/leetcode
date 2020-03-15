package com.practice.leetcode;

/**
 * @author: wang wei chao
 * @description: merge two sorted list
 * @date: 2020/3/8 12:54 下午
 * @version: 1.0.0
 */
public class LeetCode_21_MergeSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // 返回的结果指针(第一个元素是非结果元素)
        ListNode res = new ListNode(0);
        // 尾指针
        ListNode cur = res;
        while (l1 != null) {
            // l2为空，则直接把尾指针指向l1
            if (l2 == null) {
                cur.next = l1;
                break;
            }
            // 如果l2小，则取l2值，同时l2向后移动
            if (l1.val > l2.val) {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
                cur = cur.next;
            } else {
                // 如果l1小，则取l1值，同时移动l1指针
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
                cur = cur.next;
            }
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return res.next;
    }


    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
        }
    }
}
