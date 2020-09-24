package com.wonseok.recursion;

import java.util.Arrays;
import java.util.Scanner;

public class Boj2448 {
    static char[][] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        graph = new char[n][2 * n - 1];
        for (char[] chars : graph) {
            Arrays.fill(chars, ' ');
        }
        recursion(n, 0, 0);
        StringBuilder sb = new StringBuilder();
        for (char[] chars : graph) {
            for (char aChar : chars) {
                sb.append(aChar);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void recursion(int n, int x, int y) {
        if(n<3) return;
        if (n == 3) {
            printStart(x, y);
            return;
        }
        recursion(n / 2, x + n / 2, y);
        recursion(n / 2, x, y + n / 2);
        recursion(n / 2, x + n, y + n / 2);
    }

    private static void printStart(int x, int y) {
        graph[y][x + 2] = '*';
        graph[y + 1][x + 1] = '*';
        graph[y + 1][x + 3] = '*';
        for (int i = 0; i < 5; i++) {
            graph[y + 2][x + i] = '*';
        }
    }
}
