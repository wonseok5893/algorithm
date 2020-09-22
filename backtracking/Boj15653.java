package com.wonseok.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Boj15653 {
    static Queue<Location> queue = new LinkedList<>();
    static String[][] graph;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        graph = new String[arr[0]][arr[1]];
        for (int i = 0; i < arr[0]; i++) {
            String[] add = br.readLine().split("");
            for (int j = 0; j < arr[1]; j++) {
                graph[i][j] = add[j];
                if (graph[i][j].equals("R")) queue.add(new Location(j, i, 1));
                if (graph[i][j].equals("B")) queue.add(new Location(j, i, 0));
            }
            while (!queue.isEmpty()) {
                Location redNow = queue.poll();
                Location bluewNow = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nextRedX = redNow.getX();
                    int nextRedY = redNow.getY();

                }
            }
        }


    }

    static class Location {
        int x;
        int y;
        int value;

        public Location(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        public int getValue() {
            return value;
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