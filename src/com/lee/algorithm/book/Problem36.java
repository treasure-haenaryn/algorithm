package com.lee.algorithm.book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem36 {

    private static class Node {
        int dest, cost;

        Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    // 방문 여부 체크 X
    public static int[] solution(int[][] graph, int start, int n) {
        // 인접 리스트 저장할 ArrayList 배열 초기화
        ArrayList<Node>[] abList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            abList[i] = new ArrayList<>();
        }

        // graph 정보를 인접리스트 저장
        for (int[] edge : graph) {
            abList[edge[0]].add(new Node(edge[1], edge[2]));
        }


        int[] dist = new int[n];
        // 모든 노드 거리 값 무한대로 초기화
        Arrays.fill(dist, Integer.MAX_VALUE);

        // 시작 노드 거리값 0
        dist[start] = 0;

        // 우선순위 큐 생성 및 시작 노드 삽입
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        priorityQueue.add(new Node(start, 0));

        while (!priorityQueue.isEmpty()) {
            // 현재 가장 거리가 짧은 노드 반환
            Node cur = priorityQueue.poll();

            // 현재 노드의 거리 값이 큐에서 가져온 거리 값보다 크면, 해당 노드는 이미 방문한 것으로 무시
            if(dist[cur.dest] < cur.cost) continue;

            // 현재 노드와 인전합 노드들의 거리를 계산하여 업데이트
            for (Node next : abList[cur.dest]) {
                // 기존에 발견했던 거리보다 더 짧은 거리를 발견하면 거리 값을 갱신하고 큐에 넣음
                if(dist[next.dest] > cur.cost + next.cost) {
                    dist[next.dest] = cur.cost + next.cost;
                    priorityQueue.add(new Node(next.dest, dist[next.dest]));
                }
            }

        }
        return dist;
    }

    // 방문 여부 O
    public static int[] solutionV2(int[][] graph, int start, int n) {

        ArrayList<Node>[] abList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            abList[i] = new ArrayList<>();
        }

        for (int[] edge : graph) {
            abList[edge[0]].add(new Node(edge[1], edge[2]));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n];

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        dist[start] = 0;
        priorityQueue.add(new Node(start, 0));

        while (!priorityQueue.isEmpty()) {
            Node cur = priorityQueue.poll();

            if(visited[cur.dest]) continue;

            // 현재 노드 방문 처리
            visited[cur.dest] = true;

            for (Node next : abList[cur.dest]) {
                if(dist[next.dest] > cur.cost + next.cost) {
                    dist[next.dest] = cur.cost + next.cost;
                    priorityQueue.add(new Node(next.dest, dist[next.dest]));
                }
            }
        }
        return dist;
    }

    static void main(String[] args) {
        int[][] graph = {{0, 1, 9}, {0,2,3}, {1,0,5}, {2,1,1}};
        System.out.println(Arrays.toString(solution(graph, 0, 3)));
        System.out.println(Arrays.toString(solutionV2(graph, 0, 3)));
    }
}
