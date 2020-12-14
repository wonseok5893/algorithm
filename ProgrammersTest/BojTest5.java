package com.wonseok.ProgrammersTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BojTest5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(
                System.in
        ));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        arr =  Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        tripleSorting(arr);
        boolean result = true;
        for (int i = 0; i < n; i++) {
            if(arr[i]!=i+1){
                result=false;
                break;
            }
        }
        if(result) System.out.println("YES");
        else System.out.println("NO");
    }

    private static void tripleSorting(int[] arr) {
        int count= 0;
        for (int i = 1; i < arr.length-1; i++) {
            //
            if(arr[i-1]>arr[i+1])
            {
                int temp = arr[i-1];
                arr[i-1] = arr[i+1];
                arr[i+1] = temp;
                count++;
            }
        }
        if(count==0)return;
        else tripleSorting(arr);
    }
}
