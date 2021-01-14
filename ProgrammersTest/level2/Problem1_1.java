package com.wonseok.ProgrammersTest.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Problem1_1 {
    public static void main(String[] args) {
        System.out.println(new Problem1_1().solution("JAZ"));
    }

    public int solution(String name) {

        char[] chars = name.toCharArray();
        int[] arr = new int[name.length()];

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int up = getUp((int) c - 65, 0);
            int down = getDown((int) c - 65, 0);
            int min = Math.min(up, down);
            arr[i] = min;
        }
        //3 10 0 9 0 6
        // 6 0 8 0 0 0 0 6
        //3 4 5 6

        int sum = Arrays.stream(arr).sum();
        int min = sum+arr.length-1;
        ArrayList<int[]> lists = new ArrayList<>();
        int start = -1;
        int end = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                if (start == -1) start = i;
                end = i;
            } else {
                if (start != -1 && end != -1)
                    lists.add(new int[]{start, end});
                start = -1;
                end = -1;
            }
        }

        for (int[] list : lists) {

            int diff = 0;
            if(list[0]<=1){
                diff = arr.length-1-list[1];

                min = Math.min(min,sum+diff);
            }
            if(list[1]==arr.length-1){
                diff = arr.length-1 -(list[1]-list[0]+1);
                min = Math.min(min,sum+diff);
            }
            if(list[0]>1){
                diff = 2*(list[0]-1) + arr.length-1-list[1];
                min = Math.min(min,sum+diff);
            }
        }
        return min;
    }

    private int getDown(int e, int nowPos) {
        int ans = 0;
        while (nowPos != e) {
            nowPos = getMinus(nowPos);
            ans++;
        }
        return ans;
    }

    private int getMinus(int nowPos) {

        if (nowPos == 0) return 25;
        else return nowPos - 1;
    }

    private int getUp(int e, int nowPos) {

        int ans = 0;
        while (nowPos != e) {
            nowPos = getPlus(nowPos);
            ans++;
        }
        return ans;
    }

    private int getPlus(int nowPos) {
        if (nowPos == 25) return 0;
        else return nowPos + 1;
    }
}
