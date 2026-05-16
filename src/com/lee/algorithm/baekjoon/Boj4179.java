package com.lee.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [시작지점이 두 종류인 BFS]
 * 단, 어느 하나라도 독립적이지 않고 서로에게 영향을 준다면 지금 방법으론 불가능 (백트래킹 기법을 추가해야됨. 18809)
 * 그럴떄는 시간순으로 A와 B를 동시에 진행해됨.
 *
 * 지훈이는 미로에서 일을 한다. 지훈이를 미로에서 탈출하도록 도와주자!
 * 미로에서의 지훈이의 위치와 불이 붙은 위치를 감안해서 지훈이가 불에 타기전에 탈출할 수 있는지의 여부,
 * 그리고 얼마나 빨리 탈출할 수 있는지를 결정해야한다.
 * 지훈이와 불은 매 분마다 한칸씩 수평또는 수직으로(비스듬하게 이동하지 않는다)  이동한다.
 * 불은 각 지점에서 네 방향으로 확산된다.
 * 지훈이는 미로의 가장자리에 접한 공간에서 탈출할 수 있다.
 * 지훈이와 불은 벽이 있는 공간은 통과하지 못한다.
 * <p>
 * ▸ 입력
 * 입력의 첫째 줄에는 공백으로 구분된 두 정수 R과 C가 주어진다.
 * 단, 1 ≤ R, C ≤ 1000 이다. R은 미로 행의 개수, C는 열의 개수이다.
 * 다음 입력으로 R줄동안 각각의 미로 행이 주어진다.
 * 각각의 문자들은 다음을 뜻한다.
 * <p>
 * #: 벽
 * .: 지나갈 수 있는 공간
 * J: 지훈이의 미로에서의 초기위치 (지나갈 수 있는 공간)
 * F: 불이 난 공간
 * J는 입력에서 하나만 주어진다.
 * <p>
 * ▸ 출력
 * 지훈이가 불이 도달하기 전에 미로를 탈출 할 수 없는 경우 IMPOSSIBLE 을 출력한다.
 * 지훈이가 미로를 탈출할 수 있는 경우에는 가장 빠른 탈출시간을 출력한다.
 * <p>
 * 예제 입력
 * 4 4
 * ####
 * #JF#
 * #..#
 * #..#
 * <p>
 * 예제 출력
 * 3
 */
public class Boj4179 {

    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    private static char[][] map;
    private static int[][] fireMap;
    private static int[][] personMap;
    private static boolean[][] visited;
    private static int R; // 행
    private static int C; // 열
    private static final Queue<int[]> person = new ArrayDeque<>();
    private static final Queue<int[]> fire = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];
        fireMap = new int[R][C];
        personMap = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                personMap[i][j] = -1;
                fireMap[i][j] = -1;
            }
        }

        for (int i = 0; i < R; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j] = chars[j];
                if (chars[j] == 'J') {
                    person.offer(new int[]{i, j});
                    personMap[i][j] = 0;
                } else if (chars[j] == 'F') {
                    fire.offer(new int[]{i, j});
                    fireMap[i][j] = 0;
                }
            }
        }

        int result = solution();
        System.out.println(result == 0 ? "IMPOSSIBLE" : result);
    }

    private static int solution() {

        // 불에 대한 BFS
        while (!fire.isEmpty()) {
            int[] cur = fire.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (fireMap[nx][ny] >= 0|| map[nx][ny] == '#') continue;
                fire.offer(new int[]{nx, ny,});
                fireMap[nx][ny] = fireMap[cur[0]][cur[1]] + 1;
            }
        }

        // 사람에 대한 BFS
        while (!person.isEmpty()) {
            boolean[][] personVisited = visited.clone();

            int[] curP = person.poll();
            for (int i = 0; i < 4; i++) {
                int curX = curP[0];
                int curY = curP[1];
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                /**
                 * 범위를 벗어남은 탈출 성공을 의미.
                 * 큐에 거리 순으로 들어가기 때문에 최초의 탈출한 시간을 출력하면됨.
                 */
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                    return personMap[curX][curY] + 1;
                }
                if (personMap[nx][ny] >= 0 || map[nx][ny] == '#') continue;

                // 불의 전파 시간 조건
                if (fireMap[curX][curY] != -1 && fireMap[nx][ny] <= personMap[nx][ny]) continue;

                personMap[nx][ny] = personMap[curX][curY] + 1;
                person.offer(new int[]{nx, ny,});
            }
        }

        return 0;
    }

}
