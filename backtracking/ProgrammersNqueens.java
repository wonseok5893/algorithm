package com.wonseok.backtracking;

public class ProgrammersNqueens {
    public static void main(String[] args) {
        new ProgrammersNqueens().solution(12);
    }

    static int result;
    static int[] visited;
    static int[] rightVisited;
    static int[] leftVisited;

    public int solution(int n) {
        int[][] map = new int[n][n];

        visited = new int[n + 1];
        leftVisited = new int[2 * n + 1];
        rightVisited = new int[2 * n + 1];

        backtracking(map, 0, n);
        System.out.println(result);
        return result;
    }

    private int backtracking(int[][] map, int step, int n) {
        if (step == n) {
            result++;
            return 0;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == 1) continue;
            if (leftVisited[i + step] == 1 || rightVisited[i - step + map.length - 1] == 1) continue;
            map[step][i] = 1;
            visited[i] = 1;
            leftVisited[i + step] = 1;
            rightVisited[i - step + map.length - 1] = 1;
            backtracking(map, step + 1, n);
            visited[i] = 0;
            leftVisited[i + step] = 0;
            rightVisited[i - step + map.length - 1] = 0;
            map[step][i] = 0;
        }
        return 0;
    }

}
