package ProgrammersTest.level3;

import java.util.Arrays;

public class 거스름돈 {
    public static void main(String[] args) {
        new 거스름돈().solution(5, new int[]{1, 2, 5});

    }

    public int solution(int n, int[] money) {
        //1,2,5
        //5

        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < money.length; i++) {
            for (int j = 1; j <= n; j++) {
                if(money[i]<=j)
                    dp[j] += dp[j - money[i]];
            }
        }

        return dp[n];
    }
}
