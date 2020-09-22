package com.wonseok.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj1182 {
    static int[]isUsed;
    static int count = 0;
    static int s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int n = Integer.parseInt(info[0]);
        s = Integer.parseInt(info[1]);

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 1; i <= n; i++) {
            isUsed = new int[n+1];
            int sum = 0;
            int temp = 0;
            backtracking(arr,i,temp,sum);
        }
        System.out.println(count);

    }

    private static void backtracking(int[] arr, int i,int temp,int sum) {
        if(i==0){
            if(sum==s) count++;
            return;
        }
        for (int j = temp; j < arr.length; j++) {
            if(isUsed[j]==1)continue;
            isUsed[j]=1;
            sum+=arr[j];
            temp = j;
            backtracking(arr,i-1,temp+1,sum);
            sum-=arr[j];
            isUsed[j]=0;
        }
    }
}
