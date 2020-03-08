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
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while (l1 != null) {
            if (l2 == null) {
                cur.next = l1;
                break;
            }
            if (l1.val > l2.val) {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
                cur = cur.next;
            } else {
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


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
