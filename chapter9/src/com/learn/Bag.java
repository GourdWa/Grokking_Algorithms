package com.learn;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @author ZixiangHu
 * @create 2020-04-13  16:00
 * @description
 */
public class Bag {
    //背包问题利用二维数组解决
    public static void bagMethod1() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int m = sc.nextInt();

        int[][] matrix = new int[m][t + 1];
        int[][] arr = new int[m][2];
        for (int i = 0; i < m; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();

        }

        for (int i = arr[0][0]; i <= t; i++) {
            matrix[0][i] = arr[0][1];
        }
        int maxValue = matrix[0][t];
        for (int i = 1; i < m; i++) {
            for (int j = 0; j <= t; j++) {
                matrix[i][j] = matrix[i - 1][j];
                if (arr[i][0] <= j) {
                    matrix[i][j] = matrix[i - 1][j - arr[i][0]] + arr[i][1] > matrix[i - 1][j] ?
                            matrix[i - 1][j - arr[i][0]] + arr[i][1] : matrix[i - 1][j];
                    maxValue = maxValue > matrix[i][j] ? maxValue : matrix[i][j];
                }
            }
        }
        System.out.println(maxValue);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int m = sc.nextInt();
        int[] price = new int[m];
        int[] weight = new int[m];
        //dp[1]代表背包容量为1时能装的物品的最大价值，dp[t]代表背包容量为t时能装的物品的最大价值
        int[] dp = new int[t+1];
        for (int i = 0; i < m; i++) {
            weight[i] = sc.nextInt();
            price[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            for (int j = t; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j - weight[i]] + price[i], dp[j]);
            }
        }
        System.out.println(dp[t]);
    }
}
