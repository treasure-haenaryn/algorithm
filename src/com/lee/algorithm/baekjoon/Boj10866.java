package com.lee.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * 정수를 지정하는 덱을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
 *
 * - push_front x : 정수 x를 덱의 앞에 넣는다.
 * - push_back x : 정수 x를 덱의 뒤에 넣는다.
 * - pop_front : 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 없으면 -1
 * - pop_back : 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 없으면 -1
 * - size : 덱에 들어있는 정수의 개수를 출력한다.
 * - empty : 덱이 비어있으면 1을, 아니면 0을 출력한다.
 * - font : 덱의 가장 앞에 있는 정수를 출력한다. 없으면 -1
 * - back : 덱의 가장 뒤에 있는 정수를 출력한다. 없으면 -1
 *
 * 입력
 * - 첫째 줄에 주어지는 명령의 수 N ( 1<=N<=10000)이 주어진다.
 *   둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다.
 *   주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다.
 *   문제에 나와있지 않은 명령이 주어지는 경우는 없다.
 *
 */
public class Boj10866 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nStr = br.readLine();
        int N = Integer.parseInt(nStr);
        String[] commands = new String[N];
        for (int i = 0; i < N; i++) {
            commands[i] = br.readLine();
        }

        System.out.println("Deque");
        solutionWithDeque(N, commands);
        System.out.println("Array");
        solutionWithArray(N, commands);
    }

    private static void solutionWithDeque(int N, String[] commands) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (String command : commands) {
            StringTokenizer st = new StringTokenizer(command);
            String word = st.nextToken();

            switch (word) {
                case "push_front":
                    int x1 = Integer.parseInt(st.nextToken());
                    deque.offerFirst(x1);
                    break;
                case "push_back":
                    int x2 = Integer.parseInt(st.nextToken());
                    deque.offerLast(x2);
                    break;
                case "pop_front":
                    System.out.println(deque.isEmpty()? -1 : deque.pollFirst());
                    break;
                case "pop_back":
                    System.out.println(deque.isEmpty()? -1 : deque.pollLast());
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                case "empty":
                    System.out.println(deque.isEmpty()?1:0);
                    break;
                case "front":
                    System.out.println(deque.peekFirst());
                    break;
                case "back":
                    System.out.println(deque.peekLast());
                    break;
                default:
                    break;
            }
        }
    }

    private static void solutionWithArray(int N, String[] commands) {
        int[] arr = new int[2 * N + 1];
        int head = N, tail = N;
        int size = 0;
        for (String command : commands) {
            StringTokenizer st = new StringTokenizer(command);
            String word = st.nextToken();

            switch (word) {
                case "push_front":
                    int x1 = Integer.parseInt(st.nextToken());
                    arr[--head] = x1;
                    size++;
                    break;
                case "push_back":
                    int x2 = Integer.parseInt(st.nextToken());
                    arr[tail++] = x2;
                    size++;
                    break;
                case "pop_front":
                    if (tail - head == 0) {
                        System.out.println(-1);
                        break;
                    }
                    System.out.println(arr[head++]);
                    size--;
                    break;
                case "pop_back":
                    if(tail - head == 0) {
                        System.out.println(-1);
                        break;
                    }
                    System.out.println(arr[tail-1]);
                    tail--;
                    size--;
                    break;
                case "size":
                    System.out.println(size);
                    break;
                case "empty":
                    System.out.println(size == 0?1:0);
                    break;
                case "front":
                    System.out.println(arr[head]);
                    break;
                case "back":
                    System.out.println(arr[tail-1]);
                    break;
                default:
                    break;
            }
        }
    }
}
