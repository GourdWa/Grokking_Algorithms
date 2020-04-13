package com.learn;

/**
 * @author ZixiangHu
 * @create 2020-04-12  17:05
 * @description
 */
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[n][m];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = 1;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
            }
        }
        return matrix[n - 1][m - 1];
    }
}

public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(new Solution().uniquePaths(3, 2));
    }
}
