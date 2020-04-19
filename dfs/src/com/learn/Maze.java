package com.learn;

import java.util.Scanner;

/**
 * @author ZixiangHu
 * @create 2020-04-18  9:25
 * @description
 */
public class Maze {
    private static int n, m, t, sx, sy, fx, fy;
    private static int[][] pos;
    private static boolean[][] visited;
    private static int cnt = 0;
    private static int[] xx = {-1, 0, 1, 0};
    private static int[] yy = {0, -1, 0, 1};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        t = sc.nextInt();
        sx = sc.nextInt();
        sy = sc.nextInt();
        fx = sc.nextInt();
        fy = sc.nextInt();
        //存储障碍的位置
        pos = new int[t][2];
        for (int i = 0; i < t; i++) {
            pos[i][0] = sc.nextInt();
            pos[i][1] = sc.nextInt();
        }
        //让行数和列数从下标1开始
        visited = new boolean[n + 1][m + 1];
        visited[sx][sy] = true;
        dfs(sx, sy);
        System.out.println(cnt);
    }

    private static void dfs(int sx, int sy) {
        if (sx == fx && sy == fy) {
            cnt++;
            return;
        }
        for (int i = 0; i < 4; i++) {
            boolean flag = false;
            int dx = sx + xx[i];
            int dy = sy + yy[i];
            for (int j = 0; j < pos.length; j++) {
                if (pos[j][0] == dx && pos[j][1] == dy) {
                    flag = true;
                    break;
                }
            }
            if (!flag && dx >= 1 && dy >= 1 && dx <= n && dy <= m && !visited[dx][dy]) {
                visited[dx][dy] = true;
                dfs(dx, dy);
                //回溯
                visited[dx][dy] = false;
            }
        }

    }
}
