package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Boj2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(
                System.in
        ));
        int n = Integer.parseInt(br.readLine());
        int[] stairs = new int[301];
        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
            ;
        }
        int[] dp = new int[301];
        dp[1] = stairs[1];
        dp[2] = dp[1] + stairs[2];
        dp[3] = Math.max(stairs[1],stairs[2])+stairs[3];
        for (int i = 4; i <= 300; i++) {
            dp[i] = Math.max(dp[i-3]+stairs[i-1],dp[i-2]) + stairs[i];
        }
        System.out.println(dp[n]);
    }
}
// 5  =  1,2,3
// 1 1 1 1 1 1+1+1+2 1+1+3 2+3