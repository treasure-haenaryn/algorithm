package com.lee.algorithm.practice;

/**
 * 문제3
 * N이 제곱수이면 1을 반환하고 제곱수가 아니면 0을 반환하는 함수 func3(int N)을 작성하라.
 * N은 10억 이하의 자연수이다.
 *
 * func3(9) = 1
 * func3(693953651) = 0
 * func3(756580036) = 1
 */
public class Practice03 {

    public static void main(String[] args) {
        System.out.println(func3(9));
        System.out.println(func3(693953651));
        System.out.println(func3(756580036));
    }

    /**
     * 시간복잡도 O(루트N)
     */
    private static int func3(int N) {
        int i = 0;
        while (i <= N) {
            i++;
            if (i * i == N) {
                return 1;
            }
        }
        return 0;
    }
}
