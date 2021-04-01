package ProgrammersTest.level4;

import java.util.Arrays;

public class N타일 {
    public static void main(String[] args) {
        new N타일().solution(4);
    }

    public int solution(int n) {
        //세로 3
        int MOD = (int) 1e9 + 7;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[2] = 3;
        for (int i = 4; i <= n; i += 2) {
            dp[i] = dp[i - 2] * 3;
            for (int j = 0;j <= i-4; j += 2) {
                dp[i] += dp[j] * 2;
            }
            dp[i] %=MOD;
        }
        return (int)dp[n];
    }
}
