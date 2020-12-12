package com.wonseok.ProgrammersTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BojTest6 {
    static int[][] visited;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(
                System.in
        ));
        int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        map = new int[info[0]][info[1]];
        int y = map.length;
        int x = map[0].length;
        StringTokenizer st;
        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < x; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new int[y + 1][x + 1];
        int max = 0;
        int count = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (map[i][j] == 0 || visited[i][j] == 1) continue;
                max = Math.max(bfs(i, j), max);
                count++;
            }
        }
        System.out.println(count);
        System.out.println(max);

    }

    private static int bfs(int i, int j) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int count = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{j, i});
        visited[i][j] = 1;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nextX = poll[0] + dx[k];
                int nextY = poll[1] + dy[k];
                if (nextX < 0 || nextY < 0 || nextX >= map[0].length || nextY >= map.length)
                    continue;
                if (visited[nextY][nextX] == 1 || map[nextY][nextX] == 0) continue;
                queue.offer(new int[]{nextX,nextY});
                visited[nextY][nextX] = 1;
                count++;

            }
        }
        return count;
    }
}
