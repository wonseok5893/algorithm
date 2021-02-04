package com.wonseok.graph.위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] info = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] indegree = new int[info[0]+1];
        for (int i = 0; i < info[1]; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            indegree[second]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        while(!queue.isEmpty()){
            for (int i = 1; i <= info[0]; i++) {
                if(indegree[i]==0) {
//                    queue.offer()
                }
            }
        }
    }
}
