package com.lee.algorithm.book;

import java.util.Arrays;

public class Problem25 {

    static void main(String[] args) {
        String[] answer = new String[3];
        answer[0] = preorder(new int[]{1, 2, 3, 4, 5, 6, 7}, 0).trim();
        answer[1] = inorder(new int[]{1, 2, 3, 4, 5, 6, 7}, 0).trim();
        answer[2] = postorder(new int[]{1, 2, 3, 4, 5, 6, 7}, 0).trim();
        System.out.println(Arrays.toString(answer));
    }

    private static String preorder(int[] nodes, int idx) {
        if (idx >= nodes.length) {
            return "";
        }

        return nodes[idx] + " " + preorder(nodes, idx * 2 + 1) + preorder(nodes, idx * 2 + 2);
    }

    private static String inorder(int[] nodes, int idx) {
        if (idx >= nodes.length) {
            return "";
        }

        return inorder(nodes, idx * 2 + 1) + nodes[idx] + " " + inorder(nodes, idx * 2 + 2);
    }

    private static String postorder(int[] nodes, int idx) {
        if (idx >= nodes.length) {
            return "";
        }

        return postorder(nodes, idx * 2 + 1) + postorder(nodes, idx * 2 + 2) + nodes[idx] + " ";
    }
}
