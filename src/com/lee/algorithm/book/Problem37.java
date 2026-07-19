package com.lee.algorithm.book;

import java.util.ArrayDeque;

public class Problem37 {

    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    private static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int solution(int[][] maps) {
        int N = maps.length;
        int M = maps[0].length;

        // 최단 거리를 저장할 배열
        int[][] dist = new int[N][M];

        // bfs 탐색 큐
        ArrayDeque<Node> queue = new ArrayDeque<>();
        // 시작점 큐 추가 및 최단 거리 저장
        queue.offer(new Node(0, 0));
        dist[0][0] = 1;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            // 현재 위치에서 이동할 수 있는 모든 방향
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                // map 밖으로 나가는 경우 예외
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                // 벽으로 가는 경우 제외
                if (maps[nx][ny] == 0) continue;

                // 이미 방문한 경우 제외
                if (dist[nx][ny] != 0) continue;

                // 다음위치 최단 거리 갱신
                dist[nx][ny] = dist[now.x][now.y] + 1;
                queue.offer(new Node(nx, ny));
            }
        }

        // 최단거리 반환, 도달하지 못하면 -1
        return dist[N - 1][M - 1] == 0 ? -1 : dist[N - 1][M - 1];
    }

    static void main(String[] args) {

        int[][] maps = new int[][] {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        System.out.println(solution(maps));
    }
}
