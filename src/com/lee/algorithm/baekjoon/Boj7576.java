package com.lee.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제
 * 철수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다.
 * 토마토는 아래의 그림과 같이 격자 모양 상자의 칸에 하나씩 넣어서 창고에 보관한다.
 * 보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다.
 * 대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로 익는 경우는 없다고 가정한다.
 * 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라.
 * 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.
 * <p>
 * 입출력
 * 첫 줄에는 상자의 크기를 나타내는 두 정수 M,N이 주어진다.
 * M은 상자의 가로 칸의 수, N은 상자의 세로 칸의 수를 나타낸다.
 * 단, 2 ≤ M,N ≤ 1,000 이다. 둘째 줄부터는 하나의 상자에 저장된 토마토들의 정보가 주어진다.
 * 정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.
 * <p>
 * 여러분은 토마토가 모두 익을 때까지의 최소 날짜를 출력해야 한다.
 * 만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고, 토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.
 *
 *
 * 6 4
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 1
 *
 * 8
 *
 * 6 4
 * 0 -1 0 0 0 0
 * -1 0 0 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 1
 *
 * -1
 *
 * 6 4
 * 1 -1 0 0 0 0
 * 0 -1 0 0 0 0
 * 0 0 0 0 -1 0
 * 0 0 0 0 -1 1
 *
 * 6
 *
 * 5 5
 * -1 1 0 0 0
 * 0 -1 -1 -1 0
 * 0 -1 -1 -1 0
 * 0 -1 -1 -1 0
 * 0 0 0 0 0
 *
 * 14
 *
 * 2 2
 * 1 -1
 * -1 1
 *
 * 0
 */

/**
 * 앞선 문제와 달리 시작점이 여러 개 일때
 */
public class Boj7576 {

    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] box = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        int days = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && box[i][j] == 1) {
                    visited[i][j] = true;
                    queue.offer(new int[]{i, j});
                }
            }
        }

        days = solution(N, M, box, visited, queue);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(days == 0 ? 0 : days - 1);
    }

    private static int solution(int N, int M, int[][] box, boolean[][] visited, Queue<int[]> queue) {
        int result = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M ) continue;
                if(visited[nx][ny] || box[nx][ny] == -1) continue;

                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny});
                box[nx][ny] = box[curX][curY] + 1;
                result = box[nx][ny];
            }
        }
        return result;
    }
}
