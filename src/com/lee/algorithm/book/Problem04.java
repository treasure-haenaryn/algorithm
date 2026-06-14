package com.lee.algorithm.book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem04 {

    public static int[] one = {1, 2, 3, 4, 5};
    public static int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
    public static int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3};

    public static void main(String[] args) {
        solution(new int[]{1, 2, 3, 4, 5});
        solution(new int[]{1, 3, 2, 4, 2});
    }

    public static void solution(int[] arr) {
        int[] person = new int[3];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == one[i % one.length]) {
                person[0] = person[0] + 1;
            }
            if (arr[i] == two[i % two.length]) {
                person[1] = person[1] + 1;
            }
            if (arr[i] == two[i % three.length]) {
                person[2] = person[2] + 1;
            }
        }

        int maxScore = Arrays.stream(person).max().getAsInt();

        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < person.length; i++) {
            if (maxScore == person[i]) {
                answer.add(i + 1);
            }
        }

        System.out.println(Arrays.toString(answer.stream().mapToInt(Integer::intValue).toArray()));

    }

}
