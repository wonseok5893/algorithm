package com.wonseok.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int length = str.length();

        int count0 = 0, count1 = 0;

        //1로바꾸는 경우 0으로바꾸는경우
        char start = str.charAt(0);
        if(start =='1'){
            //첫 1로 시작
            count0++;
        }else{
            //첫 0로 시작
            count1++;
        }

        for (int i = 1; i < length; i++) {
            char temp = str.charAt(i);
            if(start == temp) continue;
            else{
                start = temp;
                if(start=='1')
                    count0++;
                else
                    count1++;
            }
        }
        System.out.println(count0>count1?count1:count0);
    }
}
