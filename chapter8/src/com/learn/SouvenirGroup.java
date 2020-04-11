package com.learn;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ZixiangHu
 * @create 2020-04-11  18:28
 * @description
 */

public class SouvenirGroup {

    public static void quickSort(int[] arr, int start, int end) {
        if (end < start) {
            return;
        }
        int left = start;
        int right = end;
        int temp;
        while (right > left) {
            while (right > left && arr[right] >= arr[start])
                right--;
            while (right > left && arr[left] <= arr[start])
                left++;
            temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
        }
        //说明左右两个哨兵相遇了
        temp = arr[start];
        arr[start] = arr[left];
        arr[left] = temp;
        quickSort(arr, start, left - 1);
        quickSort(arr, left + 1, end);
    }

    public static int solve(int[] arr, int w) {
        int cnt = 0;
        int right = arr.length - 1;
        int left = 0;
        while (right >= left) {
            cnt++;
            if (arr[right] + arr[left] <= w) {
                right--;
                left++;
            } else {
                right--;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w, n;
        w = sc.nextInt();
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        quickSort(arr, 0, arr.length - 1);
        System.out.println(solve(arr, w));
    }
}
