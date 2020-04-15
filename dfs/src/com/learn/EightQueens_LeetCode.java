package com.learn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZixiangHu
 * @create 2020-04-15  20:27
 * @description
 */
public class EightQueens_LeetCode {
    /**
     * 在主对角线上以及平行主对角线的元素的坐标之差是一样的
     * 在副对角线上以及平行副对角线的元素的坐标之和是一样的
     * 当遍历了一个点之后，应该将其所在的列，与主对角线和副对角线的平行的元素全部设置为true表示已经访问过了
     */
    private boolean[] cols;//列
    private boolean[] v;//主对角线及平行主对角线
    private boolean[] u;//副对角线及平行副对角线
    private int[] arr;//记录每种情况
    StringBuilder original = new StringBuilder(".");
    List<List<String>> lists = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        cols = new boolean[n];
        v = new boolean[2 * n];
        u = new boolean[2 * n];
        arr = new int[n];
        for (int i = 1; i < n; i++) {
            original.append(".");
        }
        //表示从第0行开始
        dfs(0);
        return lists;
    }

    private void dfs(int x) {
        if (x >= cols.length) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                StringBuilder sb = new StringBuilder(original.toString());
                sb.setCharAt(arr[i],'Q');
                list.add(sb.toString());
            }
            lists.add(list);
            return;
        }
        for (int i = 0; i < cols.length; i++) {
            //x代表行，i代表列，x - i + cols.length是为了将其值映射为正
            if (!cols[i] && !v[x - i + cols.length] && !u[x + i]) {
                cols[i] = true;
                v[x - i + cols.length] = true;
                u[x + i] = true;
                //代表第x行选第几列放置皇后
                arr[x] = i;
                //深搜索下一行
                dfs(x + 1);
                //回溯
                cols[i] = false;
                v[x - i + cols.length] = false;
                u[x + i] = false;
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> lists = new EightQueens_LeetCode().solveNQueens(4);
        System.out.println(lists.size());
        System.out.println(lists);
    }
}
