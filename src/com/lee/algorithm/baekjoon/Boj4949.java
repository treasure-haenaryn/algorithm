package com.lee.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Boj4949 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        solution(br);
    }

    private static void solution(BufferedReader br) throws IOException {
        String line;

        while ((line = br.readLine()) != null) {
            if (line.equals(".")) {
                break;
            }

            ArrayDeque<Character> stack = new ArrayDeque<>();
            boolean balanced = true;

            for (char c : line.toCharArray()) {
                if (c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        balanced = false;
                        break;
                    }
                } else if (c == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        balanced = false;
                        break;
                    }
                }
            }

            System.out.println(balanced && stack.isEmpty() ? "yes" : "no");
        }
    }

}
