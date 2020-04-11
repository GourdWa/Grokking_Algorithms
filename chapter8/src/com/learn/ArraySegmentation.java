package com.learn;

import java.util.Scanner;

/**
 * @author ZixiangHu
 * @create 2020-04-11  17:52
 * @description 数列分段
 */
class Solution {
    public int solve(int m, int[] arr) {
        int cnt = 1;
        int n = 0;
        int s = 0;
        while (n < arr.length) {
            //说明需要重新开辟一段
            if (arr[n] + s > m) {
                s = arr[n];
                cnt++;
            } else {
                //可以继续存放在这一段
                s += arr[n];
            }
            n += 1;
        }
        return cnt;
    }
}

public class ArraySegmentation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, n;
        n = sc.nextInt();
        m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(new Solution().solve(m, arr));
    }
}
