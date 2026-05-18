package com.lee.algorithm.practice;

public class Practice_RecursiveFunction {

    public static void main(String[] args) {
        printRecursive(10);
        System.out.println(sumRecursive(10));
    }

    private static void printRecursive(int n) {
        System.out.println(n);
        if(n == 1) return;
        printRecursive(n - 1);
    }

    private static int sumRecursive(int n) {
        if(n == 0) return 0;
        return n + sumRecursive(n - 1);
    }
}
