package com.learn;

import java.util.Scanner;

/**
 * @author ZixiangHu
 * @create 2020-04-19  11:13
 * @description 洛谷单词接龙 1706
 */
public class WordLadder2 {
    private static int n;
    private static String[] words;
    private static String startChar;
    private static int len = 0;
    private static int[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visited = new int[n];
        words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }
        startChar = sc.next();
        for (int i = 0; i < n; i++) {
            if (words[i].startsWith(startChar)) {
                visited[i]++;
                dfs(words[i], words[i].length());
                visited[i]--;
            }
        }
        System.out.println(len);
    }

    private static void dfs(String word, int length) {
        len = Math.max(length, len);
        for (int i = 0; i < n; i++) {
            int p = 1;
            int la = word.length(), lb = words[i].length();
            while (p < Math.min(word.length(), words[i].length())) {
                if (word.substring(la - p).equals(words[i].substring(0, p)) && visited[i] < 2) {
                    visited[i] += 1;
                    dfs(words[i], length + lb - p);
                    visited[i] -= 1;
                    break;
                }
                p += 1;
            }
        }
    }
}
