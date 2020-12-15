package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] info = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n+20];
        //dp[i] => i일동안 최대 이익
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
           if(dp[i]>dp[i+1]) dp[i + 1] = dp[i];
           if(dp[i+info[i][0]]<dp[i]+info[i][1])dp[i+info[i][0]] = dp[i]+info[i][1];
        }
//        for (int i = 1; i <=n; i++) {
//            System.out.print(dp[i]+" ");
//        }
        System.out.println(dp[n]);

    }
}
