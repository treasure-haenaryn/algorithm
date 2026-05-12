package com.lee.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 문제
 * 정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
 * <p>
 * 명령은 총 다섯 가지이다.
 * <p>
 * push X: 정수 X를 스택에 넣는 연산이다.
 * pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * size: 스택에 들어있는 정수의 개수를 출력한다.
 * empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
 * top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * <p>
 * 입력
 * 첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다.
 * 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다.
 * 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다.
 * 문제에 나와있지 않은 명령이 주어지는 경우는 없다.
 * <p>
 * 출력
 * 출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.
 */
public class Boj10828 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nStr = br.readLine();
        int N = Integer.parseInt(nStr);

        String[] commands = new String[N];
        for (int i = 0; i < N; i++) {
            commands[i] = br.readLine();
        }

        System.out.println("Stack");
        solutionWithStack(N, commands);
        System.out.println("Array");
        solutionWithStack(N, commands);
    }

    private static void solutionWithStack(int N, String[] commands) {

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(commands[i]);

            String word = st.nextToken();

            switch (word) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    System.out.println(stack.isEmpty() ? -1 : stack.pop());
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    System.out.println(stack.isEmpty() ? 1 : 0);
                    break;
                case "top":
                    System.out.println(stack.isEmpty() ? -1 : stack.peek());
                    break;
                default:
                    break;
            }
        }
    }

    private static void solutionWithArray(int N, String[] commands) {
        int[] arr = new int[N];
        int pos = -1;
        for (int i = 0; i < N; i++) {
            String word = new StringTokenizer(commands[i]).nextToken();

            switch (word) {
                case "push":
                    arr[++pos] = Integer.parseInt(commands[i]);
                    break;
                case "pop":
                    System.out.println(pos == -1 ? -1 : arr[pos--]);
                    break;
                case "size":
                    System.out.println(pos == -1 ? 0 : pos + 1);
                    break;
                case "empty":
                    System.out.println(pos == -1 ? 1 : 0);
                    break;
                case "top":
                    System.out.println(pos == -1 ? -1 : arr[pos]);
                    break;
                default:
                    break;
            }
        }


    }
}
