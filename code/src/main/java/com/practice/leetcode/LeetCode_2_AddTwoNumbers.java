package com.practice.leetcode;

/**
 * @author: wang wei chao
 * @description: 两数相加
 * @date: 2020/3/8 7:10 下午
 * @version: 1.0.0
 */
public class LeetCode_2_AddTwoNumbers {

    public static void main(String[] args) {
        ListNode node1 = covertNumberToNode(89L);
        ListNode node2 = covertNumberToNode(1L);
        ListNode node = addTwoNumbers(node1, node2);
        System.out.println(node);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        boolean needAdd = false;
        ListNode last = l1;
        ListNode node = l1;
        while (l1 != null && l2 != null) {
            int num = l1.val + l2.val;
            if (needAdd) {
                num += 1;
                needAdd = false;
            }
            if (num > 9) {
                needAdd = true;
                num = num - 10;
            }
            l1.val = num;
            last = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null && l2 == null) {
            if (needAdd) {
                last.next = new ListNode(1);
            }
        } else {
            if (l1 == null) {
                last.next = l2;
            }
            if (needAdd) {
                singleListAddOne(last.next);
            }
        }
        return node;
    }

    private static void singleListAddOne(ListNode listNode) {
        boolean needAdd = true;
        ListNode last = listNode;
        while (needAdd && listNode != null) {
            int num = listNode.val + 1;
            if (num < 10) {
                listNode.val = num;
                needAdd = false;
                break;
            }
            listNode.val = num - 10;
            last = listNode;
            listNode = listNode.next;
        }
        if (needAdd) {
            last.next = new ListNode(1);
        }
    }

    /**
     * 数值转list node
     *
     * @param resNum
     * @return
     */
    private static ListNode covertNumberToNode(Long resNum) {
        if (resNum < 10) {
            return new ListNode(resNum.intValue());
        }
        int min = (int) (resNum % 10);
        ListNode r = new ListNode(min), cur = r;
        while ((resNum / 10) != 0) {
            resNum = resNum / 10;
            min = (int) (resNum % 10);
            cur.next = new ListNode(min);
            cur = cur.next;
        }
        return r;
    }

    /**
     * list node 转数值
     *
     * @param node
     * @return
     */
    private static long getNumberFromList(ListNode node) {
        Long multi = 1L;
        Long res = 0L;
        while (node != null) {
            res += node.val * multi;
            multi *= 10;
            node = node.next;
        }
        return res;
    }

    public static class ListNode {
        int val;
        LeetCode_2_AddTwoNumbers.ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
