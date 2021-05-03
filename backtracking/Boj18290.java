package backtracking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj18290 {
    static int k;
    static int[][] graph;
    static int[][] visit;

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int m = sc.nextInt();
        k = sc.nextInt();
        graph = new int[n][m];
        visit = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = sc.nextInt();
            }
        }


        dfs( 0, 0);

        System.out.println(max);
    }

    static int max = Integer.MIN_VALUE;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    private static void dfs(int cnt, int sum) {

        if (cnt == k) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < visit.length; i++) {
            for (int j = 0; j < visit[0].length; j++) {
                if (visit[i][j]>=1) continue;
                visit[i][j]++;
                sum += graph[i][j];
                for (int k = 0; k < 4; k++) {
                    if (i + dy[k] < 0 || i + dy[k] >= visit.length || j + dx[k] < 0 || j + dx[k] >= visit[0].length)
                        continue;
                    visit[i + dy[k]][j + dx[k]]++;
                }
                dfs( cnt + 1, sum);
                sum -= graph[i][j];
                visit[i][j]--;
                for (int k = 0; k < 4; k++) {
                    if (i + dy[k] < 0 || i + dy[k] >= visit.length || j + dx[k] < 0 || j + dx[k] >= visit[0].length)
                        continue;
                    visit[i + dy[k]][j + dx[k]]--;
                }
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
