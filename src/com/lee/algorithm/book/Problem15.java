package com.lee.algorithm.book;


import java.util.ArrayDeque;
import java.util.stream.IntStream;

public class Problem15 {
    public static void main(String[] args) {
        Problem15 p = new Problem15();
        System.out.println(p.solution(5, 2));
    }
    public int solution(int N, int K) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        IntStream.rangeClosed(1, N).forEach(queue::offer);

        while (queue.size() > 1) {
            for (int i = 0; i < K-1; i++) {
                queue.offer(queue.poll());
            }
            queue.poll();
        }

        return queue.pollFirst();
    }

}
