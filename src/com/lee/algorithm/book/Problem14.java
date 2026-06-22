package com.lee.algorithm.book;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 프로그래머스 81303
 */
public class Problem14 {

    public static void main(String[] args) {
        Problem14 p = new Problem14();
        System.out.println(p.solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"}));
    }

    public String solution(int n, int k, String[] cmd) {
        ArrayDeque<Integer> deleted = new ArrayDeque<>(); // idx stack

        int[] up = new int[n + 2];
        int[] down = new int[n + 2];

        IntStream.range(0, n+2).forEach(i -> {
            up[i] = i - 1;
            down[i] = i + 1;
        });

        k++;

        for (String line : cmd) {
            if(line.startsWith("C")) {
                deleted.push(k); // 삭제 위치
                up[down[k]] = up[k]; // 삭제된 밑의 행
                down[up[k]] = down[k]; // 삭제된 위의 행
                k = n < down[k] ? up[k] : down[k];
            }
            else if(line.startsWith("Z")) {
                Integer pop = deleted.pop();
                down[up[pop]] = pop;
                up[down[pop]] = pop;
            }else{
                String[] s = line.split(" ");
                int x = Integer.parseInt(s[1]);
                for(int i = 0; i < x; i++) {
                    k = s[0].equals("U") ? up[k] : down[k];
                }
            }
        }

        char[] answer = new char[n];
        Arrays.fill(answer, 'O');

        for (int i : deleted) {
            answer[i - 1] = 'X';
        }

        return new String(answer);
    }
}
