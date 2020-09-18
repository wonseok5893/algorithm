package com.wonseok.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Boj1697 {
    static int[] d = new int[100001];
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        //수빈이가 갈수있는 가짓수
        Arrays.fill(d,-1);
        d[n]=0;
        queue.offer(n);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next:new int[]{now+1,now-1,2*now}) {
                if(next<0||next>100000) continue;
                if(d[next]!=-1) continue;
                d[next] = d[now]+1;
                queue.offer(next);
            }
        }


            System.out.print(d[k]);


    }

}
