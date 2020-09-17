package com.wonseok.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Boj7576_2 {
    //토마토 문제 시간초과 !!
    static int[][] graph;
    static int[][] visited;
    static List<Location> add;
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

        for (int i = 0; i < n; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        // 그래프 초기화 끝
        int days = 0;
        //1일차
        loop:
        while (check(graph) == false) {
            add = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    //graph가 1인걸로 시작
                    if (graph[i][j] == 0 || graph[i][j] == -1 || visited[i][j] == 1) continue;
                    visited[i][j] = 1;
                    for (int k = 0; k < 4; k++) {
                        int px = j + dx[k];
                        int py = i + dy[k];
                        if (px < 0 || py < 0 || px >= m || py >= n) continue;
                        else {
                            if (graph[py][px] == -1) continue;
                            if (visited[py][px] == 1) continue;
                            add.add(new Location(px,py));
                        }
                    }
                }
            }
            if(add.size()==0)
                break loop;
            for (Location location : add) {
                graph[location.getU()][location.getX()]=1;
            }
            days++;
        }
        if (check(graph)) System.out.println(days);
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

    static boolean check(int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (graph[i][j] == 0)
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
