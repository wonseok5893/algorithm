package com.wonseok.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj9012 {
    static Stack<String> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        for (String s : arr) {
            String[] split = s.split("");
            boolean result = true;
            stack = new Stack<>();
            for (String s1 : split) {
                if (s1.equals("(")) stack.push("(");
                else {
                    if (stack.size() == 0) {
                        result = false;
                        break;
                    }else{
                        stack.pop();
                    }
                }
            }
            if(stack.size()!=0) result = false;
            if(result) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
