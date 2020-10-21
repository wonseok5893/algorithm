package com.wonseok.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers191247 {
    public static void main(String[] args) {
        int[][] map = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int[][] map1 = {{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}};


        int result = solution(3, 6, map1);
        System.out.println(result);
    }

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] visited;
    static int nowDirection;
    static Queue<Location> queue = new LinkedList<>();

    public static int solution(int m, int n, int[][] cityMap) {
        visited = new int[m][n];
        queue.offer(new Location(0, 0, 1));
        queue.offer(new Location(0, 0, 2));

//        while(queue)
        return visited[m - 1][n - 1];
    }

    private static class Location {
        int x;
        int y;
        int direction;

        public Location(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }

        public int getDirection() {
            return direction;
        }

        public void setDirection(int direction) {
            this.direction = direction;
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
    }
}



