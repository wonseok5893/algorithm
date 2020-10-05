package com.wonseok.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Chap04_3 {
    static int[][] map;
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] mapInfo = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] charInfo = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        map = new int[mapInfo[0]][mapInfo[1]];
        visited = new int[mapInfo[0]][mapInfo[1]];
        for (int i = 0; i < mapInfo[0]; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        //맵 초기화
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        int startX = charInfo[1];
        int startY = charInfo[0];
        int direction = charInfo[2];
        visited[startY][startX] =1;
        int count = 1;
        int turnTime = 0;

        while (true) {
            direction = direction_change(direction);
            int nextX = startX + dx[direction];
            int nextY = startY + dy[direction];
            if (map[nextY][nextX] == 0 && visited[nextY][nextX] == 0) {
                visited[nextY][nextX] = 1;
                startX = nextX;
                startY = nextY;
                count++;
                turnTime = 0;
                continue;
            } else {
                turnTime++;
            }
            if (turnTime == 4) {
                nextX = startX - dx[direction];
                nextY = startY - dy[direction];
                if (map[nextY][nextX] != 1) {
                    startX = nextX;
                    startY = nextY;
                    turnTime = 0;
                } else
                    break;
            }
            for (int[] ints : visited) {
                for (int e : ints) {
                    System.out.print(e);
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println(count);


    }

    private static int direction_change(int pos) {
        if (pos == 0)
            return 3;
        else
            pos--;
        return pos;
    }

}
