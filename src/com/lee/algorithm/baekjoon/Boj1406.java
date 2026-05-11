package com.lee.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

/**
 * 문제
 * 한 줄로 된 간단한 에디터를 구현하려고 한다. 이 편집기는 영어 소문자만을 기록할 수 있는 편집기로, 최대 600,000글자까지 입력할 수 있다.
 * 이 편집기에는 '커서'라는 것이 있는데, 커서는 문장의 맨 앞(첫 번째 문자의 왼쪽), 문장의 맨 뒤(마지막 문자의 오른쪽), 또는 문장 중간 임의의 곳(모든 연속된 두 문자 사이)에 위치할 수 있다. 즉 길이가 L인 문자열이 현재 편집기에 입력되어 있으면, 커서가 위치할 수 있는 곳은 L+1가지 경우가 있다.
 * 이 편집기가 지원하는 명령어는 다음과 같다.
 * 초기에 편집기에 입력되어 있는 문자열이 주어지고, 그 이후 입력한 명령어가 차례로 주어졌을 때, 모든 명령어를 수행하고 난 후 편집기에 입력되어 있는 문자열을 구하는 프로그램을 작성하시오. 단, 명령어가 수행되기 전에 커서는 문장의 맨 뒤에 위치하고 있다고 한다.
 *
 * L	커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시)
 * D	커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시)
 * B	커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시)
 * P $	$이라는 문자를 커서 왼쪽에 추가함
 *
 * 입력
 * 첫째 줄에는 초기에 편집기에 입력되어 있는 문자열이 주어진다. 이 문자열은 길이가 N이고, 영어 소문자로만 이루어져 있으며, 길이는 100,000을 넘지 않는다. 둘째 줄에는 입력할 명령어의 개수를 나타내는 정수 M(1 ≤ M ≤ 500,000)이 주어진다. 셋째 줄부터 M개의 줄에 걸쳐 입력할 명령어가 순서대로 주어진다. 명령어는 위의 네 가지 중 하나의 형태로만 주어진다.
 *
 * 출력
 * 첫째 줄에 모든 명령어를 수행하고 난 후 편집기에 입력되어 있는 문자열을 출력한다.
 *
 * abcd
 * 3
 * P x
 * L
 * P y
 * abcdyx
 */
public class Boj1406 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());

        String[] commands = new String[n];
        for (int i = 0; i < n; i++) {
            commands[i] = br.readLine();
        }

        System.out.println("Stack 이용");
        System.out.println(solveWithStack(str, commands));
        System.out.println("LinkedList 이용");
        System.out.println(solveWithLinkedList(str, commands));
    }

    /**
     * Stack을 이용한 방식
     * solveWithTwoStacks() - 기존 로직
     *   stack  → 커서 왼쪽 문자들
     *   temp   → 커서 오른쪽 문자들
     *   - L: stack → temp로 이동
     *   - D: temp → stack으로 이동
     *   - B: stack.pop()
     *   - P: stack.push()
     */
    private static String solveWithStack(String str, String[] commands) {
        Deque<Character> stack = new ArrayDeque<>();
        Deque<Character> temp = new ArrayDeque<>();

        for (char c : str.toCharArray()) {
            stack.push(c);
        }

        for (String line : commands) {
            StringTokenizer st = new StringTokenizer(line);
            String cmd = st.nextToken();

            switch (cmd) {
                case "L":
                    if (!stack.isEmpty()) temp.push(stack.pop());
                    break;
                case "D":
                    if (!temp.isEmpty()) stack.push(temp.pop());
                    break;
                case "B":
                    if (!stack.isEmpty()) stack.pop();
                    break;
                case "P":
                    stack.push(st.nextToken().charAt(0));
                    break;
            }
        }

        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }

        StringBuilder sb = new StringBuilder();
        Iterator<Character> it = stack.descendingIterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        return sb.toString();
    }

    // 방법 2:

    /**
     * LinkedList + ListIterator를 이용한 방식
     * solveWithLinkedList() - LinkedList 방식
     *   cursor(ListIterator) → 실제 커서 위치를 그대로 표현
     *   - L: cursor.previous()
     *   - D: cursor.next()
     *   - B: cursor.previous() → cursor.remove()
     *   - P: cursor.add()
     */
    private static String solveWithLinkedList(String str, String[] commands) {
        LinkedList<Character> list = new LinkedList<>();

        for (char c : str.toCharArray()) {
            list.add(c);
        }

        ListIterator<Character> cursor = list.listIterator(list.size());

        for (String line : commands) {
            StringTokenizer st = new StringTokenizer(line);
            String cmd = st.nextToken();

            switch (cmd) {
                case "L":
                    if (cursor.hasPrevious()) cursor.previous();
                    break;
                case "D":
                    if (cursor.hasNext()) cursor.next();
                    break;
                case "B":
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                        cursor.remove();
                    }
                    break;
                case "P":
                    cursor.add(st.nextToken().charAt(0));
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }
        return sb.toString();
    }
}
