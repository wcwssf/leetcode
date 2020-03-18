package com.practice.leetcode;

import com.practice.leetcode.LeetCode_21_MergeSortedList.ListNode;

/**
 * @author: wang wei chao
 * @description: TODO
 * @date: 2020/3/18 11:43 下午
 * @version: 1.0.0
 */
public class LeetCode_206_ReverseLinkedList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        ListNode next = node.next;
        next.next = new ListNode(3);
        ListNode reverseList = reverseListTwo(node);
        System.out.println(reverseList);
    }

    /**
     * pre、next指针
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 递归 重点: head.next.next = head ;而不是next.next = head.
     *
     * @param head
     * @return
     */
    public static ListNode reverseListTwo(ListNode head) {
        if (head == null || head.next == null) {
            // 最后一个元素
            return head;
        }
        ListNode next = reverseListTwo(head.next);
        // 返回的时候，head.next = next.即next.next = head(翻转).使用head.next.next不破坏新的指向
        head.next.next = head;
        // 老的指向置位空
        head.next = null;
        // 始终返回最后一个元素
        return next;
    }
}
