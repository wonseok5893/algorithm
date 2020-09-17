package com.wonseok.codingTestChallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import java.util.StringTokenizer;

//N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에
// X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.
public class BaekJoon1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int[] values = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        StringTokenizer st1 = new StringTokenizer(br.readLine()," ");
        int[] comp = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        Arrays.sort(values);
        for (int e : comp) {
            boolean result = recursion(values, e);
            if (result) System.out.println(1);
            else System.out.println(0);
        }
    }

    private static boolean recursion(int[] values,int e) {
        int start = 0;
        int end = values.length-1;

        while(start<=end){
        int mid = (start+end)/2;
        if(values[end]<e||values[start]>e)return false;
        else if(values[mid]==e) return true;
        else if(values[mid]>e) end = mid;
        else  start = mid;
        }
        return false;
    }

}
