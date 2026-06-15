package com.lee.algorithm.book;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 정답은 "방문한 칸(점)의 개수"가 아니라 "지나간 길(두 점을 잇는 선분/엣지)의 개수"이다.
 * 점 단위로는 "어디서 어디로 이동했는지"라는 선분 정보를 표현할 수 없기 때문에,
 * 같은 선분을 반대 방향으로 다시 지나간 경우를 같은 길로 인식시키려면
 * 이동을 "A->B"와 "B->A" 양쪽 키로 Set에 넣고 size()/2 로 선분 개수를 구해야 한다.
 * (solution은 칸 카운팅 + 비대칭 경계체크로 인한 오답, solutionV2가 올바른 풀이)
 */
public class Problem07 {

    public static void main(String[] args) {
        solution("ULURRDLLU");
        solution("LULLLLLLU");

        System.out.println(solutionV2("ULURRDLLU"));
        System.out.println(solutionV2("LULLLLLLU"));
    }

    public static int solutionV2(String dirs) {
        int[] dx = {-1, 1, 0, 0}; // L R U D
        int[] dy = {0, 0, 1, -1};
        String dirChars = "LRUD";

        Set<String> visited = new HashSet<>();
        int x = 0, y = 0;
        for (char c : dirs.toCharArray()) {
            int idx = dirChars.indexOf(c);
            int nx = x + dx[idx];
            int ny = y + dy[idx];

            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;

            visited.add(x + "," + y + "->" + nx + "," + ny);
            visited.add(nx + "," + ny + "->" + x + "," + y);

            x = nx;
            y = ny;
        }

        return visited.size() / 2;
    }

    public static int solution(String dirs) {
        char[] chars = dirs.toCharArray();
        boolean[][] visited = new boolean[10][10];

        int x = 5, y = 5;
        visited[x][y] = true;
        for (char aChar : chars) {
            if ('U' == aChar) {
                if (x + 1 > 9) continue;
                visited[++x][y] = true;
            } else if ('D' == aChar) {
                if (x - 1 < 0) continue;
                visited[--x][y] = true;
            } else if ('L' == aChar) {
                if (y + 1  > 9) continue;
                visited[x][++y] = true;
            } else if ('R' == aChar) {
                if (y - 1 < 0) continue;
                visited[x][--y] = true;
            }
        }

        int answer = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (visited[i][j]) answer++;
            }
        }

        return answer;
    }
}
