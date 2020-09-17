package com.wonseok.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon18352 {

    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited = new boolean[300001];
    static Queue<Integer> queue = new LinkedList<Integer>();
    static int[] distance = new int[300001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Arrays.fill(visited, false);
        int[] info = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i <= info[1]; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < info[1]; i++) {
            int[] addInfo = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            graph.get(addInfo[0]).add(addInfo[1]);
        }
        queue.offer(info[3]);
        bfs(info[3]);
        boolean check = false;
        for (int i = 0; i < info[0]; i++) {
            if (distance[i] == info[2]) {
                System.out.println(i);
                check = true;
            }
        }
        if(check ==false)
            System.out.println(-1);
    }

    private static void bfs(int i) {
        while (!queue.isEmpty()) {
            visited[i] = true;
            int now = queue.poll();
            System.out.println(now);
            for (Integer e : graph.get(now)) {
                if (visited[e] == false) {
            System.out.println(e);

                    distance[e] = distance[now] + 1;
                    queue.offer(e);
                }
            }
        }
    }

}
