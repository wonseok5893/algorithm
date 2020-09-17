package com.wonseok.stack;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj4949 {
    public static void main(String[] args) throws IOException {
        Stack<String> openStack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str = br.readLine();
            if (str.equals(".")) break;
            if (checkStr(openStack, str)) System.out.println("yes");
            else System.out.println("no");
            openStack.clear();
        }

    }

    private static Boolean checkStr(Stack<String> openStack, String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            String now = Character.toString(str.charAt(i));
            if (now.equals("(")
                    || now.equals("["))
                openStack.push(now);
            else if (now.equals(")")
                    || now.equals("]")) {
                if (openStack.size() == 0) {
                    return false;
                } else {
                    String top = openStack.peek();
                    if (top.equals("(") && now.equals(")")
                            || top.equals("[") && now.equals("]")) {
                        openStack.pop();
                        continue;
                    } else
                        return false;
                }
            } else continue;
        }
        if(openStack.size()==0)
        return true;
        else return false;
    }
}

