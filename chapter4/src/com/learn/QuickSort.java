package com.learn;

import java.util.Arrays;
import java.util.Random;

/**
 * @author ZixiangHu
 * @create 2020-04-07  22:27
 * @description 快排
 */
public class QuickSort {


    public static void quickSort(int[] arr, int start, int end) {
        if (start > end) {
            return;
        }
        int right = end, left = start, temp;
        while (right > left) {
            while (right > left && arr[right] >= arr[start])
                right--;
            while (right > left && arr[left] <= arr[start])
                left++;
            if (right > left) {
                temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
            }
        }
        temp=arr[right];
        arr[right]=arr[start];
        arr[start]=temp;
        quickSort(arr,start,right-1);
        quickSort(arr,right+1,end);
    }

    public static void main(String[] args) {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(100);
        }
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}

