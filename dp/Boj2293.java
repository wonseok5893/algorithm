package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        // 초기화 끝

        //dp[i] i를 만들수 있는 만들수 있는 방법의 수
        // dp[1] = 1 // dp[3] =
        int[] dp = new int[target + 1];
        dp[0] = 1;
        // 1원부터 k원까지 만들수있나 보자
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <=target; j++) {
                dp[j] += dp[j - coins[i]];
            }
            // 1만 사용한경우
            // 2도 사용한 경우
            // 5도 사용한 경우를 하나씩 더해가서 결론
        }
        System.out.println(dp[target]);
    }
}
