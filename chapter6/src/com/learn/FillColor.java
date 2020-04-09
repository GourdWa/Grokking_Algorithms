package com.learn;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author ZixiangHu
 * @create 2020-04-09  18:50
 * @description 填涂颜色
 */
public class FillColor {

    public static void fillColor(int[][] arr) {
//        一个点的上下左右四个方位
        int[] xx = {0, 1, 0, -1};
        int[] yy = {1, 0, -1, 0};
//     记录那些坐标被访问，true代表被访问
        boolean[][] vis = new boolean[arr.length][arr.length];
        Queue<Integer> x = new ArrayDeque<>();
        Queue<Integer> y = new ArrayDeque<>();
        x.add(0);
        y.add(0);
        vis[0][0] = true;
        while (!x.isEmpty()) {
            for (int i = 0; i < 4; i++) {
                int dx = x.peek() + xx[i];
                int dy = y.peek() + yy[i];
                if (dx >= 0 && dx < arr.length && dy >= 0 && dy < arr.length && !vis[dx][dy]) {
                    if (arr[dx][dy] == 0) {
                        vis[dx][dy] = true;
                        x.add(dx);
                        y.add(dy);
                    }
                }
            }
            x.poll();
            y.poll();
        }
        for (int i = 1; i <= arr.length - 1; i++) {
            for (int j = 1; j <= arr.length - 1; j++) {
                if (!vis[i][j] && arr[i][j] == 0) {
                    arr[i][j] = 2;
                }
            }
        }
    }


    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
//        填充一层外围
        int[][] arr = new int[n + 2][n + 2];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        fillColor(arr);
        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length - 1; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
