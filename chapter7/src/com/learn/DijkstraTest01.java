package com.learn;

import java.util.Arrays;
import java.util.GregorianCalendar;

/**
 * @author ZixiangHu
 * @create 2020-04-11  11:25
 * @description
 */
public class DijkstraTest01 {
    public static void main(String[] args) {
//        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F'};
        final int INF = Integer.MAX_VALUE;
/*        int matrix[][] = {
                {0, 12, INF, INF, INF, 16, 14},
                {12, 0, 10, INF, INF, 7, INF},
                {INF, 10, 0, 3, 5, 6, INF},
                {INF, INF, 3, 0, 4, INF, INF},
                {INF, INF, 5, 4, 0, 2, 8},
                {16, 7, 6, INF, 2, 0, 9},
                {14, INF, INF, INF, 8, 9, 0}};*/

        int matrix[][] = {
                {0, 0, 5, INF, INF, INF},
                {0, 0, INF, 30, 35, INF},
                {5, INF, 0, 15, 20, INF},
                {INF, 30, 15, 0, INF, 20},
                {INF, 30, 20, INF, 0, 10},
                {INF, INF, INF, 20, 10, 0}};
        int[] dis = new DJS(matrix.length, matrix).getDis(0);
        System.out.println(Arrays.toString(dis));
    }
}

class DJS {
    //节点的数量
    private int nodeNum;
    //邻接矩阵
    private int[][] matrix;
    //起始节点到每个节点的距离
    private int[] dis;
    //代表当前节点是否被访问，true代表被访问
    private boolean[] isVisit;
    //存储路径
    private int[] preNode;

    public DJS(int nodeNum, int[][] matrix) {
        this.nodeNum = nodeNum;
        this.matrix = matrix;
        this.dis = new int[nodeNum];
        this.isVisit = new boolean[nodeNum];
        this.preNode = new int[nodeNum];
        Arrays.fill(preNode, -1);
    }

    public int[] getDis(int startNode) {
        //起始节点设置为访问过
        isVisit[startNode] = true;
        //记录起始节点到第一步能到达的各个节点的距离，不能直接到达的节点距离为无穷大
        for (int i = 0; i < nodeNum; i++) {
            //初始化起始节点到各个节点的距离
            dis[i] = matrix[startNode][i];
            //找出起始节点能直接访问的节点，将这些节点的父节点设置为起始节点
            if (matrix[startNode][i] < Integer.MAX_VALUE && startNode != i) {
                preNode[i] = startNode;
            }
        }
        int cnt = 1;//记录当前遍历过的节点数，没遍历一个节点，cnt加1，遍历完之后结束循环。刚开始只有起始点被遍历
        while (cnt != nodeNum) {
            int t = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < nodeNum; i++) {
                if (!isVisit[i] && dis[i] < min) {
                    min = dis[i];
                    t = i;
                }
            }
            isVisit[t] = true;
            cnt++;
            for (int i = 0; i < nodeNum; i++) {
                if (!isVisit[i] && matrix[t][i] != Integer.MAX_VALUE && matrix[t][i] + dis[t] < dis[i]) {
                    preNode[i] = t;
                    dis[i] = dis[t] + matrix[t][i];
                }
            }
        }
        for (int i = 0; i < nodeNum; i++) {
            int cur = i;
            System.out.println("节点" + i + "的路径是:");
            while (preNode[cur] != -1) {
                System.out.print(preNode[cur] + " ");
                cur = preNode[cur];
            }
            System.out.println();
        }
        return dis;
    }
}
