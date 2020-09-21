package com.wonseok.backtracking;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
//문제에서는 오름차순 / 코드는 내림차순
public class Boj15650 {
    static int[] isUsed;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        isUsed = new int[arr[0] + 1];

        backTracking(arr[0], arr[1],999);
    }


    private static void backTracking(int n, int m,int temp) {
        if (m == 0) {
            System.out.println(sb);
        }
        for (int i = n; i >= 1; i--) {
            if (isUsed[i] == 1) continue;
            if (temp <= i) continue;
            isUsed[i] = 1;
            sb.append(i+" ");
            temp = i;
            backTracking(n, m - 1,temp);
            sb.delete(sb.length() - 2, sb.length());
            isUsed[i] = 0;
        }
    }
}
