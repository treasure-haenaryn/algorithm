package com.lee.algorithm.book;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem30 {

    static void main(String[] args) {
        Problem30 p = new Problem30();
        System.out.println(Arrays.toString(p.solutionV2(3,new int[][]{{0, 0, 1}, {0, 1, 2}, {1, 1, 2}})));
        System.out.println(Arrays.toString(p.solutionV2(4,new int[][]{{0, 0, 1}, {1, 1, 2}, {0, 1, 2}, {1, 0, 2}})));
    }
    private static int[] parent;

    private static int find(int x) {
        if(parent[x] == x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    private static void union(int x, int y) {
        int root1 = find(x); // x가 속한 집합의 루트 노드 찾기
        int root2 = find(y); // y가 속한 집합의 루트 노드 찾기
        parent[root2] = root1; // y가 속한 집합을 x가 속한 집합에 합침
    }

    private Boolean[] solutionV2(int k,int[][] operations) {
        parent = new int[k];

        for (int i = 0; i < k; i++) {
            parent[i] = i;
        }

        ArrayList<Boolean> answer = new ArrayList<>();

        for (int[] operation : operations) {
            if(operation[0] == 0) {
                union(operation[1], operation[2]);
            }else{
                answer.add(find(operation[1]) == find(operation[2]));
            }
        }

        return answer.toArray(new Boolean[0]);
    }
}



