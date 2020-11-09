package com.wonseok;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        // write your code s
        solution(4, false);
    }

    private static void solution(int n, boolean horizontal) {
        //n은 1이상 100이하
        int[] dx = {1, -1, 0, 1};
        int[] dy = {0, 1, 1, -1}; //오 왼아래 아래 오위
        int[] newDX = {1, 1, 0, -1};
        int[] newDY = {0, -1, 1, 1};
        int direction = 0;   // 오 오위 아래 왼아래
        if(!horizontal) direction =2;
        int[][] result = new int[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        boolean start = false;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nowX = poll[0];
            int nowY = poll[1];
            int nextX = nowX + dx[direction];
            int nextY = nowY + dy[direction];
            if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) continue;
            if (direction == 1 || direction == 3) result[nextY][nextX] = result[nowY][nowX] + 2;
            else result[nextY][nextX] = result[nowY][nowX] + 1;
            if (nextX + nextY <= n - 2) {
                if (nextX == 0 || nextY == 0) {
                    direction = (direction + 1) % 4;
                }
            } else {
                if (!start) {
                    if (nextX == n - 1 && nextY == 0) {
                        dx = newDX;
                        dy = newDY;
                        direction = 3;

                    }
                    if (nextY == n - 1 && nextX == 0) {
                        dx = newDX;
                        dy = newDY;
                        direction = 1;

                    }
                    start = true;
                } else if (nextX == n - 1 || nextY == n - 1)
                    direction = (direction + 1) % 4;

            }
            queue.offer(new int[]{nextX, nextY});
        }

        for (int[] ints : result) {
                for (int e : ints) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// 오 왼아 아 오위 오 왼아 아 오위 오 왼아 / 오위 아 왼아 오 오위 아 왼아