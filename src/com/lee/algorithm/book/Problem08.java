package com.lee.algorithm.book;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem08 {

    public static void main(String[] args) {
        Problem08 problem08 = new Problem08();
        System.out.println(problem08.solution("()()"));
        System.out.println(problem08.solution("(())()"));
        System.out.println(problem08.solution(")()("));
        System.out.println(problem08.solution("(()("));
    }

    public boolean solution(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (char aChar : chars) {
            if (aChar == '(') {
                stack.push(aChar);
            }else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
