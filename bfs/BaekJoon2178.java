package com.wonseok.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon2178 {

    static Queue<Location> queue = new LinkedList<>();
    static int[][] graph;
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] loc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int y = loc[0];
        int x = loc[1];
        graph = new int[y][x];
        visited = new int[y][x];
        for (int i = 0; i < y; i++) {
            graph[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        Location start = new Location(0, 0);
        bfs(start);
        System.out.println(graph[y-1][x-1]);

    }

    private static void bfs(Location start) {
        queue.offer(start);
        int count = 0;
        while (!queue.isEmpty()) {
            Location visitedLocation = queue.poll();
            List<Location> possibleLocations = findPossibleLocation(visitedLocation);
            for (Location e : possibleLocations) {
                if (visited[e.getY()][e.getX()] == 0) {
                    queue.offer(e);
                    visited[e.getY()][e.getX()] = 1;
                    graph[e.getY()][e.getX()]=graph[visitedLocation.getY()][visitedLocation.getX()]+1;
                }
            }
         /*   for (int[] ints : graph) {
                for (int e : ints) {
                    System.out.print(e+" ");
                }
                System.out.println("");

            }
            System.out.println();
        */

        }
    }

    private static List<Location> findPossibleLocation(Location visitedLocation) {
        int currentX = visitedLocation.getX();
        int currentY = visitedLocation.getY();

        List<Location> possibleLocation = new ArrayList<>();

        if(currentY+1<graph.length) {
            if (graph[currentY + 1][currentX] == 1)
                possibleLocation.add(new Location(visitedLocation.getX() , visitedLocation.getY()+1));
        }
        if(currentX+1<graph[0].length) {
            if (graph[currentY][currentX + 1] == 1)
                possibleLocation.add(new Location(visitedLocation.getX()+1, visitedLocation.getY() ));
        }
        if (currentY >= 1) {
            if (graph[currentY - 1][currentX] == 1)
                possibleLocation.add(new Location(visitedLocation.getX() , visitedLocation.getY()-1));
        }
        if (currentX >= 1) {
            if (graph[currentY][currentX - 1] == 1)
                possibleLocation.add(new Location(visitedLocation.getX()-1, visitedLocation.getY()));
        }
        return possibleLocation;
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
