package com.wonseok.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(
                System.in
        ));
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
        if(solutionGreedy(i)!= solutionDp(i)) System.out.println(i+" Greedy: "+solutionGreedy(i)+" DP: "+solutionDp(i));
        }
    }
    //20 일때
    private static int solutionDp(int n) {
        // n을 만들기위하 연산의 최소 수
        // 3*n 은 dp[3n] = dp[n] +1;
        // dp[2n] = dp[]
        int[] dp = new int[n + 1];
        dp[1] = 0;
        for (int i = 2 ; i <= n; i++) {
            if(dp[i]==0){
                if(i%6==0)
                    dp[i] = Math.min(dp[i / 3] + 1, dp[i / 2] + 1);
                else if (i % 3 == 0) {
                    dp[i] = Math.min(dp[i / 3]+1,dp[i-1]+1);
                } else if (i % 2 == 0) {
                    dp[i] = Math.min(dp[i / 2]+1,dp[i-1]+1);
                }else{
                    dp[i] =dp[i-1]+1;
                }
            }
        }

        return dp[n];
    }

    private static int solutionGreedy(int n) {
        int nA = n;
        //배수 형태가 아니면 그리디로 불가능
        int countA = 0;
        while(nA>1) {
            if (nA % 3 == 0) {
                nA = nA / 3;
                countA++;
            } else if (nA %2==0){
                nA = nA/2;
                countA++;
            }else{
                nA--;
                countA++;
            }
        }
        // 10 에서 예외 발생
        int countB = 0;
        while(n>1){
            if (n % 3 == 0) {
                n = n / 3;
                countB++;
            }else{
                n--;
                countB++;
            }
        }
        int result = Math.min(countA, countB);
        return result;
    }
}
