package com.lee.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * 백준 10845번 - 큐
 * <p>
 * 문제
 * 정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
 * <p>
 * 명령은 총 여섯 가지이다.
 * <p>
 * push X : 정수 X를 큐에 넣는 연산이다.
 * pop    : 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * size   : 큐에 들어있는 정수의 개수를 출력한다.
 * empty  : 큐가 비어있으면 1, 아니면 0을 출력한다.
 * front  : 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * back   : 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 *
 * 입력
 * 첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다.
 * 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다.
 * 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다.
 * 문제에 나와있지 않은 명령이 주어지는 경우는 없다.
 *
 * 출력
 * 출력해야 하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.
 *
 * 예제 입력
 * 15
 * push 1
 * push 2
 * front
 * back
 * size
 * empty
 * pop
 * pop
 * pop
 * size
 * empty
 * pop
 * push 3
 * empty
 * front
 *
 * 예제 출력
 * 1
 * 2
 * 2
 * 0
 * 1
 * 2
 * -1
 * 0
 * 1
 * -1
 * 0
 * 3
 */
public class Boj10845 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nStr = br.readLine();
        int N = Integer.parseInt(nStr);

        String[] commands = new String[N];
        for (int i = 0; i < N; i++) {
            commands[i] = br.readLine();
        }

        System.out.println("=== Queue 방식 ===");
        solutionWithQueue(N, commands);
        System.out.println("=== Array 방식 ===");
        solutionWithArray(N, commands);
    }

    private static void solutionWithQueue(int N, String[] commands) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(commands[i]);
            String word = st.nextToken();

            switch (word) {
                case "push":
                    queue.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    System.out.println(queue.isEmpty() ? -1 : queue.poll());
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    System.out.println(queue.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    System.out.println(queue.isEmpty() ? -1 : queue.getFirst());  // 앞 조회
                    break;
                case "back":
                    System.out.println(queue.isEmpty() ? -1 : queue.getLast());  // 뒤 조회
                    break;
                default:
                    break;
            }
        }
    }

    // head: 앞 포인터 (꺼내는 위치)
    // tail: 뒤 포인터 (넣는 위치)
    // 큐가 비어있는 조건: head == tail
    private static void solutionWithArray(int N, String[] commands) {
        int[] arr = new int[N];
        int head = 0;
        int tail = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(commands[i]);
            String word = st.nextToken();

            switch (word) {
                case "push":
                    arr[tail++] = Integer.parseInt(st.nextToken());
                    break;
                case "pop":
                    System.out.println(head == tail ? -1 : arr[head++]);
                    break;
                case "size":
                    System.out.println(tail - head);
                    break;
                case "empty":
                    System.out.println(head == tail ? 1 : 0);
                    break;
                case "front":
                    System.out.println(head == tail ? -1 : arr[head]);
                    break;
                case "back":
                    System.out.println(head == tail ? -1 : arr[tail - 1]);
                    break;
                default:
                    break;
            }
        }
    }
}
