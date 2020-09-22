package com.wonseok.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Boj15653 {
    static Queue<Location> redQueue = new LinkedList<>();
    static Queue<Location> blueQueue = new LinkedList<>();
    static String[][] graph;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int holeX = -1;
    static int holeY = -1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        graph = new String[arr[0]][arr[1]];
        for (int i = 0; i < arr[0]; i++) {
            String[] add = br.readLine().split("");
            for (int j = 0; j < arr[1]; j++) {
                graph[i][j] = add[j];
                if (graph[i][j].equals("R")) redQueue.add(new Location(j, i));
                if (graph[i][j].equals("B")) blueQueue.add(new Location(j, i));
                if (graph[i][j].equals("O")) {
                    holeX = j;
                    holeY = i;
                }
            }
            while (!redQueue.isEmpty()) {
                Location redNow = redQueue.poll();
                Location bluewNow = blueQueue.poll();
                int nowRedX = redNow.getX();
                int nowRedY = redNow.getY();
                int nowBlueX = bluewNow.getX();
                int nowBLueY = bluewNow.getY();

                for (int j = 0; j < 4; j++) {
                    int nextRedX = nowRedX + dx[i];
                    int nextRedY = nowRedY + dy[i];
                    int nextBlueX = nowBlueX + dx[i];
                    int nextBlueY = nowBLueY + dy[i];

                    while (true) {
                        if (graph[nowRedY][nowRedX].equals("#")) {
                            nextRedX -= dx[i];
                            nextRedY -= dy[i];
                            break;
                        }
                        if (graph[nowRedY][nowRedX].equals("O")) {
                            break;
                        }
                        nextRedX += dx[i];
                        nextRedY += dy[i];
                    }
                    while (true) {
                        if (graph[nextBlueY][nextBlueX].equals("#")) {
                            nextBlueX -= dx[i];
                            nextBlueY -= dy[i];
                            break;
                        }
                        if (graph[nextBlueY][nextBlueX].equals("O")) {
                            break;
                        }
                        nextBlueX += dx[i];
                        nextBlueY += dy[i];
                    }


                }
            }
        }


    }

    static class Location {
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
//for (String[] strings : graph) {
//            for (String string : strings) {
//                System.out.print(string);
//            }
//            System.out.println();
//        }