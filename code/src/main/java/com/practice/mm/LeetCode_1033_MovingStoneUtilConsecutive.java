package com.practice.mm;

import com.practice.util.PrintUtils;

import java.util.stream.IntStream;

/**
 * @author: wang wei chao
 * @description: 移动三个石子直到都挨在一起
 * @date: 2020/6/7 3:35 下午
 * @version: 1.0.0
 */
public class LeetCode_1033_MovingStoneUtilConsecutive {


    public static void main(String[] args) {
        Integer[] ints = numMovesStones(7, 4, 1);
        PrintUtils.printArray(ints);
    }

    public static Integer[] numMovesStones(int a, int b, int c) {
        int min = IntStream.of(a, b, c).min().getAsInt();
        int max = IntStream.of(a, b, c).max().getAsInt();
        int mid = a + b + c - max - min;
        int m = max - min - 2;
        int s = 1;
        // 最大值和最小值距离中间值都大于2
        if (mid - min > 2 && max - mid > 2) {
            s = 2;
        } else if (mid - min == 1 && max - mid == 1) {
            // 三个数挨着
            s = 0;
        }
        return new Integer[]{s, m};
    }
}
