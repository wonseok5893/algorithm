package com.wonseok.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj1890 {
    static long[][]dp;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        dp = new long[n][n];

        for (int[] arr : map) {
            int pos = 0;
            st = new StringTokenizer(br.readLine()," ");
            while(st.hasMoreTokens()){
                arr[pos++] = Integer.parseInt(st.nextToken());
            }
        }

        // 경우의수
        long res = topdownRecursion(map,n-1,n-1);
        System.out.println(map[0][0]==0?0:res);
        // 첫번째 열
        // 0 0 1 0
        // 0 0 0 0
        // 1 1 0 1
        // 1 0 1 3
    }

    private static long topdownRecursion(int[][] map, int y, int x) {
        if(y==0&&x==0)
            return 1;
        if(dp[y][x]!=0) return dp[y][x];
        ArrayList<int[]> possibleLists = new ArrayList<>();
        // 왼쪽에서 올수 있었던 것들
        for (int i = x-1; i >=0; i--) {
            if(map[y][i]==0)break;
            if(map[y][i]==x-i) possibleLists.add(new int[]{i,y});
        }
        // 오른쪽에서 올수 있었던 것들
        for (int i = y-1; i >=0; i--) {
            if(map[i][x]==0)break;
            if(map[i][x]==y-i) possibleLists.add(new int[]{x,i});
        }

        long sum = 0;
        for (int[] arr : possibleLists) {
            sum+= topdownRecursion(map,arr[1],arr[0]);
        }
        return dp[y][x] = sum;
    }
}
