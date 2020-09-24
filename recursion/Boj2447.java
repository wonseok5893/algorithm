package com.wonseok.recursion;

import java.util.Arrays;
import java.util.Scanner;

public class Boj2447 {
    static char[][] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        graph = new char[n][n];
        for (char[] chars : graph) {
            Arrays.fill(chars,' ');
        }
        recursion(n, 0, 0);
        StringBuilder sb = new StringBuilder();
        for (char[] chars : graph) {
            for (char e : chars) {
                sb.append(e);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void recursion(int n, int x, int y) {
        if (n == 3) {
            printStart(x, y);
            return;
        }
        for (int i = 0; i < n; i+=n/3) {
            for (int j = 0; j < n; j+=n/3) {
                if (i == n/3 && j == n/3) continue;
                recursion(n/3,x+j,y+i);
            }
        }
    }

    private static void printStart(int x, int y) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1)continue;
                graph[y + i][x + j] = '*';
            }
        }

    }
}
