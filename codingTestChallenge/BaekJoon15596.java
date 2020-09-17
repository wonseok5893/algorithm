package com.wonseok.codingTestChallenge;

//정수 n개가 주어졌을 때, n개의 합을 구하는 함수를 작성하시오.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BaekJoon15596 {

    public static void main(String[] args) throws IOException {
        int[] arr = {1,2,3};
        System.out.println(sum(arr));
    }
    static long sum(int[] a){
        long sum =0;
        for (int i : a) {
            sum+=i;
        }
        return sum;

    }
}
