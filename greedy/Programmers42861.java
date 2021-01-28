package com.wonseok.greedy;

import java.util.ArrayList;

public class Programmers42861 {
    //https://programmers.co.kr/learn/courses/30/lessons/42861
    public static void main(String[] args) {
        new Programmers42861().solution(4
                ,new int[][]{{0,1,1},{0,2,2},{1,2,5},
                        {1,3,1},{2,3,8}});
    }
    static int min = 1000000007;
    static ArrayList<int[]>[] lists;
    public int solution(int n, int[][] costs) {
        lists = new ArrayList[n];
        for(int i =0;i<n;i++){
            lists[i] = new ArrayList<int[]>();
        }
        for(int[] cost : costs){
            lists[cost[0]].add(new int[]{cost[1],cost[2]});
            lists[cost[1]].add(new int[]{cost[0],cost[2]});
        }
        for(int i=0;i<n;i++){
            int[] visited = new int[n];
            dfs(i,visited,0,0);
        }
        System.out.println(min);
        return min;
    }
    public void dfs(int start, int[]visited,int sum ,int count){
        if(count==visited.length){
            min = Math.min(min,sum);
            return;
        }
        if(visited[start]!=0) return;
        visited[start] = 1;
        //deepcopu
        int pos = 0;
        int[] temp  = new int[visited.length];
        for (int visit : visited) {
            temp[pos++] = visit;
        }
        for(int[]next: lists[start]){
            dfs(next[0],temp,sum+next[1],count+1);
        }
    }
}
