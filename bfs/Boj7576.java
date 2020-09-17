package com.wonseok.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj7576 {
    //토마토 문제
    static int[][] graph;
    static int[][] visited;
    static int[][] distance;
    static StringTokenizer st;
    static Queue<Location> queue =new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int m = info[0];
        int n = info[1];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        graph = new int[n][m];
        visited = new int[n][m];
        distance = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 1) queue.offer(new Location(j, i));
                if (graph[i][j] == 0) visited[i][j] = -1;
            }
        }

        //1일차
        loop:
        while (!queue.isEmpty()) {
            Location nowLocation = queue.poll();
            for (int k = 0; k < 4; k++) {
                int px = nowLocation.getX() + dx[k];
                int py = nowLocation.getU() + dy[k];
                if (px < 0 || py < 0 || px >= m || py >= n) continue;
                else {
                    if (visited[py][px] >= 0) continue;
                    visited[py][px] = visited[nowLocation.getU()][nowLocation.getX()]+1;
                    queue.offer(new Location(px, py));
                }
            }
        }
        int answer = 0;
        if(check(graph)) System.out.println(max(answer));
            else System.out.println(-1);
/*
        for (int[] ints : graph) {
            for (int e : ints) {
                System.out.print(e);
            }
            System.out.println();
        }
*/

}

    private static int max(int answer) {
        int max = answer;
        for (int[] ints : visited) {
            for (int e : ints) {
                if(e>max)
                    max = e;
            }
        }
        return max;
    }

    static boolean check(int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (visited[i][j] == -1)
                    return false;
            }
        }
        return true;
    }

static class Location {
    int x;
    int u;

    public int getX() {
        return x;
    }

    public int getU() {
        return u;
    }

    public Location(int x, int u) {
        this.x = x;
        this.u = u;
    }
}
}
