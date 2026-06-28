package com.lee.algorithm.book;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem20 {

    public static void main(String[] args) {
        Problem20 p = new Problem20();
        System.out.println(p.solution(new String[]{"banana", "apple", "rice", "pork", "pot"}, new int[]{3,2,2,2,1}, new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}));
    }

    /**
     * 1 ≤ want의 길이 = number의 길이 ≤ 10
     * 1 ≤ number의 원소 ≤ 10
     * number[i]는 want[i]의 수량을 의미하며, number의 원소의 합은 10입니다.
     *
     * 10 ≤ discount의 길이 ≤ 100,000
     *
     * 과일 종류는 최대 12개
     *
     * 회원등록 날짜의 총 일수를 return 하는 solution 함수를 완성하시오. 가능한 날이 없으면 0을 return 합니다.
     *
     * 즉, 모든일에 대해 체크가 가능해야하고 일은 100,000일 까지 있어서 이중 포문 같은건 쓰면 안됌
     */
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        HashMap<String, Integer> wantMap = new HashMap<>();
        HashMap<String, Integer> discountMap = new HashMap<>();
        int discountLength = discount.length;;
            int wantLength = want.length;

        int initIdx = 0;

        for (int i = 0; i < wantLength; i++) {
            wantMap.put(want[i], number[i]);
        }

        for (int i = 0; i < 10; i++) {
            discountMap.put(discount[i], discountMap.getOrDefault(discount[i], 0) + 1);
        }

        //  사야될 물건 만큼
        while (true) {
            boolean isCheacked = true;
            for (Map.Entry<String, Integer> entry : wantMap.entrySet()) {
                if(discountMap.getOrDefault(entry.getKey(), 0) != entry.getValue()){
                    isCheacked = false;
                    break;
                }
            }
            if(isCheacked) answer++;
            discountMap.put(discount[initIdx], discountMap.get(discount[initIdx])-1);
            initIdx++;
            if(initIdx + 10 > discountLength) {
                break;
            }
            discountMap.put(discount[initIdx+10-1], discountMap.getOrDefault(discount[initIdx+10-1], 0) + 1);
        }

        return answer;
    }
}
