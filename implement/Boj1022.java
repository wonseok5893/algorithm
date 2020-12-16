package com.wonseok.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj1022 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[][] graph = new int[51][51];
        graph[26][26] = 1;
        int len = 1;
        for (int i = 0; i <= 25; i++) {
            printGraph(graph, i + 25, i + 25, len);
            len += 2;
        }
        int maxY = Math.abs(info[0]) > Math.abs(info[2]) ?
                info[0] : info[2];
        int maxX = Math.abs(info[1]) > Math.abs(info[3]) ?
                info[1] : info[3];
        int max = graph[maxY+25][maxX+25];
        int maxLen = String.valueOf(max).length();

        StringBuilder sb = new StringBuilder();
        for (int i = info[0] + 25; i <= info[2] + 25; i++) {
            for (int j = info[1] + 25; j <= info[3] + 25; j++) {
                int strLen = String.valueOf(graph[i][j]).length();
                    for (int k = 0; k < maxLen - strLen; k++) {
                        sb.append(" ");
                    }
                if(j!=info[1]+25) {
                    sb.append(" ");
                }
                sb.append(graph[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void printGraph(int[][] graph, int startY, int startX, int len) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        int startValue = len * len;
        int startDir = 0;
        graph[startY][startX] = startValue;

        int count = len * len - (len - 2) * (len - 2) - 1;

        int dirCount = len - 1;

        while (count > 0) {
            startX += dx[startDir];
            startY += dy[startDir];

            graph[startY][startX] = --startValue;
            dirCount--;
            if (dirCount == 0) {
                startDir++;
                dirCount = len - 1;
            }
            count--;
        }
    }
}

