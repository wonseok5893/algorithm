package com.wonseok.bfs;

import java.lang.reflect.Array;
import java.util.*;

public class Programmers43163 {
    static int[] visited;

    public static void main(String[] args) {
        Programmers43163 ps = new Programmers43163();
        ps.solution("hit","cog",
                new String[]{"hot", "dot", "dog", "lot", "log", "cog"});

    }

    public int solution(String begin, String target, String[] words) {
        visited = new int[words.length];
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = possibleWords(begin, words);
        for (Integer e : list) {
            queue.offer(e);
            visited[e] = 1;
        }
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            String word = words[poll];
            ArrayList<Integer> list1 = possibleWords(word, words);
            for (Integer e : list1) {
                queue.offer(e);
                visited[e] = visited[poll] + 1;
            }

        }
        int ansIdx = Arrays.asList(words).indexOf(target);
        if (ansIdx == -1) return 0;
        else return visited[ansIdx];

    }

    private ArrayList<Integer> possibleWords(String begin, String[] words) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i <words.length; i++) {
            int count = 0;
            if (visited[i] != 0) continue;
            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) != words[i].charAt(j)) {
                    count++;
                }
            }
            if (count == 1) list.add(i);
        }
        return list;
    }

}
