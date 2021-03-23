package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj20168 {
    static ArrayList<int[]>[] graph;
    static int a, b, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[start].add(new int[]{end, weight});
            graph[end].add(new int[]{start, weight});
        }

        int[] visited = new int[n + 1];
        visited[a] = 1;
        dfs(a, 0, visited, -1);
        System.out.println(ans==INF?-1:ans);
    }
    static final int INF = (int) 1e9;
    static int ans = INF;

    private static void dfs(int start, int sum, int[] visited, int maxWeight) {
        if (start == b) {
            ans = Math.min(ans, maxWeight);
            return;
        }
        for (int[] next : graph[start]) {
            if (visited[next[0]] != 0) continue;
            if (sum + next[1] > c) continue;
            int temp = maxWeight;
            visited[next[0]] = 1;
            maxWeight = Math.max(maxWeight, next[1]);
            dfs(next[0], sum + next[1], visited, maxWeight);
            maxWeight = temp;
            visited[next[0]] = 0;
        }
    }
}
