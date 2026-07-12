package com.lee.algorithm.book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * 영어 끝말잇기
 * https://school.programmers.co.kr/learn/courses/30/lessons/12981
 */
public class Problem32 {

    // n명
    // 1 ~ n 다시 1 부터
    // 단어의 마지막 문자로 시작하는 문자만 가능
    // 이전에 나온 단어 불가능 - set
    // 한글자는 안됨

    // input
    // N : 사람수 , 2이상 10이하
    // words : 단어 , 100개 이하
    // word : 2이상 50이하

    // output[]
    // 최초 탈락 사람 번호
    // 자신의 몇번째 차례
    // 만약 탈락자가 없다면 0,0 - default

    static void main(String[] args) {
        Problem32 p = new Problem32();
        System.out.println(Arrays.toString(p.solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));
        System.out.println(Arrays.toString(p.solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"})));
        System.out.println(Arrays.toString(p.solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"})));
    }

    private static class Person {
        private int idx;
        private int count;

        public Person(int idx, int count) {
            this.idx = idx;
            this.count = count;
        }

        public void plus() {
            this.count++;
        }
    }

    public int[] solution(int n, String[] words) {
        ArrayList<Person> people = new ArrayList<>();
        Set<String> set = new HashSet<>();

        String preWord = words[0];
        set.add(preWord);
        people.add(new Person(0, 1));

        IntStream.range(1, n).forEach(i -> people.add(new Person(i, 0)));

        for (int i = 1; i < words.length; i++) {
            int idx = i % n;
            Person person = people.get(idx);
            person.plus();
            if (!set.contains(words[i]) && preWord.charAt(preWord.length() - 1) == words[i].charAt(0)) {
                set.add(words[i]);
            } else {
                return new int[]{idx + 1, person.count};
            }
            preWord = words[i];
        }
        return new int[]{0, 0};
    }
}
