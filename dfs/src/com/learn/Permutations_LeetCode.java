package com.learn;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZixiangHu
 * @create 2020-04-15  13:12
 * @description
 */
public class Permutations_LeetCode {
    private List<List<Integer>> res = new ArrayList<>();
    private int[] arr;
    private int len;

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null)
            return null;
        this.len = nums.length;
        boolean[] visited = new boolean[len + 1];
        arr = new int[len];
        dfs(1, visited, nums);
        return res;
    }

    public void dfs(int x, boolean[] visited, int[] nums) {
        if (x > len) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                list.add(arr[i]);
            }
            res.add(list);
            return;
        }
        for (int i = 1; i <= len; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[x - 1] = nums[i - 1];
                dfs(x + 1, visited, nums);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 6, 5};
        List<List<Integer>> permute = new Permutations_LeetCode().permute(arr);
        permute.forEach(System.out::println);
    }
}
