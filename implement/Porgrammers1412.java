package com.wonseok.implement;

import java.util.Arrays;

public class Porgrammers1412 {
    public static void main(String[] args) {

    }
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int posA =0;
        int posB = 0;
        int count = 0;
        while(posB<B.length) {
            if(A[posA]<B[posB]){
                count++;
                posA++;
                posB++;
                continue;
            }else{
                posB++;
            }
        }
        return count;
    }
}
