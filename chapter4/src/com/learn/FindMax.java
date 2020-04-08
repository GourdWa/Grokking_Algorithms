package com.learn;

import java.util.Arrays;
import java.util.Random;

/**
 * @author ZixiangHu
 * @create 2020-04-08  16:57
 * @description 递归找出数组中的最大值
 */
public class FindMax {
    public static int maxNum(int[] arr, int t) {
        if (t == 0) {
            return arr[0];
        }
        if (arr[t] > maxNum(arr, t - 1)) {
            return arr[t];
        } else {
            return maxNum(arr, t - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = new Random().nextInt(100);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(maxNum(arr, arr.length - 1));
    }
}
