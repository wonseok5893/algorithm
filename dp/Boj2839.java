package com.wonseok.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(
                System.in
        ));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[5001];
        dp[3] = 1;
        dp[5] = 1;
        //dp[i]는 ig을 담을수있는 최소 봉지
        for (int i = 6; i <= n; i++) {
            if(dp[i] == 0) {
                if(dp[i-3]!=0&&dp[i-5]!=0)
                dp[i] = Math.min(dp[i - 3] + 1, dp[i - 5] + 1);
                else if(dp[i-5]!=0){
                    dp[i] = dp[i-5]+1;
                }else if (dp[i - 3] != 0) {
                    dp[i] = dp[i - 3]+1;
                }
            }
        }

        System.out.println(dp[n]==0?-1:dp[n]);
    }
}
