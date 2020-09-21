package com.wonseok.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj15649 {
    static int[]isUsed;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        isUsed = new int[arr[0]+1];
        backTracking(arr[0],arr[1]);

    }

    private static void backTracking(int n, int m) {
        if(m==0){
            System.out.println(sb);
            return;
        }
        for (int i = 1; i <= n; i++) {
            if(isUsed[i]==1)continue;
            isUsed[i]=1;
            sb.append(i+" ");
            backTracking(n,m-1);
            sb.delete(sb.length()-2,sb.length());
            isUsed[i]=0;
        }
    }
}
