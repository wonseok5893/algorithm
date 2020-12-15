package com.wonseok.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1043 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[]people = new int[n+1];
        st = new StringTokenizer(br.readLine()," ");
        int k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < k; i++) {
            people[Integer.parseInt(st.nextToken())]=1;
        }
        int sum= 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int count = Integer.parseInt(st.nextToken());
            int[]arr = new int[count];
            for (int j = 0; j < count; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            //

        }
    }
}
