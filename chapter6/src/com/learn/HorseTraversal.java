package com.learn;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author ZixiangHu
 * @create 2020-04-09  20:06
 * @description 马的遍历问题
 */

class Node {
    private int x;
    private int y;
    private int count;

    public Node() {
    }

    public Node(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Node{" +
                "x=" + x +
                ", y=" + y +
                ", count=" + count +
                '}';
    }
}

public class HorseTraversal {
    public static void horseTraversal(int[][] arr, int sx, int sy) {
        int[] xx = {1, 1, 2, 2, -1, -1, -2, -2};
        int[] yy = {2, -2, 1, -1, 2, -2, 1, -1};
        //也可以用三个队列代替
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(sx, sy, 0));
        while (!queue.isEmpty()) {
            for (int i = 0; i < 8; i++) {
                int dx = queue.peek().getX() + xx[i];
                int dy = queue.peek().getY() + yy[i];
                if (dx >= 0 && dx < arr.length && dy >= 0 && dy < arr[0].length && arr[dx][dy] == -1) {
                    queue.add(new Node(dx, dy, queue.peek().getCount() + 1));
                    arr[dx][dy] = queue.peek().getCount() + 1;
                }
            }
            queue.poll();
        }

    }

    public static void main(String[] args) {
        int n, m;
        int sx, sy;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sx = sc.nextInt();
        sy = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = -1;
            }
        }
        arr[sx - 1][sy - 1] = 0;
        horseTraversal(arr, sx - 1, sy - 1);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}
