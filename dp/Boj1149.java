package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(
                System.in
        ));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] dp = new int[n+1][3];
        //
        int[][]house = new int[n+1][3];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //0 1 2
       dp[1][0] = house[1][0];dp[1][1] = house[1][1];dp[1][2] = house[1][2];
        for (int i = 2; i <= n ; i++) {
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2])+house[i][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2])+house[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + house[i][2];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(dp[n][i],min);
        }
        System.out.println(min);


    }
}
