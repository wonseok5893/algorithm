package graph;

import java.io.*;
import java.util.*;

public class Boj3055 {
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int[][] graph;
    static int[][] visitedDotch;
    static int[][] visitedWater;
    static Queue<int[]> waters = new LinkedList<>();
    static Queue<int[]> watersQueue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        //물도 비어있는 칸으로 확장한다. 상하좌우
        //돌은 통과 x
        //고슴도치 물 돌 x
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        graph = new int[r][c];
        int[] start = new int[2];
        int[] target = new int[2];
        for (int i = 0; i < r; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                switch (str[j]) {
                    case "S": {
                        start[0] = j;
                        start[1] = i;
                        break;
                    }
                    case "*": {
                        waters.add(new int[]{j, i});
                        graph[i][j] = 2;
                        break;
                    }
                    case "X": {
                        graph[i][j] = 3;
                        break;
                    }
                    case "D": {
                        target[0] = j;
                        target[1] = i;
                        graph[i][j] = 5;
                        break;
                    }
                }
            }
        }
        //물 2 돌 3
        visitedDotch = new int[r][c];
        visitedWater = new int[r][c];
        int distance = bfs(start, target);
        System.out.println(distance == 0 ? "KAKTUS" : distance - 1);
    }

    private static int bfs(int[] start, int[] target) {
        visitedDotch[start[1]][start[0]] = 1;
        Queue<int[]> dotches = new LinkedList<>();
        Queue<int[]> dotchQueue = new LinkedList<>();
        dotches.offer(start);

        while (true) {
            while (!waters.isEmpty()) {
                int[] water = waters.poll();
                for (int i = 0; i < 4; i++) {
                    int nextWaterX = water[0] + dx[i];
                    int nextWaterY = water[1] + dy[i];
                    if (nextWaterX < 0 || nextWaterY < 0 || nextWaterX >= graph[0].length || nextWaterY >= graph.length)
                        continue;
                    if (graph[nextWaterY][nextWaterX] == 3 || graph[nextWaterY][nextWaterX] == 5) continue;
                    if (visitedWater[nextWaterY][nextWaterX] != 0) continue;
                    graph[nextWaterY][nextWaterX] = 2;
                    visitedWater[nextWaterY][nextWaterX] = 1;
                    watersQueue.offer(new int[]{nextWaterX, nextWaterY});
                }
            }
            while (!dotches.isEmpty()) {
                int[] now = dotches.poll();
                for (int i = 0; i < 4; i++) {
                    int nextX = now[0] + dx[i];
                    int nextY = now[1] + dy[i];
                    if (nextX < 0 || nextY < 0 || nextX >= graph[0].length || nextY >= graph.length) continue;
                    if (graph[nextY][nextX] == 2 || graph[nextY][nextX] == 3 || visitedDotch[nextY][nextX] != 0)
                        continue;
                    visitedDotch[nextY][nextX] = visitedDotch[now[1]][now[0]] + 1;
                    if (nextX == target[0] && nextY == target[1]) return visitedDotch[target[1]][target[0]];
                    dotchQueue.offer(new int[]{nextX, nextY});
                }
            }


            while (!watersQueue.isEmpty())
                waters.offer(watersQueue.poll());
            while (!dotchQueue.isEmpty())
                dotches.offer(dotchQueue.poll());
            if (dotches.isEmpty()) break;
        }
        return visitedDotch[target[1]][target[0]];
    }


}
