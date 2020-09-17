package com.wonseok.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Boj2504 {

    static Stack<String> openStack;
    static List<String> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int answer = checkStr(str);
        System.out.println(answer);
    }

    private static int checkStr(String str) {
        //점수 초기화
        int result1 = 0;
        //올바른 괄호열로 나눈다.
        arr = divide(str);
        if (arr == null) return 0;
        if (arr.size() >= 1) {
            for (String s : arr) {
                result1 += getScore(s);
            }
        }
        return result1;
    }

    //점수 주는 방법
    private static int getScore(String str) {
        if (str.equals("()")) return 2;
        else if (str.equals("[]")) return 3;
        else if (Character.toString(str.charAt(0)).equals("("))
            return 2 * checkStr(str.substring(1, str.length() - 1));
        else if (Character.toString(str.charAt(0)).equals("["))
            return 3 * checkStr(str.substring(1, str.length() - 1));
        return 0;
    }

    //올바른 문자열들로 나누는 과정
    private static List<String> divide(String str) {
        openStack = new Stack<>();
        arr = new ArrayList<>();
        int pos = 0;
        if (str.length() == 0) return null;
        for (int i = 0; i < str.length(); i++) {
            String add = Character.toString(str.charAt(i));
            if (add.equals("(") || add.equals("[")) openStack.push(add);
            else if (add.equals(")")) {
                if(openStack.size()>=1) {
                    if (openStack.peek().equals("(")) openStack.pop();
                else return null;
                }else return null;
            } else if (add.equals("]")) {
                if(openStack.size()>=1) {
                    if (openStack.peek().equals("[")) openStack.pop();
                    else return null;
                }else return null;
            }

            //스택이 0이면 substring
            if (openStack.size() == 0 && i != 0) {
                String u = str.substring(pos, i + 1);
                arr.add(u);
                pos = i + 1;
            }
        }
        if (openStack.size() != 0) return null;
        return arr;
    }


}
