package dp;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Boj2133 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //3 x n
        // n == 1
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 2; i <=n; i+=2) {
            dp[i] += dp[i-2];
            for (int j = i-2; j >=0 ; j-=2) {
                dp[i] += dp[j]*2;
            }
        }
        System.out.println(dp[n]);

    }
}
