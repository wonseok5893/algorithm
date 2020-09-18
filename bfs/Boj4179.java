package com.wonseok.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Boj4179 {
    static String[][] graph;
    static int[] dy = {1, -1, 0, 0,};
    static int[] dx = {0, 0, -1, 1};
    //graph 완성
    static StringTokenizer st;
    static Queue<Location> queue = new LinkedList<>();
    static Queue<Location> fireQueue = new LinkedList<>();
    static Queue<Location> backupQueue;
    static int[][] dist;
    static int[][] fire;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int y = info[0];
        int x = info[1];
        graph = new String[y][x];
        fire = new int[y][x];
        dist = new int[y][x];
        int result = 0;
        for (int i = 0; i < y; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < x; j++) {
                String s = split[j];
                graph[i][j] = s;
                if (graph[i][j].equals("J")) {
                    if(i==0||i==y-1)result=1;
                    if (j==0||j==x-1)result =1;
                    queue.offer(new Location(j, i));
                }
                if (graph[i][j].equals("F")) {
                    fireQueue.offer(new Location(j, i));
                }
            }
        }
        makeFire();
        int temp = 0;
        while (!queue.isEmpty()) {
            Location nowLocation = queue.poll();
            int nowX = nowLocation.getX();
            int nowY = nowLocation.getY();
            if (temp != dist[nowY][nowX]) {
                temp = dist[nowY][nowX];
                makeFire();
            }
            for (int i = 0; i < 4; i++) {
                int px = nowX + dx[i];
                int py = nowY + dy[i];
                //벽검사 하고 불검사
                if (px < 0 || py < 0 || px >= graph[0].length || py >= graph.length) continue;
                if (graph[py][px].equals("#") || fire[py][px] == 1) continue;
                if (dist[py][px] > 0) continue;
                if (graph[py][px].equals(".")) {
                    queue.offer(new Location(px, py));
                    dist[py][px] = dist[nowY][nowX] + 1;
                }
            }
        }
        int min = 999999;
        for (int i = 0; i < x; i++) {
            if (i == 0 || i == x - 1) {
                for (int j = 0; j < y; j++) {
                    if (dist[j][i] != 0)
                        if (min > dist[j][i])
                            min = dist[j][i];
                }
            } else {
                if (dist[0][i] != 0) {
                    if (min > dist[0][i])
                        min = dist[0][i];
                }
                if(dist[y-1][i]!=0){
                    if (min > dist[y-1][i])
                        min = dist[y-1][i];
                }
            }
        }

        if(result==1) System.out.println(1);
        else {
            System.out.println(min == 999999 ? "IMPOSSIBLE" : min + 1);
        }
        //도착지
    }

    private static void makeFire() {
        backupQueue = new LinkedList<>();
        while (!fireQueue.isEmpty()) {
            Location nowfire = fireQueue.poll();
            fire[nowfire.getY()][nowfire.getX()] = 1;
            for (int k = 0; k < 4; k++) {
                int px = nowfire.getX() + dx[k];
                int py = nowfire.getY() + dy[k];
                if (px < 0 || py < 0 || px >= graph[0].length || py >= graph.length) continue;
                if (graph[py][px].equals("#")) continue;
                if (fire[py][px] == 1) continue;
                else {
                    fire[py][px] = 1;
                    backupQueue.offer(new Location(px, py));
                }
            }
        }
        fireQueue = backupQueue;
    }


    private static class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
