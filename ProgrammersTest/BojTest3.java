package com.wonseok.ProgrammersTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BojTest3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(
                System.in
        ));
        //https://www.acmicpc.net/problem/1193
        int X = Integer.parseInt(br.readLine());

        int sum = 0;
        int pos = 1;
        while(sum<X){
            sum+=pos++;
        }
        pos--;
        int namage = sum-X;
        int count = pos-namage;
        if(pos%2==0){
            //(2,1)
            int x = 1;
            for (int i = 0; i <namage-1; i++) {
                pos--;
                x++;
            }
            System.out.println(pos+"/"+x);
        }else {
            //(pos,1)
            int x = 1;
            for (int i = 0; i < count-1; i++) {
                pos--;
                x++;
            }

            System.out.println(pos + "/" + x);
        }


    }
}
