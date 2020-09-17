package com.wonseok.binarysearch;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BaekJoon10816 {
    static StringTokenizer st;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), "");
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] values = new int[n];
        int pos = 0;
        while (st.hasMoreTokens()) values[pos++] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), "");
        int m = Integer.parseInt(st.nextToken());


        Arrays.sort(values);

        pos = 0;
        st = new StringTokenizer(br.readLine(), " ");
        int[] compares = new int[m];
        while (st.hasMoreTokens()) compares[pos++] = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int compare : compares) {
            count = 0;
            wonseokSearch(values, 0, values.length, compare);
            sb.append(count + " ");
        }
        System.out.println(sb);


    }

    private static void wonseokSearch(int[] values, int start, int end, int compare) {
        int mid = (start + end) / 2;
        if (start >= end) {
            return;
        }
        if (values[mid] == compare) {
            count++;
            wonseokSearch(values, start, mid, compare);
            wonseokSearch(values, mid + 1, end, compare);
        } else if (values[mid] > compare) {
            wonseokSearch(values, start, mid, compare);
        } else {
            wonseokSearch(values, mid + 1, end, compare);
        }
    }


}
