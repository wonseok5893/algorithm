package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCases = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCases; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] stickers = new int[n][2];
            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < n; k++) {
                    stickers[k][j] = Integer.parseInt(st.nextToken());
                }
            }
            solution(stickers, n);
        }

    }

    private static void solution(int[][] stickers, int n) {
        int[][] dp = new int[n+1][2]; //
        //dp[i][j] = i,j를 포함한 가장 큰 최댓값
        dp[1][0] = stickers[0][0];
        dp[1][1] = stickers[0][1];
        for (int i = 2; i <=n ; i++) {
            dp[i][0] = stickers[i - 1][0] + Math.max(dp[i - 1][1], dp[i - 2][1]);
            dp[i][1] = stickers[i-1][1]+Math.max(dp[i - 1][0], dp[i-2][0]);
        }
        System.out.println(Math.max(dp[n][0],dp[n][1]));
    }
}
