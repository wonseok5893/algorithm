package dp;

import java.util.Scanner;

public class Boj9461 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
        for (int i = 6; i <= 100; i++) {
            dp[i] = dp[i - 1] + dp[i - 5];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testCases; i++) {
            int n = sc.nextInt();
            sb.append(dp[n]+"\n");
        }
        System.out.println(sb);
    }
}
