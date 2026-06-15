package com.lee.algorithm.book;

import java.util.Arrays;

/**
 * 행렬 곱셈. result[i][j] = sum(arr1[i][k] * arr2[k][j]) (k = 0..c1-1)
 * arr1의 행(r1) x arr2의 열(c2) 크기의 결과 행렬을 구한다.
 */
public class Problem05 {

    public static void main(String[] args) {
        solution(new int[][]{{1, 4}, {3, 2}, {4, 1}}, new int[][]{{3, 3},{3, 3}});
        solution(new int[][]{{2, 3, 2}, {4, 2, 4}, {3, 1, 4}}, new int[][]{{5, 4, 3},{2, 4, 1}, {3,1,1}});
    }

    public static void solution(int[][] arr1, int[][] arr2) {
        int r1 = arr1.length;
        int c1 = arr1[0].length;

        int c2 = arr2[0].length;

        int[][] result = new int[r1][c2];

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    result[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        for (int[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
