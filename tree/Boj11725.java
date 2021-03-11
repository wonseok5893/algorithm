package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj11725 {
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        }
        parents = new int[n + 1];
        dfs(graph, 1, 0);

        StringBuffer sb = new StringBuffer();
        for (int i = 2; i <=n; i++) {
            sb.append(parents[i] + "\n");
        }
        System.out.println(sb);
    }

    private static void dfs(ArrayList<Integer>[] graph, int start, int parent) {
        parents[start] = parent;
        for (int next : graph[start]) {
            if(next!=parent)
            dfs(graph, next, start);
        }
    }
}
