package com.wonseok.kakao.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Problem8 {
    public static void main(String[] args) {
        //https://programmers.co.kr/learn/courses/30/lessons/17687
         new Problem8().solution(16,16,2,2);

    }

    public String solution(int n, int t, int m, int p) {
        // m*t
        char[] arr = new char[m * t];
        int count = 0;
        int num = 0;
        while (count < arr.length) {
            // 진법으로 만들어
            ArrayList<Character> tempArr = makeBinary(num, n);
            for (Character c : tempArr) {
                arr[count] = c;
                count++;
                if (count == arr.length)
                    break;
            }
            num++;
        }
        StringBuilder sb = new StringBuilder();
        int selectPos = p-1;
        while(t>0){
            sb.append(arr[selectPos]);
            selectPos+=m;
            t--;
        }

        return sb.toString();

    }

    private ArrayList<Character> makeBinary(int count, int n) {

        ArrayList<Character> list = new ArrayList<>();
        if (n > 10) {
            while (count >= n) {
                if (count % n >= 10) {
                    list.add((char) (count % n - 10 + 'A'));
                } else {
                    list.add((char) (count % n + '0'));
                }
                count /= n;
            }
            if (count >= 10) {
                list.add((char) (count - 10 + 'A'));
            } else {
                list.add((char) (count + '0'));
            }
        } else {
            while (count >= n) {
                list.add((char) (count % n + '0'));
                count /= n;
            }
            list.add((char) (count + '0'));
        } Collections.reverse(list);
        return list;
    }

}
