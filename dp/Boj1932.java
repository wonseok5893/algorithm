package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] graph = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j <= i; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ///
        int[][]dp = new int[n+1][n+1];
        dp[1][0] = graph[0][0];
        for (int i = 2; i <=n ; i++) {
            for (int j = 0; j < i; j++) {
                if(j==0) dp[i][j] = dp[i - 1][0] + graph[i-1][0];
                else if(j==i-1) dp[i][j] = dp[i - 1][j - 1] + graph[i-1][j];
                else dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j])+graph[i-1][j];
            }
        }
        int max =-1;
        for (int i = 0; i <= n; i++) {
            max = Math.max(max, dp[n][i]);
        }
        System.out.println(max);

    }
}
