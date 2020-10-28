package com.wonseok.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj16473 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[]cards = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong).toArray();
        int loopCount = Integer.parseInt(br.readLine());
        int[] loop = new int[loopCount];
        for (int i = 0; i < loopCount; i++) {
            loop[i] = Integer.parseInt(br.readLine());
        }
        //초기화

        int[][]dp = new int[n+1][n+1];
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n-j; k++) {
                long first = cards[j];
                long second = cards[n -1 -k];
                if(first==second) {
                    dp[j + 1][k + 1] = dp[j][k] + 2;
                }
                else{
                    dp[j+1][k+1] = Math.max(dp[j+1][k],dp[j][k+1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < loopCount; i++) {
            int center = loop[i];
            center--;

            int result = n-dp[center][n-center-1]-1;
            sb.append(result+"\n");
        }
        System.out.println(sb);
    }
}
