package com.lee.algorithm.book;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Problem23 {

    public static void main(String[] args) {
        Problem23 p = new Problem23();
        System.out.println(Arrays.toString(p.solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2)));
        System.out.println(Arrays.toString(p.solution(new String[]{"con", "ryan"}, new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}, 3)));
    }

    public int[] solution(String[] id_list, String[] reports, int k) {
        int length = id_list.length;
        int[] answer = new int[length];

        HashMap<String, Integer> countMap = new HashMap<>();
        HashMap<String, HashSet<String>> reportMap = new HashMap<>();

        for (String line : reports) {
            StringTokenizer st = new StringTokenizer(line);
            String report = st.nextToken();
            String reported = st.nextToken();

            reportMap.computeIfAbsent(reported, key -> new HashSet<>()).add(report);
        }

        reportMap.forEach( (key,value) -> {
            if(value.size() >= k) {
                value.forEach(s->countMap.put(s, countMap.getOrDefault(s, 0) + 1));
            }
        });

        for (int i = 0; i < length; i++) {
            answer[i] = countMap.get(id_list[i]) == null ? 0 : countMap.get(id_list[i]);
        }
        return answer;
    }
}
