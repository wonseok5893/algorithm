package com.wonseok.standard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Boj10871 {
        static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        int[] arr = new int[n];
        int pos = 0;
        while(st.hasMoreTokens()){
            arr[pos++] = Integer.parseInt(st.nextToken());
        }
        //
        StringBuilder sb = new StringBuilder();

        for (int i : arr) {
            if(i<x) sb.append(i+" ");
        }
        System.out.println(sb);
    }
}
