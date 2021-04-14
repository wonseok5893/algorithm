package graph;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj13023 {
    static boolean[] visit;
    static ArrayList<Integer>[] adjList;

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int m = sc.nextInt();
        adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            adjList[start].add(end);
            adjList[end].add(start);
        }
        boolean res = false;
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            visit[i] = true;
            res |= dfs(i, 0);
            visit[i] = false;
            if (res) break;
        }
        if (res) System.out.println(1);
        else System.out.println(0);
    }

    private static boolean dfs(int start, int depth) {
        if (depth == 4) {
            return true;
        }
        boolean res = false;
        for (int i : adjList[start]) {
            if (visit[i]) continue;
            visit[i] = true;
            res |= dfs(i, depth + 1);
            visit[i] = false;
        }
        return res;
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
