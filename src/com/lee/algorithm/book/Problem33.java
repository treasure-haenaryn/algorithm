package com.lee.algorithm.book;

import java.util.Arrays;

/**
 * 섬 연결하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/42861
 */
public class Problem33 {

    /*
        문제
        - 모든 섬을 연결
        - 다리 비용이 최소

        요구사항 정리
        - 각 섬의 다리를 건설하는 비용을 오름 차순
        - 비용이 작은 다리 부터 선택해 섬을 연결
        - N개의 섬을 연결하려면 N-1의 다리가 필요하므로 N-1개의 다리가 선택될 때까지 위 두과 정을 반복
        - 비용을 최소화하기 위해 다리를 추가할 때 사이클 형성하지 않도록함
     */

    private static int[] parent;

    private static int find(int x) {
        // x가 속한 집합의 루트 찾기
        if(parent[x] == x) {
            // 경로 압축 : x의 부모를 루트로 설정
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        int root1 = find(x);
        int root2 = find(y);
        parent[root2] = root1;
    }

    public int solution(int n, int[][] costs) {
        // 비용 기준 오름차순
        Arrays.sort(costs, (o1, o2) -> (Integer.compare(o1[2], o2[2])));

        // parent 배열 초기화
        parent = new int[n];
        for (int i = 0; i <n; i++) {
            parent[i] = i;
        }

        int answer = 0;
        int edges = 0;

        for (int[] edge : costs) {
            // n-1 다리 연결된 경우 모든 . 연결
            if (edges == n - 1) {
                break;
            }

            // 현재 다리가 연결하는 두 섬이 이미 연결되어 있는지 확인
            if(find(edge[0]) != find(edge[1])) {
                // 두섬을 하나로 합침
                union(edge[0], edge[1]);
                // 현재 다리의 선설 비용을 총비요에 추가
                answer += edge[2];
                // 사용된 다리 . 1 추가
                edges++;
            }
        }
        return answer;
    }
}
