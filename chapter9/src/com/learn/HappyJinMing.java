package com.learn;

import java.util.Scanner;

/**
 * @author ZixiangHu
 * @create 2020-04-13  19:40
 * @description
 */
public class HappyJinMing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //总钱数
        int n = sc.nextInt();
        //商品数目
        int m = sc.nextInt();
        int[] price = new int[m];
        int[] importance = new int[m];
        int[] res = new int[n + 1];
        for (int i = 0; i < m; i++) {
            price[i] = sc.nextInt();
            importance[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            for (int j = n; j >= price[i]; j--) {
                if (res[j] < price[i]*importance[i] + res[j - price[i]]){
                    res[j] =  price[i]*importance[i] + res[j - price[i]];
                }
            }
        }
        System.out.println(res[n]);
    }
}
