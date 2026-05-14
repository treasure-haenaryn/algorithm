package com.lee.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * ▸ 문제
 * 어떤 큰 도화지에 그림이 그려져 있을 때, 그 그림의 개수와, 그 그림 중 넓이가 가장 넓은 것의 넓이를 출력하여라.
 * 단, 그림이라는 것은 1로 연결된 것을 한 그림이라고 정의하자. 가로나 세로로 연결된 것은 연결이 된 것이고 대각선으로 연결이 된 것은 떨어진 그림이다. 그림의 넓이란 그림에 포함된 1의 개수이다.
 * <p>
 * ▸ 입력
 * 첫째 줄에 도화지의 세로 크기 n(1 ≤ n ≤ 500)과 가로 크기 m(1 ≤ m ≤ 500)이 차례로 주어진다.
 * 두 번째 줄부터 n+1 줄 까지 그림의 정보가 주어진다. (단 그림의 정보는 0과 1이 공백을 두고 주어지며, 0은 색칠이 안된 부분, 1은 색칠이 된 부분을 의미한다)
 * <p>
 * ▸ 출력
 * 첫째 줄에는 그림의 개수, 둘째 줄에는 그 중 가장 넓은 그림의 넓이를 출력하여라.
 * 단, 그림이 하나도 없는 경우에는 가장 넓은 그림의 넓이는 0이다.
 * <p>
 * 예제
 * 6 5
 * 1 1 0 1 1
 * 0 1 1 0 0
 * 0 0 0 0 0
 * 1 0 1 1 1
 * 0 0 1 1 1
 * 0 0 1 1 1
 * <p>
 * 출력
 * 4
 * 9
 */
public class Boj1926 {

    private final static int[] dx = {1, 0, -1, 0};
    private final static int[] dy = {0, 1, 0, -1};
    private static int[][] board;
    private static boolean[][] visited;
    private static int max = 0;
    private static int count = 0;
    private static int n = 0;
    private static int m = 0;
    private static final Queue<int[]> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && board[i][j] == 1) {
                    visited[i][j] = true;
                    int size = solution(i, j);
                    max = Math.max(max, size);
                    count++;
                }
            }
        }

        System.out.println(count);
        System.out.println(max);
    }

    private static int solution(int x, int y) {
        int size = 1;
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if(visited[nx][ny] || board[nx][ny] != 1) {
                    continue;
                }

                visited[nx][ny] = true;
                size++;
                queue.add(new int[]{nx, ny});
            }
        }

        return size;
    }
}
