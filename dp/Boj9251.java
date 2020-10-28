package com.wonseok.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        int n = str1.length();
        int m = str2.length();
        int[][]dp = new int[n+1][m+1];

        for (int i = 0; i <n; i++) {
            for (int j = 0; j < m; j++) {
                char c1 = str1.charAt(i);
                char c2 = str2.charAt(j);
                if(c1==c2){
                    dp[i+1][j+1] = dp[i][j]+1;
                }else{
                    dp[i+1][j+1] = Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        System.out.println(dp[n][m]);

    }
}
