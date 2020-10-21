package com.wonseok.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Boj7562 {
    static int[][]graph;
    static int[]dx={1,2,1,2,-1,-2,-1,-2};
    static int[]dy={-2,-1,2,1,-2,-1,2,1};
    static int n;
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(
                System.in
        ));
        int times = Integer.parseInt(br.readLine());
        for (int i = 0; i < times; i++) {
            n = Integer.parseInt(br.readLine());
            graph = new int[n][n];
            for (int[] ints : graph) {
                Arrays.fill(ints,-1);
            }
            int[] start = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int[] end = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            bfs(start);
            System.out.println(graph[end[1]][end[0]]);
        }

    }

    private static void bfs(int[] start) {
        queue.offer(start);;
        graph[start[1]][start[0]]=0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int startX = poll[0];
            int startY = poll[1];
            for (int i = 0; i < 8; i++) {
                int nextX = startX + dx[i];
                int nextY = startY + dy[i];
                if(nextX<0||nextY<0||nextX>=n||nextY>=n)continue;
                if(graph[nextY][nextX]!=-1) continue;
                graph[nextY][nextX] = graph[startY][startX]+1;
                queue.offer(new int[]{nextX,nextY});
            }
        }
    }
}
