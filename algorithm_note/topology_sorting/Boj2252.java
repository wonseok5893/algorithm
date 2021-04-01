package algorithm_note.topology_sorting;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2252 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] degree = new int[n + 1];
        ArrayList<Integer>[] adj =new ArrayList[n+1];
        for (int i = 1; i < adj.length; i++) {
            adj[i] = new ArrayList<>();

        }
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            adj[from].add(to);
            degree[to]++;
        }

        boolean[] visit = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <=n ; i++) {
            if(degree[i]==0) {
                visit[i] = true;
                queue.offer(i);
            }
        }

        int[] ans = new int[n];
        int ansPos= 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            ans[ansPos++] = now;
            for (int connectNode : adj[now]) {
                while(--degree[connectNode]==0&&!visit[connectNode]) {
                    visit[connectNode] = true;
                    queue.offer(connectNode);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(ans[i] + " ");
        }
        System.out.println(sb);

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
