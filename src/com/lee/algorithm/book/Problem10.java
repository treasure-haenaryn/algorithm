package com.lee.algorithm.book;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class Problem10 {

    public static void main(String[] args) {
        Problem10 problem = new Problem10();
        problem.solution("[](){}");
        problem.solution("}]()[{");
        problem.solution("[}{]");
        problem.solution("}}}");
    }

    public int solution(String s) {
        int len = s.length();
        int count = 0;

        LinkedList<Character> list = new LinkedList<>();
        for (char c : s.toCharArray()) {
            list.add(c);
        }

        for (int i = 0; i < len; i++) {
            if (i > 0) {
                list.addLast(list.getFirst());
                list.removeFirst();
            }

            ArrayDeque<Character> stack = new ArrayDeque<>();
            for (int j = 0; j < len; j++) {
                if(list.get(j) == '[' || list.get(j) == '(' || list.get(j) == '{') {
                    stack.push(list.get(j));
                }else{
                    if (stack.isEmpty()) {
                        break;
                    }
                    if(list.get(j) == ']' && stack.pop() != '[') {
                        break;
                    }else if(list.get(j) == ')' && stack.pop() != '(') {
                        break;
                    }else if(list.get(j) == '}' && stack.pop() != '{') {
                        break;
                    }
                }

                if(stack.isEmpty() && j == len - 1) {
                    count++;
                }
            }
        }

        return count;
    }
}
