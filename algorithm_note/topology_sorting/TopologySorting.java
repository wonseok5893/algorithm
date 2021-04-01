package algorithm_note.topology_sorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologySorting {
    public static void main(String[] args) {
        // 노드 개수
        int n = 3;
        // 간선 개수
        int m = 2;
        // 0부터 n까지 노드
        // 간선 정보들
        int[][] edges = new int[m][2];
        edges[0][0] = 1;
        edges[0][1] = 3;
        edges[1][0] = 2;
        edges[1][1] = 3;

        // 인접 리스트
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            adj[i] = new ArrayList<>();
        }
        topologySort(edges, adj,n);
    }

    private static void topologySort(int[][] edges, ArrayList<Integer>[] adj,int n) {
        int[] degree = new int[n+1];
        boolean[] visit = new boolean[n+1];
        // 인접리스트 , 진입 차수 갱신
        for (int[] edge : edges) {
            degree[edge[1]]++;
            adj[edge[0]].add(edge[1]);
        }
        //진입 차수 0인 점을 큐에 삽입
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if(degree[i]==0){
                visit[i] = true;
                queue.offer(i);
            }
        }
        //큐에서 원소를 꺼내 연결된 모든 간선을 지운다
        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.println(now);
            for (int connectNode : adj[now]) {
                if(--degree[connectNode]==0&&!visit[connectNode]) {
                    visit[connectNode] = true;
                    queue.offer(connectNode);
                }
            }
        }
        //모든 원소를 돌기전에 멈춘다면 ->
        // 사이클이 존재한다!
    }


}
