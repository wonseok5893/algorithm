package com.wonseok.ProgrammersTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BojTest1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(
                System.in
        ));

       int[] arr =  Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
       if(arr[0]>arr[1]) System.out.println(">");
       else if(arr[0]==arr[1]) System.out.println("==");
       else System.out.println("<");
    }
}
