package com.practice.leetcode;

/**
 * @author: wang wei chao
 * @description: 两数相除
 * @date: 2020/3/10 11:42 上午
 * @version: 1.0.0
 */
public class LeetCode_29_DevideTwoInt {

    public static void main(String[] args) {
        int divide = divide(-10, 3);
        System.out.println(divide);
    }


    public static int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }
        // isNeg
        boolean isNeg = false;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 & divisor < 0)) {
            isNeg = true;
        }
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        Long res = 0L;
        while (ldividend >= ldivisor) {
            long count = 1;
            long tryDivisor = ldivisor;
            // 需要升级倍数,否则会超时
            while (tryDivisor <= ldividend) {
                tryDivisor = tryDivisor << 1;
                count = count << 1;
            }
            res = res + (count >> 1);
            ldividend = ldividend - (tryDivisor >> 1);
        }
        return isNeg ? 0 - res.intValue() : res > Integer.MAX_VALUE ? Integer.MAX_VALUE : res.intValue();
    }
}
