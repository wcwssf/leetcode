package com.practice.dp;

import java.util.Arrays;

/**
 * @author: wang wei chao
 * @description: 兑换零钱(动态规划)
 * @date: 2020/3/29 6:55 下午
 * @version: 1.0.0
 */
public class LeetCode_322_CoinChange {

    public static void main(String[] args) {
        int[] coins = new int[]{133, 419, 83, 408};
        int count = coinChange(coins, 6249);
        System.out.println(count);
    }

    /**
     * 找零钱
     * 状态方程: f(x)=0 n=0;
     * f(x)=-1 n<0;
     * f(x)=f(n-coin) +1; n > 0; coin in {coins}
     *
     * @param coins  可找的零钱面值
     * @param amount 总共找的金额
     * @return 返回最少个数
     */
    public static int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        int[] dpTable = new int[amount + 1];
        Arrays.sort(coins);
        Arrays.fill(dpTable, amount + 1);
        dpTable[0] = 0;
        // 步长是否可换成coins的最大公约数
        int len = multiGcd(coins);
        for (int i = coins[0]; i <= amount; i += len) {
            for (int c : coins) {
                if (i - c < 0) {
                    continue;
                }
                dpTable[i] = Math.min(dpTable[i], dpTable[i - c] + 1);
            }
        }
        return dpTable[amount] >= (amount + 1) ? -1 : dpTable[amount];
    }

    private static int multiGcd(int[] coins) {
        if (coins.length == 1) {
            return coins[0];
        }
        int gcd = coins[0];
        for (int c : coins) {
            gcd = gcd(gcd, c);
        }
        return gcd;
    }

    public static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        return gcd(q, p % q);
    }
}
