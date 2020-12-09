package com.wonseok.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj19645 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(br.readLine());
        Integer[] hamburgers = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            hamburgers[i] = Integer.parseInt(st.nextToken());
        }
        ////
        Arrays.sort(hamburgers,Collections.reverseOrder());
        //50 37 15 13 10 6 4 3 2 2
        // 1 1  50 37 13+10+6+4+2+2
        // 1 2  50 37+15 13+2
        // 2 1  50+37 15
        // 2 2 50+37 15+13
        int max = -1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j <= 10-i; j++) {
                //
                int three = 0;
                int two = 0;
                for (int k = 0; k < i; k++) {
                    three += hamburgers[k];
                }
                for (int k = i; k < i+j; k++) {
                    two += hamburgers[k];
                }
                System.out.print("two: "+two);
                if(two>three) continue;
                int startIdx = i+j;
                int one = findMax(hamburgers, startIdx,two);
                if(max< one) max = one;
            }
        }
        System.out.println(max);
    }

    private static int findMax(Integer[] hamburgers, int startIdx,int two) {
        int n = hamburgers.length;
        int[]dp = new int[n];
        for (Integer hamburger : hamburgers) {
            System.out.print(hamburger+" ");
        }
        System.out.println();
        System.out.println(startIdx+"인덱스부터 시작");
        for (int i = startIdx; i < n; i++) {
            if(dp[i]<dp[i-1]+hamburgers[i]&&dp[i-1]+hamburgers[i]<=two) {
                dp[i]= dp[i-1]+hamburgers[i];
            }
            else dp[i] = dp[i-1];
            for (int e : dp) {
                System.out.print(e+" ");
            }
            System.out.println();
        }
        return dp[n-1];
    }
}
