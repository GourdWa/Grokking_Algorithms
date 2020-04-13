package com.learn;

/**
 * @author ZixiangHu
 * @create 2020-04-13  19:17
 * @description
 */
class SolveStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int len = prices.length;
        int profit = prices[1] - prices[0] > 0 ? prices[1] - prices[0] : 0;
        int min = Math.min(prices[1], prices[0]);
        for (int i = 2; i < len; i++) {
            profit = profit > prices[i] - min ? profit : prices[i] - min;
            min = Math.min(prices[i], min);
        }
        return profit;
    }
}

public class Stock {
    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        System.out.println(new SolveStock().maxProfit(prices));
    }
}
