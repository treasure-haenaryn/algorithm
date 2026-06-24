package com.lee.algorithm.book;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Problem16 {

    public static void main(String[] args) {
        Problem16 p = new Problem16();
        System.out.println(Arrays.toString(p.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})));
    }

    public int[] solution(int[] progresses, int[] speeds) {
        int length = progresses.length;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        IntStream.rangeClosed(0, length - 1).forEach(queue::offer); // idx
        ArrayList<Integer> list = new ArrayList<>();

        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            Integer peek = queue.peek();
            if (progresses[peek] + speeds[peek]*count>= 100) {
                queue.poll();
                int result = 1;
                for (int i = peek+1; i < length; i++) {
                    if(progresses[i] + speeds[i]*count >= 100) {
                        result++;
                        queue.poll();
                    }else{
                        break;
                    }
                }
                list.add(result);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}
