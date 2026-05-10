package com.lee.algorithm.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice05 {

    public static void main(String[] args) {
    }

    // 기존 방식: for 루프
    private static void insert(int idx, int num, int[] arr) {
        int length = arr.length;
        for (int i = length - 1; i > idx; i--) {
            arr[i] = arr[i - 1];
        }
        arr[idx] = num;
    }

    private static void erase(int idx, int[] arr) {
        int length = arr.length - 1;
        for (int i = idx; i < length; i++) {
            arr[i] = arr[i + 1];
        }
    }

    // System.arraycopy 버전
    private static void insertWithArraycopy(int idx, int num, int[] arr) {
        System.arraycopy(arr, idx, arr, idx + 1, arr.length - idx - 1);
        arr[idx] = num;
    }

    private static void eraseWithArraycopy(int idx, int[] arr) {
        System.arraycopy(arr, idx + 1, arr, idx, arr.length - idx - 1);
    }

    // ArrayList 버전
    private static List<Integer> insertWithArrayList(int idx, int num, List<Integer> list) {
        list.add(idx, num);
        return list;
    }

    private static List<Integer> eraseWithArrayList(int idx, List<Integer> list) {
        list.remove(idx);
        return list;
    }
}
