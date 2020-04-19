package com.learn;

import java.util.*;

/**
 * @author ZixiangHu
 * @create 2020-04-18  22:25
 * @description leetcode127 单词接龙
 */
public class WordLadder {
    /**
     * 方法一 超时
     * @param args
     */
   /* public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        //记录字典的长度
        int len = wordList.size();
        //记录从beginWord到字典每个单词的步骤，默认全部为0
        int[] step = new int[len];
        //记录那些单词已经进入过队列，默认全部为false
        boolean[] visited = new boolean[len];
        Deque<String> deque = new ArrayDeque<>();
        deque.add(beginWord);
        while (!deque.isEmpty()) {
            String original = deque.peek();
            if (compareString(original, wordList).size() != 0) {
                List<String> strings = compareString(original, wordList);
                for (int j = 0; j < strings.size(); j++) {
                    if (!visited[wordList.indexOf(strings.get(j))]) {
                        visited[wordList.indexOf(strings.get(j))] = true;
                        deque.add(strings.get(j));
                        if (original.equals(beginWord)) {
                            step[wordList.indexOf(strings.get(j))] = 2;
                        } else {
                            step[wordList.indexOf(strings.get(j))] = step[wordList.indexOf(original)] + 1;
                        }
                    }
                }
            }
            deque.poll();
        }
        return step[wordList.indexOf(endWord)];
    }

    private List<String> compareString(String original, List<String> wordList) {
        List<String> res = new ArrayList<>();
        for (String s : wordList) {
            int diff = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != original.charAt(i)) {
                    diff++;
                    if (diff > 1) {
                        break;
                    }
                }
            }
            if (diff == 1) {
                res.add(s);
            }
        }
        return res;
    }*/

    /**
     * 方法二  效率低
     *
     * @param
     */
   /* public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
            return 0;
        Map<String, Integer> step = new HashMap<>();
        step.put(beginWord, 1);
        Deque<String> deque = new ArrayDeque<>();
        deque.add(beginWord);
        while (!deque.isEmpty()) {
            String original = deque.peek();
            if (compareString(original, wordList, step).size() != 0) {
                List<String> strings = compareString(original, wordList, step);
                for (String string : strings) {
                    deque.add(string);
                    step.put(string, step.get(original) + 1);
                }
            }
            deque.poll();
        }
        return step.getOrDefault(endWord, 0);
    }

    private List<String> compareString(String original, List<String> wordList, Map<String, Integer> step) {
        List<String> res = new ArrayList<>();
        for (String s : wordList) {
            int diff = 0;
            if (step.getOrDefault(s, -1) == -1) {
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) != original.charAt(i)) {
                        diff++;
                        if (diff > 1) {
                            break;
                        }
                    }
                }
            }
            if (diff == 1) {
                res.add(s);
            }
        }
        return res;
    }*/
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        boolean[] visited = new boolean[wordList.size()];
        if (wordList.indexOf(beginWord) != -1) {
            visited[wordList.indexOf(beginWord)] = true;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int cnt = 0;
        while (!queue.isEmpty()) {
            cnt++;
            int size = queue.size();
            while (size-- > 0) {
                String pollString = queue.poll();
                for (int i = 0; i < wordList.size(); i++) {
                    if (visited[i]) {
                        continue;
                    }
                    String s = wordList.get(i);
                    if (!compareString(pollString, s)) {
                        continue;
                    }
                    if (s.equals(endWord)) {
                        return cnt + 1;
                    }
                    visited[i] = true;
                    queue.add(s);
                }
            }
        }
        return 0;
    }

    private boolean compareString(String pollString, String s) {
        int diff = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != pollString.charAt(i))
                diff++;
            if (diff > 1)
                break;
        }
        return diff == 1 ? true : false;
    }

    public static void main(String[] args) {
        String[] strings = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(new WordLadder().ladderLength("hit", "cog", Arrays.asList(strings)));

    }
}
