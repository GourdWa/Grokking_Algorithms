package com.learn;

import java.util.Scanner;

/**
 * @author ZixiangHu
 * @create 2020-04-15  12:33
 * @description
 */
public class Permutation {
    private int n;
    private int[] arr;

    public Permutation(int n) {
        this.arr = new int[n + 1];
        this.n = n;
    }

    public void dfs(int x,boolean[] visited) {
        if (x > n) {
            for (int i = 1; i <= n; i++) {
                System.out.print("    " + arr[i]);
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[x] = i;
                dfs(x + 1,visited);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int in = sc.nextInt();
        boolean[] visited = new boolean[in + 1];
        Permutation permutation = new Permutation(in);
        permutation.dfs(1,visited);
    }
}
