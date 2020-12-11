<<<<<<< HEAD
package com.wonseok.dp;
=======
package dp;
>>>>>>> df76616f855d34dcb3a0b19ab73308fbb8eb6d24

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1003 {
<<<<<<< HEAD
    static int count0, count1;
    static int[] dp;

=======
>>>>>>> df76616f855d34dcb3a0b19ab73308fbb8eb6d24
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(
                System.in
        ));
<<<<<<< HEAD
        int testCases = Integer.parseInt(br.readLine());
        int testCase[] = new int[testCases];
        for (int i = 0; i < testCases; i++) {
            testCase[i] = Integer.parseInt(br.readLine());
        }
        for (int n : testCase) {
            dp = new int[n + 1];
            solution(n);
            for (int e : dp) {
                System.out.print(e+" ");
            }
            System.out.println();
            System.out.println(count0 + " " + count1);
            count0 = 0;
            count1 = 0;
        }
        br.close();
    }

    private static int solution(int n) {
        if (n == 1) {
            count1++;
            return 1;
        } else if (n == 0) {
            count0++;
            return 1;
        } else if (dp[n] != 0) return dp[n];
        else {
            dp[n] = solution(n - 1) +
                    solution(n - 2);
        }
        return 0;
=======
        int n = Integer.parseInt(br.readLine());
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = Integer.parseInt(br.readLine());
        }
        int[][]dp = new int[41][2];
        dp[0][0] = 1; dp[0][1] = 0;
        dp[1][0] = 0; dp[1][1] = 1;
        for (int i = 2; i < 41; i++) {
            dp[i][0] = dp[i-1][0]+dp[i-2][0];
            dp[i][1] = dp[i-1][1]+dp[i-2][1];
        }
        for (int e : result) {
            System.out.println(dp[e][0]+" "+dp[e][1]);
        }

>>>>>>> df76616f855d34dcb3a0b19ab73308fbb8eb6d24
    }
}
