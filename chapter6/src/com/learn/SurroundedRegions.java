package com.learn;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author ZixiangHu
 * @create 2020-04-10  15:31
 * @description
 */
class Solution {
    public void solve(char[][] board) {
        if (board==null || board.length==0)
            return;
        int[][] coordinate = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        //构建一个临时数组，在相比原数组在外层添加一层'O'
        char[][] boardTemp = new char[board.length + 2][board[0].length + 2];
        boolean[][] vis = new boolean[board.length + 2][board[0].length + 2];
        for (int i = 0; i < boardTemp.length; i++) {
            for (int j = 0; j < boardTemp[0].length; j++) {
                if (i == 0 || i == boardTemp.length - 1 || j == 0 || j == boardTemp[0].length - 1)
                    boardTemp[i][j] = 'O';
                else
                    boardTemp[i][j] = board[i - 1][j - 1];
            }
        }
        Queue<Integer> xQueue = new ArrayDeque<>();
        Queue<Integer> yQueue = new ArrayDeque<>();
        xQueue.add(0);
        yQueue.add(0);
        vis[0][0] = true;
        while (!xQueue.isEmpty()) {
            for (int i = 0; i < 4; i++) {
                int dx = xQueue.peek() + coordinate[i][0];
                int dy = yQueue.peek() + coordinate[i][1];
                if (dx >= 0 && dx < boardTemp.length && dy >= 0 && dy < boardTemp[0].length && boardTemp[dx][dy] == 'O' && !vis[dx][dy]) {
                    xQueue.add(dx);
                    yQueue.add(dy);
                    vis[dx][dy] = true;
                }
            }
            xQueue.poll();
            yQueue.poll();
        }
        for (int i = 1; i < boardTemp.length - 1; i++) {
            for (int j = 1; j < boardTemp[0].length - 1; j++) {
                if (boardTemp[i][j] == 'O' && !vis[i][j]) {
                    board[i - 1][j - 1] = 'X';
                }
            }
        }
    }
}

public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        new Solution().solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
