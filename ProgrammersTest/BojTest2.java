package com.wonseok.ProgrammersTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BojTest2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(
                System.in
        ));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int count = 0;
            int tempCount = 0;
            String s = br.readLine();
            char[] chars = s.toCharArray();
            for (char e : chars) {
                if(e=='O'){
                    tempCount++;
                    count += tempCount;
                }else
                    tempCount=0;
            }
            System.out.println(count);
        }
    }
}
