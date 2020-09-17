package com.wonseok.stack;

import java.util.Scanner;
import java.util.Stack;

public class Boj10799 {
    static Stack<String> openStack = new Stack<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(checkStr(str));
    }

    private static int checkStr(String str) {
        int count = 0;
        String before = "";
        for (int i = 0; i < str.length(); i++) {
            String s = Character.toString(str.charAt(i));
            if (s.equals("(")) {
                openStack.push("(");
            } else if (s.equals(")")) {
                if(before.equals("(")) {
                    openStack.pop();
                    count += openStack.size();
                }else { count++;
                    openStack.pop();
                }
            }
            before = s;
        }
        return count;
    }
}
