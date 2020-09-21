package com.wonseok.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj1629 {
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong)
                .toArray();

        System.out.println(recursion(arr[0], arr[1]));
    }

    private static long recursion(long a, long b) {
        if(b==1) return a%arr[2];
        long value = recursion(a, b/2);
        value = value * value %arr[2];
        if(b%2==0) return value;
        return value*a%arr[2];
    }
}
