package com.lee.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제
 * 한수는 크기가 2^N × 2^N인 2차원 배열을 Z모양으로 탐색하려고 한다.
 * 2×2 배열을 왼쪽 위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래 순서로 방문하면 Z모양이다.
 * N > 1인 경우 배열을 2^(N-1) × 2^(N-1) 크기의 4개의 부분 배열로 나눈 후 재귀적으로 Z순서로 방문한다.
 * N이 주어졌을 때, r행 c열을 몇 번째로 방문하는지 출력하라. (행과 열은 0부터 시작)
 * <p>
 * 입력
 * 첫째 줄에 N, r, c가 주어진다. (1 ≤ N ≤ 15, 0 ≤ r, c < 2^N)
 * <p>
 * 출력
 * r행 c열을 몇 번째로 방문했는지 출력한다.
 * <p>
 * 예제 입력 1
 * 2 3 1
 * <p>
 * 예제 출력 1
 * 11
 * <p>
 * 예제 입력 2
 * 3 7 7
 * <p>
 * 예제 출력 2
 * 63
 * <p>
 * 예제 입력 3
 * 1 0 0
 * <p>
 * 예제 출력 3
 * 0
 */
public class Boj1074 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(solution(N, r, c));
    }


    private static int solution(int N, int r, int c) {
        if (N == 0) return 0; // base condition

        int half = (int) Math.pow(2, N - 1);
        // (r,c)가 1번 사각형
        if (r < half && c < half) return solution(N - 1, r, c);
        // (r,c)가 2번 사각형
        if (r < half && c > half) return half * half + solution(N - 1, r, c - half);
        // (r,c)가 3번 사각형
        if (r > half && c < half) return 2 * half * half + solution(N - 1, r - half, c);
        // (r,c)가 4번 사각형
        return 3 * half * half + solution(N - 1, r - half, c - half);
    }

}
