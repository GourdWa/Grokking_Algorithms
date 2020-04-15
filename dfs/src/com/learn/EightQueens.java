package com.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author ZixiangHu
 * @create 2020-04-15  14:17
 * @description
 */
public class EightQueens {
    private static int cnt = 0;
    private static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] cols = new boolean[n];
        boolean[] v = new boolean[2 * n];//主对角线即与主对角线平行的对角线上的行减列的值相等
        boolean[] u = new boolean[2 * n];//次对角线即与次对角线平行的对角线上的行加列的值相等
        arr = new int[n];
        bfs(0, cols, v, u);
        System.out.println(cnt);

    }

    private static void bfs(int x, boolean[] cols, boolean[] v, boolean[] u) {
        if (x >= cols.length)
        {
            cnt++;
            if (cnt < 4){
                for (int i = 0; i < arr.length; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }

            return;
        }
        for (int i = 0; i < cols.length; i++) {
            if (!cols[i] && !v[x - i + cols.length] && !u[x + i]) {
                cols[i] = true;
                v[x - i + cols.length] = true;
                u[x + i] = true;
                arr[x] = i + 1;
                bfs(x + 1, cols, v, u);
                cols[i] = false;
                v[x - i + cols.length] = false;
                u[x + i] = false;
            }
        }
    }
}
