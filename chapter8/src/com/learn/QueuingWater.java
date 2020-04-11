package com.learn;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ZixiangHu
 * @create 2020-04-11  19:54
 * @description
 */
public class QueuingWater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            arr[i] = arr[i] * 1001 + i;
        }
        Arrays.sort(arr);
        for (int i : arr) {
            System.out.print((i % 1001 + 1) + " ");
        }
        System.out.println();
        //总等待时间，第一个人接水时需要九个人等待，第十个人接水时没人等待
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i] / 1001 * (arr.length - 1 - i);
        }
        System.out.printf("%.2f",sum * 1.0 / arr.length);

    }
}
