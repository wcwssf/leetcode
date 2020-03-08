package com.practice.leetcode;

import java.util.*;

/**
 * @author: wang wei chao
 * @description: 判断有效的括号
 * @date: 2020/3/8 5:14 下午
 * @version: 1.0.0
 */
public class LeetCode_20_ValidParentheses {

    /**
     * 如果是左括号则进栈，否则比较当前char和栈顶元素是否相等
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Set<Character> set = new HashSet<>();
        set.add('{');
        set.add('[');
        set.add('(');
        Map<Character, Character> pairMap = new HashMap<>();
        pairMap.put('}', '{');
        pairMap.put(']', '[');
        pairMap.put(')', '(');
        int index = 0;
        int len = s.length();
        while (index < len) {
            Character c = s.charAt(index);
            if (set.contains(c)) {
                stack.add(c);
            } else {
                if (stack.size() == 0) {
                    return false;
                }
                Character peek = stack.peek();
                if (peek.equals(pairMap.get(c))) {
                    stack.pop();
                } else {
                    return false;
                }
            }
            index++;
        }
        return stack.isEmpty();
    }

    /**
     * 预先判断
     *
     * @param s
     * @return
     */
    public boolean isValidTwo(String s) {
        // 显而易见的异常case 可以预先排除.耗时减少1ms(总的test cases)
        if (s.length() % 2 != 0) {
            return false;
        }
        Map<Character, Character> pairMap = new HashMap<>();
        pairMap.put('{', '}');
        pairMap.put('(', ')');
        pairMap.put('[', ']');
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (pairMap.containsKey(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (ch != pairMap.get(stack.pop())) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * 预先判断&使用 多个 if 判断替换 map,耗时减少1ms
     * 使用switch 替换if，还会减少1ms
     *
     * @param s
     * @return
     */
    public boolean isValidThree(String s) {
        // 显而易见的异常case 可以预先排除.耗时减少1ms(总的test cases)
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '{' || ch == '(' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (pop == '(') {
                    if (ch != ')') {
                        return false;
                    }
                } else if (pop == '{') {
                    if (ch != '}') {
                        return false;
                    }
                } else if (pop == '[') {
                    if (ch != ']') {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

}
