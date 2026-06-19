package com.lee.algorithm.book;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem09 {

    public static void main(String[] args) {
        solution(10);
        solution(27);
        solution(12345);
    }

    public static void solution(int num) {
        Deque<Integer> queue = new ArrayDeque<>();
        while (num != 0) {
            queue.push(num % 2);
            num /= 2; // 시간 복잡도 logN
        }
        queue.forEach(System.out::print);
        System.out.println();
    }
}
