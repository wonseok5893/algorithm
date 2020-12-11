package com.wonseok.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(
                System.in
        ));
        int testCases = Integer.parseInt(br.readLine());
        int testCase[] = new int[testCases];
        for (int i = 0; i < testCases; i++) {
            testCase[i] = Integer.parseInt(br.readLine());
        }
        for (int n : testCase) {
            solution(n);
        }
        br.close();
    }

    private static void solution(int n) {
        int ans = 0;

        int[]dp = new int[11];
        // dp[i] -> i를 만들기위한 방법의 수
        // ex) dp[3] -> 1+1+1 1+2 2+1 3 = 4;
        // dp[2] -> 1+1 2 =2
        // dp[1]  = 1
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i < 11; i++) {
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }
        ans = dp[n];
        System.out.println(ans);
    }
}
