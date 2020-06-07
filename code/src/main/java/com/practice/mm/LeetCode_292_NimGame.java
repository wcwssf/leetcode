package com.practice.mm;

/**
 * @author: wang wei chao
 * @description: 桌子上有一堆石头，每次你们轮流拿掉 1 - 3 块石头。 拿掉最后一块石头的人就是获胜者。你作为先手
 * 极小化极大算法.（找出失败的最大可能性中的最小值的算法,一般有规律）
 * @date: 2020/6/7 2:54 下午
 * @version: 1.0.0
 */
public class LeetCode_292_NimGame {

    public static void main(String[] args) {
        boolean canWinNim = canWinNim(20);
        System.out.println(canWinNim);
    }

    /**
     * 最后剩四个,必输
     *
     * @param n
     * @return
     */
    public static boolean canWinNim(int n) {
        // n%4 != 0
        return (n & 3) != 0;
    }
}
