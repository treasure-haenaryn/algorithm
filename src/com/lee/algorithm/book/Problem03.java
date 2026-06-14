package com.lee.algorithm.book;

import java.util.*;

public class Problem03 {

    public static void main(String[] args) {
        solution(new int[]{2, 1, 3, 4, 1});
    }

    public static void solution(int[] arr) {
        int length = arr.length;

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                set.add(arr[i] + arr[j]);
            }
        }
        System.out.println(Arrays.toString(set.stream().sorted().mapToInt(Integer::intValue).toArray()));
    }
}
