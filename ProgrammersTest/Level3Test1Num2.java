package com.wonseok.ProgrammersTest;

public class Level3Test1Num2 {
    public static void main(String[] args) {

    }
    public int solution(int n, int[] money) {
        //5
        // 1 2 5
        int[]dp = new int[n+1];
        dp[0] = 1;

            for (int j = 0; j < money.length; j++) {
                for (int i = money[j]; i <= n; i++) {
                    dp[i] += dp[i-money[j]];
                }
            }
        return dp[n];
    }

}
