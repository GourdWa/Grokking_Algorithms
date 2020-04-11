package com.learn;

import java.util.Arrays;

/**
 * @author ZixiangHu
 * @create 2020-04-11  11:25
 * @description
 */
public class DijkstraTest02 {
    public static void main(String[] args) {
        final int INF = Integer.MAX_VALUE;
        int matrix[][] = {
                {0, 12, INF, INF, INF, 16, 14},
                {12, 0, 10, INF, INF, 7, INF},
                {INF, 10, 0, 3, 5, 6, INF},
                {INF, INF, 3, 0, 4, INF, INF},
                {INF, INF, 5, 4, 0, 2, 8},
                {16, 7, 6, INF, 2, 0, 9},
                {14, INF, INF, INF, 8, 9, 0}};

        int[] dis = new DJS(matrix.length, matrix).getDis(3);
        System.out.println(Arrays.toString(dis));
    }
}

class DJS2 {
    //节点的数量
    private int nodeNum;
    //邻接矩阵
    private int[][] matrix;
    //起始节点到每个节点的距离
    private int[] dis;
    //代表当前节点是否被访问，true代表被访问
    private boolean[] isVisit;

    public DJS2(int nodeNum, int[][] matrix) {
        this.nodeNum = nodeNum;
        this.matrix = matrix;
        this.dis = new int[nodeNum];
        this.isVisit = new boolean[nodeNum];
    }

    public int[] getDis(int startNode) {
        //初始化各个节点与起始节点的距离
        for (int i = 0; i < nodeNum; i++) {
            dis[i] = matrix[startNode][i];
        }
        isVisit[startNode] = true;
        int cnt = 1;
        while (cnt != nodeNum) {
            //找出当前未被访问过且距离起始节点最近的节点
            int t = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < nodeNum; i++) {
                if (!isVisit[i] && dis[i] < min) {
                    min = dis[i];
                    //记录未被访问且最近的节点
                    t = i;
                }
            }
            isVisit[t] = true;
            cnt += 1;
            //遍历与t节点相通的节点。t节点是未被访问过中与起始节点最近的节点
            for (int i = 0; i < nodeNum; i++) {
                //i节点与t节点相通，未被访问且t节点到i节点加t节点到起始节点的距离小于i节点到起始节点的距离，则更新
                if (!isVisit[i] && matrix[t][i] != Integer.MAX_VALUE && matrix[t][i] + dis[t] < dis[i]) {
                    dis[i] = matrix[t][i] + dis[t];
                }
            }
        }

        return dis;
    }
}
