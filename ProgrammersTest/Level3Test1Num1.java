package com.wonseok.ProgrammersTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Level3Test1Num1 {
    public static void main(String[] args) {
        new Level3Test1Num1().solution(6, new int[][]{{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5 ,6,1}}, 3);
    }
    public int solution(int N, int[][] road, int K) {
        int[] distance = new int[N + 1];
        int[] visited = new int[N + 1];
        ArrayList<Node>[] list = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int[] info : road) {
            list[info[0]].add(new Node(info[1], info[2]));
            list[info[1]].add(new Node(info[0], info[2]));
        }
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[0] = 0;
        distance[1] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(1,0));
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int num = poll.toNum;
            visited[num]=1;
            for (Node node : list[num]) {
                if (distance[node.toNum] > distance[num] + node.value) {
                    distance[node.toNum] = distance[num] + node.value;
                    queue.offer(node);
                }
            }
        }
        int ans = 0;
        for (int i = 1; i < distance.length; i++) {
            System.out.println(distance[i]);
            if(distance[i]!=-1&&distance[i]<=K)ans++;
        }
        return ans;
    }

    private class Node implements Comparable<Node> {
        int toNum;
        int value;

        public Node(int toNum, int value) {
            this.toNum = toNum;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return value-o.value;
        }
    }
}
