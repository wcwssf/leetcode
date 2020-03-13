package com.practice.leetcode;

import java.util.Objects;

/**
 * @author: wang wei chao
 * @description: 判断回文数
 * @date: 2020/3/13 10:17 上午
 * @version: 1.0.0
 */
public class LeetCode_9_PalindromeNumber {

    public static void main(String[] args) {
        isPalindromeTwp(1009304931);
    }
    /**
     * 转成字符串
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        int s = 0;
        int e = chars.length - 1;
        while (s < e) {
            if (chars[s] != chars[e]) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }

    /**
     * 数字翻转，比较大小
     *
     * @param x
     * @return
     */
    public static boolean isPalindromeTwp(int x) {
        int origin = x;
        Long res = 0L;
        for (; x != 0; x = x / 10) {
            res = res * 10 + (x % 10);
        }
        return Objects.equals(origin, res.intValue());
    }

}
