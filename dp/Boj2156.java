package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        //틀린 solution1 :  첫번째 시도1
        //        long[][] dp = new long[n + 1][2];
        //        dp[0][0] = 0;
        //        dp[0][1] = 0;
        //        dp[1][0] = 0;
        //        dp[1][1] = arr[1];
        //        dp[2][0] = arr[1];
        //        dp[2][1] = arr[1]+arr[2];
        //
        //        for (int i = 3; i <=n ; i++) {
        //            dp[i][1] = Math.max(dp[i - 2][0] + arr[i - 1] + arr[i], dp[i - 1][0] + arr[i]);
        //            dp[i][0] = dp[i - 1][1];
        //        }
        long[] dp = new long[n + 1];
        dp[1] = arr[1];
       if(n==2) {
           dp[2] = arr[1] + arr[2];
       }
        else if (n >= 3) {
           dp[2] = arr[1] + arr[2];
           dp[3] = Math.max(arr[1] + arr[2], Math.max(arr[2] + arr[3], arr[1] + arr[3]));
            for (int i = 4; i <= n; i++) {
                dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 3] + arr[i - 1], dp[i - 2]) + arr[i]);
            }
        }
        System.out.println(dp[n]);
    }
}
