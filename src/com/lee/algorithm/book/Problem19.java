package com.lee.algorithm.book;

import java.util.Arrays;
import java.util.HashMap;

public class Problem19 {
    public static void main(String[] args) {
        Problem19 p = new Problem19();
        System.out.println(p.solution(new String[] {"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
        System.out.println(p.solution(new String[] {"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"}));
    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> completions = new HashMap<>();
        Arrays.stream(completion).forEach(c -> completions.put(c, completions.getOrDefault(c, 0) + 1));

        for (String p : participant) {
            if(completions.getOrDefault(p,0)==0) {
                return p;
            }
            completions.put(p, completions.get(p) - 1);
        }
        return answer;
    }
}
