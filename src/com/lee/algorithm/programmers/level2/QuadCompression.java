package com.lee.algorithm.programmers.level2;

/**
 * 프로그래머스 - 쿼드압축 후 개수 세기
 *
 * 문제
 * 0과 1로 이루어진 2^N x 2^N 배열이 있다.
 * 배열의 모든 값이 같으면 압축한다.
 * 다르면 4등분해서 각각 재귀적으로 압축한다.
 * 압축 결과에서 0의 개수와 1의 개수를 반환하라.
 *
 * 입력: int[][] arr
 * 출력: int[] answer → [0의 개수, 1의 개수]
 *
 * 예제 입력
 * [[1,1,0,0],[1,0,0,0],[0,0,0,1],[0,0,1,1]]
 *
 * 예제 출력
 * [4, 9]
 */
public class QuadCompression {

    private static int[] counts = new int[2]; // counts[0] = 0의 개수, counts[1] = 1의 개수

    public int[] solution(int[][] arr) {
        counts = new int[2];
        compress(arr, 0, 0, arr.length);
        return counts;
    }

    private void compress(int[][] arr, int x, int y, int size) {

        // 현재 구역이 전부 같은 숫자인지 확인
        int standard = arr[x][y];
        boolean allSame = true;
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != standard) {
                    allSame = false;
                    break;
                }
            }
            if (!allSame) break;
        }

        // 전부 같으면 압축 → 카운트하고 종료
        if (allSame) {
            counts[standard]++;
            return;
        }

        // 다르면 4등분해서 각각 재귀
        int half = size / 2;
        compress(arr, x,        y,        half); // 왼쪽 위
        compress(arr, x,        y + half, half); // 오른쪽 위
        compress(arr, x + half, y,        half); // 왼쪽 아래
        compress(arr, x + half, y + half, half); // 오른쪽 아래
    }
}
