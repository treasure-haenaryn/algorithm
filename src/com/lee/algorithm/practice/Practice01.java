package com.lee.algorithm.practice;

/**
 * 문제1
 * N 이하의 자연수 중에서 3의 배수이거나 5의 배수인 수를 모두 합한 값을 반환하는 함수 func1(int N)을 작성하라.
 * 단, N은 10만 이하의 자연수이다.
 *
 * func1(16) = 60
 * func1(34567) = 278812814
 * func1(27639) = 178254968
 */
public class Practice01 {

    public static void main(String[] args) {
        System.out.println(func1(16));
        System.out.println(func1(34567));
        System.out.println(func1(27639));
    }

    /**
     * 시간복잡도 O(N)
     */
    private static int func1(int N) {
        int result = 0;
        for (int i = 0; i <= N; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                result += i;
            }
        }
        return result;
    }
}
