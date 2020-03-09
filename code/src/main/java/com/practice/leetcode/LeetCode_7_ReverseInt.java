package com.practice.leetcode;

/**
 * @author wangweichao
 * @desc 数字翻转
 */
public class LeetCode_7_ReverseInt {

    public static void main(final String[] args) {
        final LeetCode_7_ReverseInt reverse = new LeetCode_7_ReverseInt();
        final int a = reverse.reverseTwo(-238934);
        System.out.println(a);
    }

    private char[] charArray;

    public int reverse(int x) {
        boolean isNeg = false;
        if (x < 0) {
            isNeg = true;
            x = 0 - x;
        }

        char[] charArray = String.valueOf(x).toCharArray();
        int start = 0;
        int end = charArray.length - 1;
        while (start < end) {
            char ch = charArray[end];
            charArray[end] = charArray[start];
            charArray[start] = ch;
            end--;
            start++;
        }
        try {
            Integer res = Integer.parseInt(new String(charArray));
            if (isNeg) {
                res = 0 - res;
            }
            return res;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private int reverseTwo(int x) {
        Long res = 0L;
        for (; x != 0; x = x / 10) {
            int a = x % 10;
            res = res * 10 + a;
        }
        return res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ? 0 : res.intValue();
    }

}