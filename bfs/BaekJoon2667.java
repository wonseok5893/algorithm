package com.wonseok.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon2667 {

    static int[][] graph;
    static int[][] visited;
    static Queue<Location> queue = new LinkedList<>();
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());

        graph = new int[n][n];
        visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            graph[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
        int totalCount = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (graph[j][i] == 1) {
                    if (visited[j][i] == 0) {
                        int count = 1;
                        Location start = new Location(i, j);
                        bfs(start, count);
                        totalCount++;
                    }else continue;
                }else continue;
            }
        }
        System.out.println(totalCount);
        Collections.sort(result);
        for (Integer e : result) {
            System.out.println(e);
        }


    }

    private static void bfs(Location start, int count) {
        queue.offer(start);
        while (!queue.isEmpty()) {
            Location visitedLocation = queue.poll();
            visited[visitedLocation.getY()][visitedLocation.getX()] =1;
            List<Location> findLocations = findLocations(visitedLocation);
            for (Location e : findLocations) {
                if (visited[e.getY()][e.getX()] == 0) {
                    queue.offer(e);
                    visited[e.getY()][e.getX()] = 1;
                    count++;
                }
            }
        }
        result.add(count);
    }

    private static List<Location> findLocations(Location visitedLocation) {
        int currentX = visitedLocation.getX();
        int currentY = visitedLocation.getY();
        List<Location> findLocations = new ArrayList<>();
        if (currentY + 1 < graph.length) {
            if (graph[currentY + 1][currentX] == 1)
                findLocations.add(new Location(visitedLocation.getX(), visitedLocation.getY() + 1));
        }
        if (currentX + 1 < graph[0].length) {
            if (graph[currentY][currentX + 1] == 1)
                findLocations.add(new Location(visitedLocation.getX() + 1, visitedLocation.getY()));
        }
        if (currentY - 1 >= 0) {
            if (graph[currentY - 1][currentX] == 1)
                findLocations.add(new Location(visitedLocation.getX(), visitedLocation.getY() - 1));
        }
        if (currentX - 1 >= 0) {
            if (graph[currentY][currentX - 1] == 1)
                findLocations.add(new Location(visitedLocation.getX() - 1, visitedLocation.getY()));
        }
        return findLocations;
    }

    static class Location {
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
