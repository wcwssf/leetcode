package com.practice.str;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author: wang wei chao
 * @description: TODO
 * @date: 2020/7/19 4:14 下午
 * @version: 1.0.0
 */
public class LeetCode_6_ZigzagConversion {

    public static void main(String[] args) {
        String str = "PAYPALISHIRING";
        String convert = convert(str, 3);
        System.out.println(convert);
        String a = convert2(str, 3);
        System.out.println(a);
    }

    /**
     * zigzag
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        Map<Integer, StringBuilder> t = new HashMap<>();
        int size = (numRows << 1) - 2;
        char[] chars = s.toCharArray();
        int line = 0;
        int index = numRows - 1;
        for (int i = 0; i < chars.length; i++) {
            line = i % size;
            if (line >= numRows) {
                line = index - (line - index);
            }
            StringBuilder lineBuilder = t.computeIfAbsent(line, v -> new StringBuilder());
            lineBuilder.append(chars[i]);
        }
        for (int i = 0; i < numRows; i++) {
            StringBuilder lineBuilder = t.get(i);
            if (lineBuilder != null) {
                result.append(lineBuilder);
            }
        }
        return result.toString();
    }

    /**
     * 官方答案
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convert2(String s, int numRows) {
        int row = Math.min(s.length(), numRows);
        StringBuilder[] builders = new StringBuilder[row];
        boolean goingDown = false;
        int curRow = 0;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder builder = builders[curRow];
            if (builder == null) {
                builder = new StringBuilder();
            }
            builders[curRow] = builder;
            builder.append(s.charAt(i));
            if (curRow == 0 || curRow == (row - 1)) {
                goingDown = !goingDown;
            }
            curRow = goingDown ? ++curRow : --curRow;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < builders.length; i++) {
            Optional.ofNullable(builders[i]).ifPresent(v -> result.append(v));
        }
        return result.toString();
    }
}
