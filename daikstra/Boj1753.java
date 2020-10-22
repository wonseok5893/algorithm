package com.wonseok.daikstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1753 {
    static StringTokenizer st;
    static final int INF = 100000000;
    static int v,e,startNode;
    static ArrayList<Node>[] graph;
    static int[]distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[]info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        v = info[0];
        e = info[1];
        startNode = Integer.parseInt(br.readLine());
        distance = new int[v+1];
        graph = new ArrayList[v+1];
        Arrays.fill(distance,INF);
        for (int i = 0; i < v+1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end,weight));
        }
        daikstra(startNode);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            if(distance[i] ==INF) sb.append("INF\n");
            else sb.append(distance[i]+"\n");
        }
        System.out.println(sb);

    }

    private static void daikstra(int startNode) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[]check = new boolean[v+1];
        queue.add(new Node(startNode,0));
        distance[startNode] = 0;

        while(!queue.isEmpty()){
            Node next = queue.poll();
            int nextEnd = next.end;
            if(check[nextEnd] == true)continue;
            check[nextEnd] = true;
            for (Node node : graph[nextEnd]) {
                if(distance[node.end]>distance[nextEnd]+node.weight){
                    distance[node.end] = distance[nextEnd]+node.weight;
                    queue.add(new Node(node.end,distance[node.end]));
                }
            }
        }

    }

    private static class Node implements Comparable<Node>{
        int end, weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight-o.weight;
        }
    }
}
