package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coins);
        // k원을 만드는데 사용할 최소 동전의 수
        // 1 2 3 4 5 6 7 8
        // 1 2 3 4
        // 8원을 만드는데 최소 동전의수
        int dp[] = new int[k+1];
        Arrays.fill(dp, 100001);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int money = 1; money <= k; money++) {
                if (money - coins[i] >= 0) {
                        dp[money] = Math.min(dp[money - coins[i]] + 1,dp[money]);
                }
            }
        }
        System.out.println(dp[k]==100001?-1:dp[k]);

        // 1 5 12
        // 1 2 3 4

    }
}
