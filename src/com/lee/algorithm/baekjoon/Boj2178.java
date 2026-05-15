package com.lee.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제
 * N×M크기의 배열로 표현되는 미로가 있다.
 *
 *
 * 미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때,
 * (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오.
 * 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
 *
 * 위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다.
 * 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
 *
 * 입력
 * 첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다.
 * 각각의 수들은 붙어서 입력으로 주어진다.
 *
 * 출력
 * 첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착 위치로 이동할 수 있는 경우만 입력으로 주어진다.
 *
 * # 입력
 * 4 6
 * 101111
 * 101010
 * 101011
 * 111011
 *
 *
 * 출력
 * 15
 */

/**
 * [다차원 배열에서의 거리측정 타입]
 * BFS를 이용해 시작점에서 연결된 다른 모든 점으로의 최단 경로를 찾을 수 있어요.
 * 단순히 상하좌우 연결된 점을 방문에 끝나는게 아니라, 시작점과의 거리를 전부 계산할 수 있다.
 */
public class Boj2178 {

    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        StringTokenizer st = new StringTokenizer(line);

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = Character.getNumericValue(chars[j]);
            }
        }

        System.out.println(solution(N, M, map, visited));
    }

    private static int solution(int N, int M, int[][] map, boolean[][] visited) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >=M) {
                    continue;
                }
                if(visited[nx][ny] || map[nx][ny] == 0) {
                    continue;
                }
                visited[nx][ny] = true;
                map[nx][ny] = map[curX][curY] + 1;
                queue.offer(new int[]{nx, ny});
            }

        }
        return map[N - 1][M - 1];
    }
}
