package com.wonseok.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj15683 {
    static StringTokenizer st;
    static int[][] graph;
    static int[][] tempGraph;
    static int n;
    static int m;
    static List<Location> queue = new LinkedList<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int min = 123123123;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        tempGraph = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] != 0 && graph[i][j] != 6) {
                    queue.add(
                            new Location(j, i, graph[i][j])
                    );
                }
            }
        }

        int size = queue.size();
        //경우의수 조합

        for (int temp = 0; temp < 1 << (2 * size); temp++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    tempGraph[i][j] = graph[i][j];
                }
            }
            int brute = temp;
            for (int i = 0; i < size; i++) {
                int dir = brute % 4;
                brute /= 4;
                int x = queue.get(i).getX();
                int y = queue.get(i).getY();
                if (graph[y][x] == 1) {
                    checkLine(x, y, dir);
                } else if (graph[y][x] == 2) {
                    checkLine(x, y, dir);
                    checkLine(x, y, dir + 2);
                } else if (graph[y][x] == 3) {
                    checkLine(x, y, dir);
                    checkLine(x, y, dir + 1);

                } else if (graph[y][x] == 4) {
                    checkLine(x, y, dir);
                    checkLine(x, y, dir +1);
                    checkLine(x, y, dir +2);
                } else {
                    checkLine(x, y, dir);
                    checkLine(x, y, dir + 1);
                    checkLine(x, y, dir + 2);
                    checkLine(x, y, dir + 3);
                }
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (tempGraph[i][j] == 0)
                        count++;
                }
            }
            min = Math.min(min, count);
            /*
            System.out.println(temp+"로부터 ");
            for (int[] ints : tempGraph) {
                for (int e : ints) {
                    if (e >=0)
                        System.out.print(" "+e);
                    else
                        System.out.print(e);
                }
                System.out.println();
            }
            System.out.println();

             */
        }
            System.out.println(min);


    }


    private static void checkLine(int x, int y, int direction) {
        direction %= 4;
        int nextX = x;
        int nextY = y;
        tempGraph[nextY][nextX] = -1;
        while (true) {
            nextX += dx[direction];
            nextY += dy[direction];
            if (nextX == m || nextX < 0 || nextY < 0 || nextY == n) break;
            else {
                if (tempGraph[nextY][nextX] == 6) break;
                if (tempGraph[nextY][nextX] == 0) {
                    tempGraph[nextY][nextX] = -1;
                }
            }
        }
    }


    private static class Location {
        int x;
        int y;
        int cameraNum;

        public Location(int x, int y, int cameraNum) {
            this.x = x;
            this.y = y;
            this.cameraNum = cameraNum;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getCameraNum() {
            return cameraNum;
        }

        public void setCameraNum(int cameraNum) {
            this.cameraNum = cameraNum;
        }
    }

    private static class Direction {
        static final int UP = 0;
        static final int DOWN = 1;
        static final int LEFT = 2;
        static final int RIGHT = 3;
    }
}
