package com.lee.algorithm.practice;

/**
 * 문제4
 * N 이하의 수 중에서 가장 큰 2의 거듭제곱수를 반환하는 함수 func4(int N)을 작성하라.
 * N은 10억 이하의 자연수 이다.
 *
 * func4(5) = 4
 * func4(97615282) = 67108864
 * func4(1024) = 1024
 */
public class Practice04 {

    public static void main(String[] args) {
        System.out.println(func4(5));
        System.out.println(func4(97615282));
        System.out.println(func4(1024));
    }

    /**
     * 시간복잡도 logN
     */
    private static int func4(int N) {
        int result = 0;
        for (int i = 2; i <= N; i *= 2) {
            result = i;
        }
        return result;
    }
}
