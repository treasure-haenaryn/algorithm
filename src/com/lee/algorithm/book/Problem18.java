package com.lee.algorithm.book;

import java.util.HashSet;

public class Problem18 {

    public static void main(String[] args) {
        Problem18 p = new Problem18();
        System.out.println(p.solution(new int[]{1, 2, 3, 4, 8}, 6));
        System.out.println(p.solution(new int[]{2, 3, 5, 9}, 10));
    }

    public boolean solution(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (set.contains(target - i)) {
                return true;
            } else {
                set.add(i);
            }
        }
        return false;
    }
}
