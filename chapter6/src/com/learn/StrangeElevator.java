package com.learn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author ZixiangHu
 * @create 2020-04-10  16:23
 * @description
 */
public class StrangeElevator {
    /**
     * @param start 开始楼层
     * @param end   目的楼层
     * @param arr   每层楼能上下的楼层数
     * @return
     */
    public static int solve(int start, int end, int[] arr) {
        //到达每层楼的步数，默认除了起始楼层为0，其他为-1
        int[] step = new int[arr.length];
        //判断哪些楼层已经到达过（true）
        boolean[] vis = new boolean[arr.length];
        Arrays.fill(step, -1);
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        step[start] = 0;
        vis[start] = true;
        while (!queue.isEmpty()) {
            int floor = queue.peek() + arr[queue.peek()];
            if (floor < arr.length && !vis[floor]) {
                step[floor] = step[queue.peek()] + 1;
                vis[floor] = true;
                queue.add(floor);
            }
            floor = queue.peek() - arr[queue.peek()];
            if (floor > 0 && !vis[floor]) {
                step[floor] = step[queue.peek()] + 1;
                vis[floor] = true;
                queue.add(floor);
            }
            queue.poll();
        }
        return step[end];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, start, end;
        n = sc.nextInt();
        start = sc.nextInt();
        end = sc.nextInt();
        int[] button = new int[n];
        for (int i = 0; i < n; i++) {
            button[i] = sc.nextInt();
        }
        int solve = solve(start - 1, end - 1, button);
        System.out.println("一共需要" + solve + "步");
    }
}
