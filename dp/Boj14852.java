package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj14852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int mod = (int) 1e9 + 7;

        int[] dp = new int[n + 1];
        int[] dp2 = new int[n + 1];

        dp[0] = 1;
        dp[1] = 2;
        if(n>=2) {
            dp[2] = 7;
            for (int i = 3; i <= n; i++) {
                dp2[i] = dp2[i - 1] + dp[i - 3];
                dp[i] = ((dp[i - 1] * 2) % mod + (dp[i - 2]*3)%mod+(dp2[i]*2)%mod) % mod;
            }
        }

        System.out.println(dp[n]);
    }
}
