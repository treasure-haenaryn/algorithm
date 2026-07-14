package com.lee.algorithm.book;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * 넓이 우선 탐색으로 모든 그래프 노드를 순회 하는 함수 solutiion() 작성
 */
public class Problem35 {

    private static ArrayList<Integer>[] adList;
    private static boolean[] visited;
    private static ArrayList<Integer> answer;

    private static  int[] solution(int[][] graph, int start, int n) {
        adList = new ArrayList[n + 1];
        for (int i = 0; i < adList.length; i++) {
            adList[i] = new ArrayList<>();
        }

        for (int[] edge : graph) {
            adList[edge[0]].add(edge[1]);
        }
        visited = new boolean[n + 1];
        dfs(start);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void dfs(int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            answer.add(cur);
            for (int next : adList[cur]) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }

}
