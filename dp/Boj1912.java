package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //prefix D[i:j];
        int max = -1001;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + arr[i - 1];
            max = Math.max(max, dp[i]);
            if (dp[i] < 0)
                dp[i] = 0;
        }
        System.out.println(max);
//
//        if(max==0){
//            int minusMax = -1001;
//            for (int i = 0; i < n; i++) {
//                minusMax = Math.max(minusMax, arr[i]);
//            }
//            max = minusMax;
//        }
    }
}
