package com.lee.algorithm.baekjoon;

/**
 * 문제
 * 세 개의 장대가 있고 첫 번째 장대에는 N개의 원판이 크기 순서대로 쌓여 있다.
 * 1번 장대의 원판을 3번 장대로 옮기려 한다.
 * 규칙
 * 1. 한 번에 한 개의 원판만 다른 장대로 옮길 수 있다.
 * 2. 큰 원판이 작은 원판 위에 있으면 안 된다.
 * <p>
 * 입력
 * 첫째 줄에 첫 번째 장대에 쌓인 원판의 개수 N이 주어진다. (1 ≤ N ≤ 20)
 * <p>
 * 출력
 * 첫째 줄에 옮긴 횟수 K를 출력한다.
 * 둘째 줄부터 K줄에 걸쳐 원판을 옮기는 과정을 출력한다.
 * 각 줄에 A B를 출력하면 A번 장대의 가장 위 원판을 B번 장대로 옮긴다는 뜻이다.
 * <p>
 * 예제 입력
 * 3
 * <p>
 * 예제 출력
 * 7
 * 1 3
 * 1 2
 * 3 2
 * 1 3
 * 2 1
 * 2 3
 * 1 3
 */
public class Boj11729 {

    /**
     * 1. 함수의 정의 - 함수가 어떤 역할을 수행하는지, 어떤 인자를 받는지 결정
     * void func(int a, int b, int n)
     * 원판 n개를 a번 기둥에서 b번 기둥으로 옮기는 방법을 출력하는 함수
     * <p>
     * 2. base condition
     * n=1 일때 System.out.println(a + ' ' + b);
     * <p>
     * 3. 재귀식
     * n-1개의 원판을 기둥 a에서 기둥 6-a-b로 옮긴다.
     * n번 원판을 기둥 a에서 기둥 b로 옮긴다.
     * n-1개의 원판을 기둥 6-a-b에서 기둥 b로 옮긴다.
     */

    private static int count = 0;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        solution(1, 3, 3);

        System.out.println(count);
        System.out.println(sb.toString());
    }

    private static void solution(int a, int b, int n) {
        count++;
        if (n == 1) {
            sb.append(a).append(" ").append(b).append("\n");
            return;
        }
        solution(a , 6-a-b, n-1);
        sb.append(a).append(" ").append(b).append("\n");
        solution(6-a-b , b, n-1);
    }
}
