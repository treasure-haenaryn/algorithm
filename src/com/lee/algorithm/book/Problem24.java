package com.lee.algorithm.book;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Problem24 {

    public static HashSet<String> answerSet = new HashSet<>();

    public static void main(String[] args) {
        Problem24 p = new Problem24();
        System.out.println(Arrays.toString(p.solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4})));
    }

    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        HashMap<Character, Integer> orderMap = new HashMap<>();

        for (String order : orders) {
            for (char c : order.toCharArray()) {
                orderMap.merge(c, 1, Integer::sum);
            }
        }

        for (int i : course) {
            // 횟수별 단품 메뉴
            Character[] array = orderMap.entrySet().stream().filter(entry -> entry.getValue() >= i).map(Map.Entry::getKey).sorted().toArray(Character[]::new);
            combination(0, i, array, "");
        }

        return answerSet.toArray(String[]::new);
    }

    public void combination(int idx, int len, Character[] orders, String resutlt) {
        if (resutlt.length() == len) {
            answerSet.add(resutlt);
        }

        for (int i = idx; i < orders.length; i++) {
            combination(i + 1, len, orders, resutlt + orders[i]);
        }
    }
}
