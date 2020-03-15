package com.practice.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: wang wei chao
 * @description: 电话号码组合
 * @date: 2020/3/15 4:59 下午
 * @version: 1.0.0
 */
public class LeetCode_17_LetterCombinationOfPhoneNumber {

    private static final String[] LETTER_MAP = new String[]{" ", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        List<String> list = letterCombinations("2395");
        System.out.println(list);
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backTrace(digits, result, new StringBuilder(""), 0);
        return result;
    }

    /**
     * 回溯方法. 结束标志，是当前的index(轮数) = 源串儿长度
     *
     * @param digits  源串儿
     * @param result  存储结果
     * @param builder 存储单条结果
     * @param index   处理的字幕下标
     */
    private static void backTrace(String digits, List<String> result, StringBuilder builder, int index) {
        if (digits.length() == index) {
            result.add(builder.toString());
            return;
        }
        int pos = digits.charAt(index) - '0';
        String letter = LETTER_MAP[pos];
        for (int i = 0, len = letter.length(); i < len; i++) {
            // 选择候选项
            builder.append(letter.charAt(i));
            backTrace(digits, result, builder, index + 1);
            // 取消选择，返回上一层
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
