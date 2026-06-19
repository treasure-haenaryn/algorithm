package com.lee.algorithm.book;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem11 {

    public static void main(String[] args) {
        System.out.println(new Problem11().solution("baabaa"));
        System.out.println(new Problem11().solution("cdcd"));
    }

    public int solution(String s)
    {
        char[] chars = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();

        for (char aChar : chars) {
            if (!stack.isEmpty() &&aChar == stack.peek()) {
                stack.pop();
            }else{
                stack.push(aChar);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
