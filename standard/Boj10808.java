package com.wonseok.standard;

//알파벳 소문자로만 이루어진 단어 S가 주어진다.
// 각 알파벳이 단어에 몇 개가 포함되어 있는지 구하는 프로그램을 작성하시오.



import java.io.IOException;

import java.util.Scanner;


public class Boj10808 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int[] alpabets = new int[26];

        for (int i = 0; i < str.length(); i++) {
            alpabets[str.charAt(i) - 97]++;
        }
        for (int e : alpabets) {
            System.out.print(e + " ");
        }

    }
}
