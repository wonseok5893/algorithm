package com.wonseok.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj15652 {
    static int[] isUsed;
    static StringBuilder sb = new StringBuilder();
    static StringBuilder backupSb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        isUsed = new int[arr[0] + 1];
        backTracking(arr[0], arr[1], 0);
        System.out.println(sb);
    }

    private static void backTracking(int n, int m, int temp) {
        if (m == 0) {
            sb.append(backupSb);
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (temp > i) continue;
            temp = i;
            backupSb.append(i + " ");
            backTracking(n, m - 1, temp);

            backupSb.delete(backupSb.length() - 2, backupSb.length());

        }
    }
}
