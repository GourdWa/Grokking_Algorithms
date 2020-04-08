package com.learn;

/**
 * @author ZixiangHu
 * @create 2020-04-08  16:37
 * @description 递归实现数组求和
 */
public class Sum {
    public static int recursionSum(int arr[], int i) {
        if (i == arr.length - 1) {
            return arr[i];
        }
        return arr[i] + recursionSum(arr, i + 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = i;
        }
        System.out.println(recursionSum(arr,0));
    }
}
