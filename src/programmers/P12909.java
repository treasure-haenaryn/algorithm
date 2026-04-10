package programmers;

import java.util.ArrayDeque;

/**
 * 프로그래머스 12909 - 올바른 괄호
 * 유형: 스택/큐
 * 난이도: Level 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/12909
 */
public class P12909 {



    private static boolean solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        char[] array = s.toCharArray();

        for (char c : array) {
            if (c == '(') {
                stack.push(c);
            }else{
                if (stack.isEmpty() || stack.pop() == c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(solution("(())"));
        System.out.println(solution("()()"));
        System.out.println(solution("(()"));
        System.out.println(solution(")()"));
        System.out.println(solution("()("));
    }
}
