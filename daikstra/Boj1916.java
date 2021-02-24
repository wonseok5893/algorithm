package daikstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        final int INF = (int) 1e9;

        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        ArrayList<Node>[] graph = new ArrayList[v + 1];

        for (int i = 0; i < v + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, weight));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] distance = new int[v + 1];
        boolean[] visited = new boolean[v + 1];
        for (int i = 0; i < v + 1; i++) {
            if (i != start) {
                distance[i] = INF;
            }
        }

        // 갱신해나가는 과정
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (visited[poll.end]) continue;
            visited[poll.end] = true;
            for (Node next : graph[poll.end]) {
                if (distance[next.end] > distance[poll.end] + next.weight) {
                    distance[next.end] = distance[poll.end] + next.weight;
                    queue.offer(new Node(next.end, distance[next.end]));
                }
            }
        }

        System.out.println(distance[end]);


    }

    private static class Node implements Comparable<Node> {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return o.weight - weight;
        }
    }
}
