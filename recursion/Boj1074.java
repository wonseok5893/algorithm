package com.wonseok.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj1074 {
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[]arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();

        int recursion = recursion(arr[0], arr[1], arr[2]);
        System.out.println(recursion);

    }

    private static int recursion(int n, int r, int c) {
        if(n==0) return 0;
        int half = 1<<(n-1);
        if(r<half&&c<half) return recursion(n - 1, r, c);
        if(r<half&& c>=half) return half*half + recursion(n-1,r,c-half);
        if(r>=half&& c<half) return 2*half*half + recursion(n-1,r-half,c);
        return 3 * half * half + recursion(n - 1, r - half, c - half);
    }
}
