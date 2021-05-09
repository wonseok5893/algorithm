package summer2021;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Num3 {
    public static void main(String[] args) {
        new Num3().solution(new int[][]{{1, 28, 41, 22, 25, 79, 4},
                {39, 20, 10, 17, 19, 18, 8}, {21, 4, 13, 12, 9, 29, 19},
                {58, 1, 20, 5, 8, 16, 9}, {5, 6, 15, 2, 39, 8, 29}, {39, 7, 17, 5, 4, 49, 5},
                {74, 46, 8, 11, 25, 2, 11}}, 19, 6);
    }

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int max = 0;
    static int target;
    static int[][] sMaps;
    static boolean[][] visit;

    public int solution(int[][] maps, int p, int r) {
        target = r;
        sMaps = maps;
        // r은 2이상 짝수
        if (r == 2) {
            for (int i = 0; i < maps.length - 1; i++) {
                for (int j = 0; j < maps[0].length - 1; j++) {
                    int cnt = 0;
                    if (maps[i][j] <= p / 2) cnt++;
                    if (maps[i][j + 1] <= p / 2) cnt++;
                    if (maps[i + 1][j] <= p / 2) cnt++;
                    if (maps[i + 1][j + 1] <= p / 2) cnt++;
                    max = Math.max(max, cnt);
                }
            }
            return max;
        }

        Queue<int[]> yellowQueue = new LinkedList<>();
        Queue<int[]> blueQueue = new LinkedList<>();
        for (int i = 1; i < maps.length; i++) {
            for (int j = 1; j < maps[0].length; j++) {
                int len = 2;
                int cnt = 0;
                visit = new boolean[maps.length][maps[0].length];
                blueQueue.offer(new int[]{j, i});
                blueQueue.offer(new int[]{j - 1, i});
                blueQueue.offer(new int[]{j, i - 1});
                blueQueue.offer(new int[]{j - 1, i - 1});
                visit[i][j] = true;
                visit[i][j - 1] = true;
                visit[i - 1][j] = true;
                visit[i - 1][j - 1] = true;
                bfs(blueQueue, yellowQueue, len);
                while (!blueQueue.isEmpty()) {
                    int[] poll = blueQueue.poll();
                    if (maps[poll[1]][poll[0]] <= p / 2) cnt++;
                }
                while (!yellowQueue.isEmpty()) {
                    int[] poll = yellowQueue.poll();
                    if (maps[poll[1]][poll[0]] <= p) cnt++;
                }

                max = Math.max(max, cnt);
            }
        }
        return max;
    }

    private void printVisit() {
        for (int i = 0; i < visit.length; i++) {
            for (int j = 0; j < visit[0].length; j++) {
                System.out.print(visit[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }


    private void bfs(Queue<int[]> blueQueue, Queue<int[]> yellowQueue, int len) {
        if (len == target) {
            return;
        }
        Queue<int[]> temp = new LinkedList<>();
        while (!blueQueue.isEmpty()) {
            int[] now = blueQueue.poll();
            yellowQueue.offer(now);
            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];
                if (nextX < 0 || nextY < 0 || nextX >= sMaps[0].length || nextY >= sMaps.length) continue;
                if (visit[nextY][nextX]) continue;
                temp.offer(new int[]{nextX, nextY});
                visit[nextY][nextX] = true;
            }
        }
        while (!temp.isEmpty()) {
            blueQueue.offer(temp.poll());
        }
        bfs(blueQueue, yellowQueue, len + 2);
    }

}
