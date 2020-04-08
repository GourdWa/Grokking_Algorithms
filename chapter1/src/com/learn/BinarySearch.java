package com.learn;

/**
 * @author ZixiangHu
 * @create 2020-04-03  19:50
 * @description
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] ls = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(binarySerch(ls,10));
    }

    public static int binarySerch(int[] list, int item) {
        int low = 0;
        int high = list.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (list[mid] == item) {
                return mid;
            } else if (list[mid] < item) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
