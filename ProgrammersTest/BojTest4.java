package com.wonseok.ProgrammersTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BojTest4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(
                System.in
        ));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] =br.readLine();
            }
            String result = "";
            if(arr.length==1) System.out.println(arr[0]);
            else {
                int len = arr[0].length();
                for (int i = 0; i < len; i++) {
                    char c = arr[0].charAt(i);
                    boolean bool = true;
                    for (int j = 1; j < n; j++) {
                        if(c!=arr[j].charAt(i)){
                            bool = false;
                            break;
                        }
                    }
                    if(bool)result+=c;
                    else result+="?";
                }
                System.out.println(result);
            }

    }
}
