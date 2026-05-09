package com.lee.algorithm.practice;

/**
 * 문제2
 * 주어진 길이 N의 int 배열 arr에서 합이 100인 서로 다른 위치의 두 원소가 존재하면 1,
 * 존재하지 않으면 0을 반환하는 함수 func2(int arr[], int N)을 작성하라.
 * arr의 각 수는  0 이상 100 이하이고 N은 1000이하이다.
 *
 * func2({1, 52, 48}, 3) = 1
 * func2({50, 42}, 2) = 0
 * func2({4, 13, 63, 87}, 4) = 1
 */
public class Practice02 {

    public static void main(String[] args) {
        System.out.println(func2(new int[]{1, 52, 48}, 3));
        System.out.println(func2(new int[]{50, 42}, 2));
        System.out.println(func2(new int[]{4, 13, 63, 87}, 4));
    }

    /**
     * 시간복잡도 O(N^2)
     */
    private static int func2(int[] arr, int N) {

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (arr[i] + arr[j] == 100) {
                    return 1;
                }
            }
        }

        return 0;
    }
}
