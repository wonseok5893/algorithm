package com.wonseok.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11729 {
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "");
        int n = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        sb.append((1 << n) - 1);
        sb.append("\n");
        func(1, 3, n);
        System.out.println(sb);
    }

    private static void func(int a, int b, int n) {
        if (n == 1) {
            sb.append(a + " " + b);
            sb.append("\n");
            return;
        }
        func(a, 6 - a - b, n - 1);
        sb.append(a + " " + b);
        sb.append("\n");
        func(6 - a - b, b, n - 1);
    }
}
