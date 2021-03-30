package graph;

import java.io.*;
import java.util.StringTokenizer;

public class Boj11403 {
    static int[][] ans;
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        ans = new int[n][n];

        for (int i = 0; i < n; i++) {
            int[][] visited = new int[n][n];
            dfs(graph,visited,i,i);
        }
        StringBuffer sb = new StringBuffer();
        for (int[] ints : ans) {
            for (int e : ints) {
                sb.append(e + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    private static void dfs(int[][] graph, int[][] visited, int target,int start) {
        for (int i = 0; i < graph.length; i++) {
            if(visited[start][i]==1)continue;
            if(graph[start][i]==1) {
                ans[target][i] = 1;
                visited[start][i] = 1;
                dfs(graph, visited,target, i);
            }
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
