package com.wonseok.ProgrammersTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BojTest8 {
    //https://www.acmicpc.net/problem/20312
    static int[] arr;
    static int n;
    static int INF = (int) (1e9 + 7);;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(
                System.in
        ));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
         arr = new int[n+1];
        for (int i = 2; i <= n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int dp[] = new int[n+1];
        int dp2[] = new int[n+1];
        dp[2] = arr[2];
        dp2[2] = arr[2];
        for (int i = 3; i <= n; i++) {
            dp[i]+=(dp[i-1]+dp[i-1]+arr[i])%INF;
            dp2[i]= (dp2[i-1]+arr[i])%INF;
        }
        int sum = dp[n]+arr[n];

        System.out.println(sum);
        System.out.println((sum*n)%INF - dp[n]);


    }
}
