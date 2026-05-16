package com.lee.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제
 * 수빈이는 현재 점 N에 있고, 동생은 점 K에 있다.
 * 수빈이는 걷거나 순간이동을 할 수 있다.
 * 걷는 경우: 현재 위치 X에서 X-1 또는 X+1로 이동 (1초)
 * 순간이동: 현재 위치 X에서 2*X로 이동 (1초)
 * 수빈이가 동생을 찾을 수 있는 가장 빠른 시간(초)을 구하라.
 * <p>
 * 입력
 * 첫째 줄에 수빈이의 위치 N과 동생의 위치 K가 주어진다. (0 ≤ N ≤ 100,000, 0 ≤ K ≤ 100,000)
 * <p>
 * 출력
 * 수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.
 * <p>
 * 예제 1
 * 입력: 5 17
 * 출력: 4
 * <p>
 * 예제 2
 * 입력: 17 4
 * 출력: 13
 */
public class Boj1697 {

    private static int N;
    private static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(solution());
    }

    private static int solution() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{N, 0});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cur = poll[0];
            int time = poll[1];

            for (int i = 1; i <= 3; i++) {
                int nTime = time + 1;
                if (i == 1) {
                    int result = cur - 1;
                    if(result == K) return nTime;
                    if (result < 0) continue;
                    queue.offer(new int[]{result, nTime});
                } else if (i == 2) {
                    int result = cur + 1;
                    if(result == K) return nTime;
                    if (result > 200000) continue;
                    queue.offer(new int[]{result, nTime});
                } else {
                    int result = cur * 2;
                    if(result == K) return nTime;
                    if (result > 200000) continue;
                    queue.offer(new int[]{result, nTime});
                }
            }
        }
        return 0;
    }
}
