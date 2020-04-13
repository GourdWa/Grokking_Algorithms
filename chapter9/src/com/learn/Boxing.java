package com.learn;

import java.util.Scanner;

/**
 * @author ZixiangHu
 * @create 2020-04-13  20:14
 * @description
 */
public class Boxing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //最多能装V
        int v = sc.nextInt();
        //n个物品
        int n = sc.nextInt();
        int[] weight = new int[n];
        int[] dp = new int[v + 1];
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            for (int j = v; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + weight[i]);
//                dp[j] = Math.max(dp[j - weight[i]] + price[i], dp[j]);
            }
        }
        System.out.println(v - dp[v]);
    }
}
