package com.wonseok.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고,
// 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
public class BaekJoon1260 {
    //bfs 먼저
    static Queue<Integer> queue = new LinkedList<>();
    static Stack<Integer> stack = new Stack<>();
    static int[] visited;

    public static void main(String[] args) throws IOException {
        List<List<Integer>> graph = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int node = Integer.parseInt(st.nextToken());
        int line = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        //그래프 초기 구성
        for (int i = 0; i < node + 1; i++) graph.add(new ArrayList<>());
        //그래프
        for (int i = 0; i < line; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            int first = Integer.parseInt(st1.nextToken());
            int second = Integer.parseInt(st1.nextToken());

            graph.get(first).add(second);
            graph.get(second).add(first);

        }
        visited = new int[node + 1];
        //dfs
        dfs(graph, start);
        System.out.println("");
        visited = new int[node + 1];
        //bfs
        bfs(graph, start);

    }

    private static void dfs(List<List<Integer>> graph, int start) {
        int i = 0;
        System.out.print(start + " ");
        visited[start] = 1;

        for (i = 1; i <= graph.size(); i++)
            if (graph.get(start).contains(i) && visited[i] == 0) {
                visited[i] = 1;
                dfs(graph, i);
            }
        if (i == graph.size() + 1) return;
    }

    private static void bfs(List<List<Integer>> graph, int start) {
        queue.offer(start);
        while (!queue.isEmpty()) {
            int index = queue.poll();
            visited[index] = 1;
            int pos = 0;
            while (pos < graph.get(index).size()) {
                Collections.sort(graph.get(index));
                int addNode = graph.get(index).get(pos++);
                if (visited[addNode] != 1 && !queue.contains(addNode))
                    queue.offer(addNode);
            }
            System.out.print(index + " ");
        }
    }

}
