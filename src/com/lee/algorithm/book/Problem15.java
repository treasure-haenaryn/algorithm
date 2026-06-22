package com.lee.algorithm.book;


import java.util.ArrayDeque;
import java.util.stream.IntStream;

public class Problem15 {
    public static void main(String[] args) {

    }
    public int solution(int N, int K) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        IntStream.rangeClosed(1, N).forEach(queue::addLast);

        while (queue.size() > 1) {
            for (int i = 0; i < K-1; i++) {
                queue.addFirst(queue.pollFirst());
            }
            queue.pollFirst();
        }

        return queue.pollFirst();
    }

}
