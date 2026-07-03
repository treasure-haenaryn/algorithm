package com.lee.algorithm.book;

import java.util.Arrays;
import java.util.HashMap;

public class Problem27 {

    static void main(String[] args) {
        Problem27 p = new Problem27();
        System.out.println(Arrays.toString(
                p.solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"}
                        , new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"}
                        , new String[]{"young", "john", "tod", "emily", "mary"}
                        , new int[]{12, 4, 2, 5, 10})
        ));

        // [360, 958, 108, 0, 450, 18, 180, 1080]
    }

    // 계산 조건
    // 수익금 * 0.9 = 본인
    // 수익임 * 0.1 = 추천인
    // 추천인 에게 상납할 때, 소수점 버림 또는 1원 미만일 경우 분배 안함
    // 개당 100원 수익
    // seller는 같은 이름 중복

    // 변수 설명
    // enroll : 전체 판매원
    // referral : enroll의 추천인
    // seller : 판매를 성공한 enroll
    // amount : seller가 판매한 개수

    // 자신을 추천한 사람은 1명임. enroll과 referral 관례를 hashMap 표현
    // hashMap을 통해 null이 나올때 까지 따라가면서 각자의 수익을 SUM
    public int[] solution(String[] enroll, String[] referral, String[] sellers, int[] amount) {
        int enrollLength = enroll.length;
        int[] answer = new int[enrollLength];

        // 판매원 , 추천인
        HashMap<String, String> relation = new HashMap<>();
        HashMap<String, Integer> earn = new HashMap<>();
        for (int i = 0; i < enrollLength; i++) {
            relation.put(enroll[i], referral[i]);
        }

        int sellersLength = sellers.length;
        for (int i = 0; i < sellersLength; i++) {
            String seller = sellers[i];
            int sellerIncome = amount[i] * 100;
            String recommender = relation.get(seller);
            int payment = (int) (sellerIncome * 0.1);
            earn.merge(seller, sellerIncome - payment, Integer::sum);

            while (!recommender.equals("-") && payment > 0) {
                int paymentOpposite = (int) (payment * 0.1);
                earn.merge(recommender, payment - paymentOpposite, Integer::sum);
                recommender = relation.get(recommender);
                payment = paymentOpposite;
            }
        }

        for (int i = 0; i < enrollLength; i++) {
            answer[i] = earn.getOrDefault(enroll[i], 0);
        }

        return answer;
    }
}
