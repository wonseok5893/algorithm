package dfs;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj14500 {
    static boolean[][]visit;
    static int[][]graph;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{ 0, 1, 0,-1};
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int m = sc.nextInt();
        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(i, j, 0, 0);
                exception(i, j);
            }
        }
        System.out.println(max);
    }

    private static void exception(int y, int x) {
        int cnt = 4;
        int sum = graph[y][x];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(nextY<0||nextX<0||nextX>=visit[0].length||nextY>=visit.length) {
                cnt--;
                continue;
            }
            sum += graph[nextY][nextX];
            min = Math.min(min,graph[nextY][nextX]);
        }
        if(cnt<=2) return;
        if(cnt==4){
            sum -= min;
        }
        max = Math.max(sum,max);
    }

    static int max = 0;
    private static void dfs(int y, int x, int cnt, int sum) {
        if(cnt==4){
            max = Math.max(sum, max);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(nextX<0||nextY<0||nextX>=visit[0].length||nextY>=visit.length) continue;
            if(visit[nextY][nextX])continue;
            visit[nextY][nextX] = true;
            dfs(nextY, nextX, cnt + 1, sum + graph[nextY][nextX]);
            visit[nextY][nextX] = false;
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
