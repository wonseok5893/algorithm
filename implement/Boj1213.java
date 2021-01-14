package com.wonseok.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Boj1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[26];
        String str = br.readLine();
        char[] charArr = str.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            arr[(int) charArr[i] - 'A']++;
        }
        String res = "";
        if (str.length() % 2 == 0) {
            boolean result = true;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 2 != 0) {
                    result = false;
                    break;
                }
            }
            if (result) {
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] != 0)
                        for (int j = 0; j < arr[i]; j++)
                            res += (char) (i + 'A');

                }
            } else {
                res += "I'm Sorry Hansoo";
            }
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            int count = 0;
            int pos = -1;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 2 != 0) {
                    count++;
                    pos = i;
                }else if(arr[i]!=0)list.add(i);
            }
            for(int e: list) System.out.print(e+" ");
            if (count == 1) {
               
            } else {
                res += "I'm Sorry Hansoo";
            }
            System.out.println(res);
        }

    }
}
