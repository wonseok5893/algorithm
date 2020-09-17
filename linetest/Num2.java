package com.wonseok.linetest;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Num2 {
    static ArrayList<Integer> arr = new ArrayList<>();
    static int resultCount = 0;
    public static void main(String[] args) {

    }
    public int[] solution(int n) {
        int len = 0;
        int count =0;
        double num;
        while(true){
            while(true){
                if(n/10==0){
                    arr.add(n%10);
                    break;
                }
                arr.add(n%10);
                n=n/10;
            }
            num =0;
            Collections.reverse(arr);

            for (Integer e : arr) {
                if(e==0)
                    resultCount++;
                else{
                    num = num+3;
                }
            }
        }


    }
}
