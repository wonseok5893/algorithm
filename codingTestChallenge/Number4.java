package com.wonseok.codingTestChallenge;

import jdk.nashorn.internal.objects.NativeJSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Number4 {
    public static void main(String[] args) {
        int[][] arr = {{0,1,0},{1,1,1},{1,1,0},{0,1,1}};
        solution(arr);
    }
        public static int solution(int[][] a) {
           int heng = a.length;
           int yeol = a[0].length;

           //행렬의 그림 test
            for (int[] ints : a) {
                for (int e : ints) {
                    System.out.print(e+ "");
                }
                System.out.println();
            }

            for(int i=0; i<heng;i++) {
                if( a[i][0] ==1){};
            }


        return 0;
        }

   static boolean check(int[][] a) {
        for(int i=0;i<a[0].length;i++){
           if(Arrays.stream(a[i]).sum()%2==0){
               return true;
           }
        }
        return false;
    }




}
