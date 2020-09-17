package com.wonseok.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.*;

public class Boj1926 {
    static int[][] visited = new int[501][501];
    static int[][] graph = new int[501][501];
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    static Queue<Location> queue = new LinkedList<>();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //그래프 작업 끝
        int count = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (check(i, j)) {
                    int maxResult = bfs(i, j);
                    if (max < maxResult)
                        max = maxResult;
                    count++;
                } else continue;
            }
        }
        System.out.println(count);
        System.out.println(max);
    }

    private static boolean check(int i, int j) {
        if (visited[i][j] == 0 && graph[i][j] == 1) return true;
        else return false;
    }

    private static int bfs(int i, int j) {
        queue.offer(new Location(j, i));
        visited[i][j] = 1;
        int count = 1;
        while (!queue.isEmpty()) {
            Location now = queue.poll();
            for (int k = 0; k < 4; k++) {
                int py = now.getY() + dy[k];
                int px = now.getX() + dx[k];
                if (px >= 0 && py >= 0 && px < graph[0].length && py < graph.length) {
                    if (check(py,px)) {
                        queue.offer(new Location(px, py));
                        visited[py][px] = 1;
                        count++;
                    } else continue;
                } else continue;
            }
        }
        return count;
    }

    private static class Location {
        int x;
        int y;

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
