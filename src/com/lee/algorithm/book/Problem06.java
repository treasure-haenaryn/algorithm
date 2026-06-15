package com.lee.algorithm.book;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 실패율 = 해당 스테이지에 머물러 있는 인원 / 그 스테이지에 도달한 인원.
 * challenger[i]에 각 스테이지별 머문 인원을 카운트하고,
 * total(도달 인원)에서 challenger[i]만큼 차감해가며 다음 스테이지의 도달 인원을 구한다.
 * 이후 실패율 내림차순(같으면 스테이지 번호 오름차순)으로 정렬해 반환한다.
 */
public class Problem06 {

    public static void main(String[] args) {
        solution(5, new int[]{2,1,2,6,2,4,3,3});
    }

    public static void solution(int N, int[] stages) {

        int[] challenger = new int[N+2];
        for (int stage : stages) {
            challenger[stage] += 1;
        }

        HashMap<Integer, Double> fails = new HashMap<>();

        double total = stages.length;

        for (int i = 1; i <=N ; i++) {
            if (challenger[i] == 0) {
                fails.put(i, 0.0);
            }else{
                fails.put(i, (double) challenger[i] / total);
                total -= challenger[i];
            }
        }

        int[] array = fails.entrySet().stream().sorted((o1, o2) -> {
            return o1.getValue().equals(o2.getValue()) ? Integer.compare(o1.getKey(), o2.getKey()) : Double.compare(o2.getValue(), o1.getValue());
        }).mapToInt(Map.Entry::getKey).toArray();

        System.out.println(Arrays.toString(array));
    }
}
