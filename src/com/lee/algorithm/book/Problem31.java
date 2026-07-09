package com.lee.algorithm.book;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Problem31 {

    static void main(String[] args) {
        Problem31 p = new Problem31();
        System.out.println(p.solution(new int[]{3, 1, 2, 3}));
        System.out.println(p.solution(new int[]{3, 3,3,2,2,4}));
        System.out.println(p.solution(new int[]{3, 3,3,2,2,2}));
    }

    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int expectedMax = nums.length / 2;

        if(expectedMax <= set.size()) return expectedMax;
        else return set.size();
    }

    public int solutionV2(int[] nums) {
        HashSet<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));

        int n = nums.length;
        int k = n / 2;
        return Math.min(k, set.size());
    }
}
