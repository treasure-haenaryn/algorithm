package com.lee.algorithm.book;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class Problem02 {
    public static void main(String[] args) {
        solution(new int[]{4, 2, 2, 1, 3, 4});
        solution2(new int[]{4, 2, 2, 1, 3, 4});
    }

    public static void solution(int[] arr) {
        Integer[] integers = Arrays.stream(arr).boxed().distinct().toArray(Integer[]::new);
        Arrays.sort(integers, Comparator.reverseOrder());
        System.out.println(Arrays.toString(integers));
    }

    public static void solution2(int[] arr) {
        TreeSet<Integer> set = new TreeSet<>(Comparator.reverseOrder());
        for (int i : arr) {
            set.add(i);
        }

        int[] result = new int[set.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = set.pollFirst();
        }
        System.out.println(Arrays.toString(result));
    }
}
