package com.learn;

import java.util.Arrays;
import java.util.Random;

/**
 * @author ZixiangHu
 * @create 2020-04-03  20:21
 * @description 选择排序
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] ls = new int[9];
        for (int i = 0; i < ls.length; i++) {
            ls[i] = new Random().nextInt(100);
        }
        System.out.println("排序之前：" + Arrays.toString(ls));
        selection(ls);
        System.out.println("排序之后面：" + Arrays.toString(ls));
    }

    public static void selection(int[] list) {
        int len = list.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (list[i] > list[j]) {
                    int temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
    }
}
