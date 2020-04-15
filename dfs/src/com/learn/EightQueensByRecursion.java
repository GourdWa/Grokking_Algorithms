package com.learn;

/**
 * @author ZixiangHu
 * @create 2020-04-15  21:19
 * @description
 */
public class EightQueensByRecursion {
    private int cnt = 0;
    //queenPos[0]代表第一行皇后摆放的列的值
    private int[] queenPos;

    public int totalNQueens(int n) {
        queenPos = new int[n];
        nQuenns(0);
        return cnt;
    }

    /**
     * 代表前x-1行的皇后的位置已经摆放完毕，现在摆放第x行的皇后
     *
     * @param x
     */

    private void nQuenns(int x) {
        if (x == queenPos.length) {
            cnt++;
            return;
        }
        //第x行皇后能够摆放的列
        int j;
        int i;
        for (i = 0; i < queenPos.length; i++) {
            //考察第j行皇后摆放的位置
            for (j = 0; j < x; j++) {
                //是否在对角线或者同一列
                if (queenPos[j] == i || Math.abs(x - j) == Math.abs(i - queenPos[j])) {
                    break;
                }
            }
            //说明第x行的皇后可以摆放在第i列
            if (j == x){
                queenPos[x] = i;
                nQuenns(x+1);
            }
        }
    }

    public static void main(String[] args) {

    }
}
