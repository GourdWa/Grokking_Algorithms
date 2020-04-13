package com.learn;

import java.util.*;

/**
 * @author ZixiangHu
 * @create 2020-04-12  20:27
 * @description
 */
public class DigMine {
    public static void dg(int[] pre, int i) {
        if (i == -1)
            return;
        dg(pre, pre[i]);
        System.out.print(i + 1 + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] dp = new int[n];
        int[] pre = new int[n];
        Arrays.fill(pre, -1);
        int[][] m = new int[n - 1][n - 1];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            dp[i] = arr[i];
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                m[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (m[i][j] == 1 && dp[j + i + 1] < dp[i] + arr[i + j + 1]) {
                    dp[j + 1 + i] = dp[i] + arr[j + i + 1];
                    pre[j + i + 1] = i;
                }
            }
        }
        int max = -1;
        int no = -1;
        for (int i = 0; i < dp.length; i++) {
            if (max < dp[i]) {
                max = dp[i];
                no = i;
            }
        }

        dg(pre, no);
/*        Stack<Integer> stack = new Stack<>();
        stack.add(no + 1);
        while (pre[no] != -1) {
            int i = pre[no];
            stack.push(i + 1);
            no = i;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }*/
        System.out.println();
        System.out.println(max);
    }
}
