package com.wonseok.recursion;


import java.util.Arrays;
import java.util.Scanner;

public class Boj16505 {
    static char[][] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        graph = new char[1 << n][1 << n];
        for (char[] chars : graph) {
            Arrays.fill(chars, ' ');
        }
        recursion(n, 0, 0);
        StringBuilder sb = new StringBuilder();
        int temp = 1<<n;
        for (int i = graph.length - 1; i >= 0; i--) {
            for (int j = 0; j < temp; j++) {
                sb.append(graph[i][j]);
            }
            temp--;
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void recursion(int n, int x, int y) {
        if (n == 0) {
            graph[y][x] = '*';
            return;
        }
        if (n == 1) {
            graph[y][x] = '*';
            graph[y + 1][x + 1] = '*';
            graph[y + 1][x] = '*';
            return;
        }
        if (n == 2) {
            printStart(x, y);
            return;
        }
        recursion(n - 1, x + (1 << (n - 1)), y + (1 << (n - 1)));
        recursion(n - 1, x, y + (1 << (n - 1)));
        recursion(n - 1, x, y);
    }

    private static void printStart(int x, int y) {
        graph[y][x] = '*';
        graph[y + 1][x] = '*';
        graph[y + 1][x + 1] = '*';
        graph[y + 2][x] = '*';
        graph[y + 2][x + 2] = '*';
        graph[y + 3][x] = '*';
        graph[y + 3][x + 1] = '*';
        graph[y + 3][x + 2] = '*';
        graph[y + 3][x + 3] = '*';
    }
}
