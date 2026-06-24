package com.lee.algorithm.book;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Problem17 {

    public static void main(String[] args) {
        Problem17 p = new Problem17();
        System.out.println(p.solution(new String[]{"i", "drink", "water"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"}));
    }

    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";

        ArrayDeque<String> queue1 = new ArrayDeque<>(Arrays.asList(cards1));
        ArrayDeque<String> queue2 = new ArrayDeque<>(Arrays.asList(cards2));

        for (String s : goal) {
            if(s.equals(queue1.peek())){
                queue1.poll();
                continue;
            }else if(s.equals(queue2.peek())){
                queue2.poll();
                continue;
            }
            answer = "No";
            break;
        }

        return answer;
    }
}
