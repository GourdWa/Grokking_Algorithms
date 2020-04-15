package com.learn;

import java.util.Scanner;

/**
 * @author ZixiangHu
 * @create 2020-04-14  17:19
 * @description
 */
public class LittleA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //菜的种类
        int n = sc.nextInt();
        //多少钱
        int m = sc.nextInt();
        //每份菜的价格
        int[] dishes = new int[n];
        int[] dp = new int[m + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            dishes[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            for (int j = m; j >= dishes[i]; j--) {
                dp[j] += dp[j - dishes[i]];
            }
        }
        System.out.println(dp[m]);
    }
}
