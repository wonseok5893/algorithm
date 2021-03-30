package graph;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOj11725 {
    static int[]parent ;
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        ArrayList<Integer>[] graph =new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n-1; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            graph[start].add(end);
            graph[end].add(start);
        }
        parent = new int[n + 1];
        dfs(graph, new int[n + 1], 1);
        for (int i = 2; i <=n ; i++) {
            System.out.println(parent[i]);
        }
    }

    private static void dfs(ArrayList<Integer>[] graph, int[] visited, int start) {
        for (Integer num : graph[start]) {
            if(visited[num]!=0) continue;
            parent[num] = start;
            visited[num] = 1;
            dfs(graph, visited, num);
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
