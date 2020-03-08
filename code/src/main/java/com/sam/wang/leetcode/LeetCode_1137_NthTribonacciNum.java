package com.sam.wang.leetcode;

/**
 * @author: wang wei chao
 * @description: 第n个泰波那契数
 * @date: 2020/3/8 11:01 上午
 * @version: 1.0.0
 */
public class LeetCode_1137_NthTribonacciNum {

    public static void main(String[] args) {
        int tribonacci = tribonacci(10);
        System.out.println(tribonacci);
        tribonacci = tribonacci(23);
        System.out.println(tribonacci);
    }

    public static int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        int first = 0;
        int second = 1;
        int third = 1;
        int res = 1;
        int index = 2;
        while (index < n) {
            res = first + second + third;
            first = second;
            second = third;
            third = res;
            index++;
        }
        return third;
    }
}
