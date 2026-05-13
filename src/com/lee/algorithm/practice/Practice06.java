package com.lee.algorithm.practice;

/**
 * 덱 직접구현
 */
public class Practice06 {

    public static void main(String[] args) {
        Deque deque = new Deque();
    }


    public static class Deque {

        private final int MX = 1000005;
        private final int[] dat = new int[2 * MX + 1];
        private int head = MX, tail = MX;

        public void push_front(int x) {
            dat[--head] = x;
        }

        public void push_back(int x) {
            dat[tail++] = x;
        }

        public void pop_front() {
            head++;
        }

        public void pop_back() {
            tail--;
        }

        public int front() {
            return dat[head];
        }

        public int back() {
            return dat[tail-1];
        }
    }
}
