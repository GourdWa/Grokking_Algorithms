package com.learn;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ZixiangHu
 * @create 2020-04-12  11:33
 * @description
 */
class Line implements Comparable<Line>{
    private int start;
    private int end;

    public Line() {
    }

    public Line(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    @Override
    public String toString() {
        return "Line{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    @Override
    public int compareTo(Line o) {
        return this.getEnd() - o.getEnd();
    }
}

public class LineProblem {
    public static int solve(Line[] lines) {
        int cnt = 1;
        int cur = 0;
        for (int i = 1; i < lines.length; i++) {
            if (lines[i].getStart() >= lines[cur].getEnd()){
                cnt++;
                cur = i;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Line[] lines = new Line[n];
        for (int i = 0; i < n; i++) {
            lines[i] = new Line(sc.nextInt(),sc.nextInt());
        }
        Arrays.sort(lines);
        System.out.println(solve(lines));
    }
}
