package com.wonseok.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers43162 {
    public static void main(String[] args) {
        int n = 3;
        int[][] graph = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int result = new Programmers43162().solution(n, graph);
    }

    Queue<Integer> queue = new LinkedList<>();
    boolean[] visited = new boolean[201];

    public int solution(int n, int[][] computers) {
        int count = 0;
        queue.offer(0);
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                bfs(i, computers);
                count++;
            }
        }
        System.out.println(count);
        return count;
    }


    private void bfs(int i, int[][] computers) {
        while (!queue.isEmpty()) {
            int start = queue.poll();
            System.out.println(start);
            visited[start] = true;
            for (int j = 0; j < computers.length; j++) {
                if (visited[j] == false) {
                    if (computers[start][j] ==1)
                        queue.offer(j);
                }
            }
        }
    }
}
