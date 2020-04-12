package com.learn;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ZixiangHu
 * @create 2020-04-12  13:45
 * @description
 */
public class Poker {
    public static int solve(int[] poker) {
        int step = 0;
        if (poker == null || poker.length == 1)
            return step;
        int sum = 0;
        for (int i = 0; i < poker.length; i++) {
            sum += poker[i];
        }
        int aver = sum / poker.length;
        for (int i = 0; i < poker.length; i++) {
            if (poker[i] != aver) {
                poker[i + 1] += poker[i] - aver;
                poker[i] = 10;
                step++;
            }

        }
        return step;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] poker = new int[n];
        for (int i = 0; i < n; i++) {
            poker[i] = sc.nextInt();
        }
        System.out.println(solve(poker));
    }
}
