package com.wonseok.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon6603 {
    static StringTokenizer st;
/*
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), "");

        while (true) {
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;

            int[] items = new int[n];
            int pos = 0;
            while (st.hasMoreTokens()) {
                items[pos++] = Integer.parseInt(st.nextToken());
            }
            int level = 0;
            backTracking(items, level);
        }


    }

    private static void backTracking(int[] items, int level) {
        if (level == items.length - 6) {
            for (int i = level; i < items.length; i++)
                System.out.println(items[i]);
        } else {
            for (int i = level; i < items.length; i++) {
                for (int j = 5; j > 0; j--) {
                    System.out.println(items[5-j]+" ");

                }
            }
        }
        backTracking(items, ++level);
    }
}
*/
}
