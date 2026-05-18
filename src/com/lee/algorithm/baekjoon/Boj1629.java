package com.lee.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제
 * 자연수 A를 B번 곱한 수를 알고 싶다.
 * 단 구하려는 수가 매우 커질 수 있으므로 이를 C로 나눈 나머지를 구하는 프로그램을 작성하시오.
 * <p>
 * 입력
 * 첫째 줄에 A, B, C가 빈 칸을 사이에 두고 주어진다. (2 ≤ A, B, C ≤ 2,000,000,000)
 * <p>
 * 출력
 * 첫째 줄에 A를 B번 곱한 수를 C로 나눈 나머지를 출력한다.
 * <p>
 * 예제 입력
 * 10 11 12
 * <p>
 * 예제 출력
 * 4
 */
public class Boj1629 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(solution(A, B, C));
    }

    private static int solution(int A, int B, int C) {
        if (B == 1) return A % C;
        int value = solution(A, B / 2, C);
        value = value * value % C;
        if (B % 2 == 0) return value;
        return value * A % C;
    }
}


