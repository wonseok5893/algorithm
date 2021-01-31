package com.wonseok.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;
import java.util.stream.Collectors;

public class Boj10597 {
    static int[] visited;
    static int n;
    static int len;
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        len = str.length();
        if (len > 9) {
            n = 9 + (len - 9) / 2;
        } else n = len;
        visited = new int[n + 1];
        pickNum(str, -1,"",new ArrayList<>());
        System.out.println(list.get(0));


    }

    private static void pickNum(String str, int start, String before,ArrayList<String> res) {
        if (res.size() == n) {
            list.add(res.stream().collect(Collectors.joining(" ")));
            return;
        }
        if(start+1>=len)return;
        // 1자리 뽑는 경우
        int onePick = Integer.parseInt(str.substring(start + 1, Math.min(start + 1 + 1, len)));
        if (onePick>0&&onePick <= n && visited[onePick] == 0) {
            visited[onePick] = 1;
            String strPick = String.valueOf(onePick);
            res.add(strPick);
            pickNum(str, start + 1,strPick, res);
            visited[onePick] = 0;
            res.remove(String.valueOf(onePick));
        }
        if(start+1>len-1)return;
        //10자리 뽑는 경우
        int twoPick = Integer.parseInt(str.substring(start + 1, Math.min(start + 1 + 2, len)));
        if (twoPick > 9 && twoPick <= n && visited[twoPick] == 0) {
            visited[twoPick] = 1;
            String strPick = String.valueOf(twoPick);
            res.add(String.valueOf(twoPick));
            pickNum(str, start + 2,strPick, res);
            visited[twoPick] = 0;
            res.remove(String.valueOf(twoPick));
        }

    }
/*
    private static String makeRandom(int n) {
        int[] visited = new int[n + 1];
        int count = 0;
        String res = "";
        Random random = new Random();
        while (count != n) {
            int rand = random.nextInt(n) + 1;
            if (visited[rand] != 1) {
                visited[rand] = 1;
                res += rand;
                count++;
            }
        }
        return res;
    }
    */
}
