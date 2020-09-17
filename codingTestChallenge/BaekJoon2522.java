package com.wonseok.codingTestChallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon2522 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n-i;j++)
                System.out.print(" ");
            for(int k = 0; k < i;k++)
                System.out.print("*");
            System.out.println("");
        }
        for (int i = 1; i <= n; i++) {
            for(int k = 0; k < i;k++)
                System.out.print(" ");
            for (int j = 0; j < n-i;j++)
                System.out.print("*");
            System.out.println("");
        }
    }
}
