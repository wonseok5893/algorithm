/*
package com.wonseok.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Boj1991 {
    static Map<String, String[]> tree = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < nodeCount; i++) {
            String[] tempArr = br.readLine().split(" ");
            tree.put(tempArr[0],new String[]{tempArr[1],tempArr[2]});
        }
        String rootNum = "A";
        frontCycle()

    }
}
*/