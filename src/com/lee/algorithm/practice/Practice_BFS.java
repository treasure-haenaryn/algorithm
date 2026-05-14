package com.lee.algorithm.practice;

import java.util.ArrayDeque;
import java.util.Queue;

public class Practice_BFS {

    public static void main(String[] args) {

        int[][] board = new int[502][502]; // 1이면 파란 칸, 0이면 빨간 칸

        boolean[][] visited = new boolean[502][502]; // 방문 여부

        int n = 7, m = 10; // 행과 열 갯수

        int[] dx = {1, 0, -1, 0}; // 상하좌우를 처리 하기 위한 변수
        int[] dy = {0, 1, 0, -1};

        Queue<int[]> queue = new ArrayDeque<>(); // 0,0 방문 표시하고 큐에 추가
        visited[0][0] = true;
        queue.offer(new int[]{0, 0});

        // 큐가 빌 때까지 상하좌우를 반복
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0]; // 행
            int y = cur[1]; // 열

            for (int i = 0; i < 4 ; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx <0 || nx >=  n || ny <0 || ny >= m ) { // 범위에 들어오는지 확인
                    continue;
                }
                if(visited[nx][ny] || board[nx][ny] != 1) { // 이미 방문 혹은 파란 칸이 아닌 경우
                    continue;
                }
                visited[nx][ny] = true; // 위의 로직과 순서가 바뀌면 OutOfIndex 예외
                queue.offer(new int[]{nx, ny});
            }
        }
    }
}
