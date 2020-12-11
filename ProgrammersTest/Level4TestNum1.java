package com.wonseok.ProgrammersTest;

public class Level4TestNum1 {
    public static void main(String[] args) {
        //3*n 타일링
        //https://programmers.co.kr/learn/courses/30/lessons/12902

        new Level4TestNum1().solution(50
        );
    }
    public int solution(int n) {
        int[] dp = new int[n + 1];
        dp[0] =1;
        int mod = 1000000007;
        int add = 0;
        for (int i = 2; i <=n; i=i+2) {
            for (int j = 0; j < 3; j++) {
                dp[i] = (dp[i] + dp[i - 2])%mod;
            }
            dp[i] = (dp[i] +add*2)%mod;
            add += dp[i-2];
        }

        return dp[n];
    }
}
