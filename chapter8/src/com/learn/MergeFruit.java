package com.learn;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ZixiangHu
 * @create 2020-04-12  12:10
 * @description
 */
public class MergeFruit {
    public static void quickSort(int[] fruits, int start, int end) {
        if (start > end) {
            return;
        }
        int left = start;
        int right = end;
        int temp;
        while (right > left) {
            while (right > left && fruits[right] >= fruits[start])
                right--;
            while (right > left && fruits[left] <= fruits[start])
                left++;
            temp = fruits[left];
            fruits[left] = fruits[right];
            fruits[right] = temp;
        }
        temp = fruits[left];
        fruits[left] = fruits[start];
        fruits[start] = temp;
        quickSort(fruits, start, left - 1);
        quickSort(fruits, left + 1, end);
    }

    public static int solve(int[] fruits) {
        int strength = 0;
        if (fruits.length < 2 || fruits == null)
            return strength;
        for (int i = 1; i < fruits.length; i++) {
            int temp = fruits[i - 1] + fruits[i];
            strength += temp;
            int pos = i + 1;
            while (pos < fruits.length && fruits[pos] < temp) {
                fruits[pos - 1] = fruits[pos];
                pos++;
            }
            fruits[pos - 1] = temp;
        }
        return strength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] fruits = new int[n];
        for (int i = 0; i < n; i++) {
            fruits[i] = sc.nextInt();
        }
        quickSort(fruits, 0, fruits.length - 1);
        System.out.println(solve(fruits));
    }
}
