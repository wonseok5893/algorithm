package backtracking;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj18430 {
    static boolean[][] visit;

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    // 왼 아 오 위
    static int[][] possible = new int[][]{{2, 3}, {2, 1}, {0, 1}, {0, 3}};
    static int max = -1;
    static int[][] graph;

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int m = sc.nextInt();
        graph = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        dfs(0, 0, 0);
        System.out.println(max);
    }

    private static void dfs(int y, int x, int sum) {
        if(x==visit[0].length){
            dfs(y+1,0,sum);
            return;
        }
        if(y==visit.length){
            max = Math.max(max, sum);
            return;
        }
        if(visit[y][x]) {
            dfs(y, x + 1, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            boolean poss = true;
            int nextY = 0;
            int nextX = 0;
            for (int j = 0; j < 2; j++) {
                nextY = y + dy[possible[i][j]];
                nextX = x + dx[possible[i][j]];
                if (nextY < 0 || nextX < 0 || nextX >= visit[0].length || nextY >= visit.length
                        || visit[nextY][nextX]) {
                    poss = false;
                    break;
                }
            }
            if (poss) {
                int temp = graph[y + dy[possible[i][0]]][x + dx[possible[i][0]]];
                temp += graph[y + dy[possible[i][1]]][x + dx[possible[i][1]]];
                temp += 2 * graph[y][x];
                visit[y + dy[possible[i][0]]][x + dx[possible[i][0]]] = true;
                visit[y + dy[possible[i][1]]][x + dx[possible[i][1]]] = true;
                visit[y][x] = true;
                sum+=temp;
                dfs(y, x + 1, sum);
                sum-=temp;
                visit[y + dy[possible[i][0]]][x + dx[possible[i][0]]] = false;
                visit[y + dy[possible[i][1]]][x + dx[possible[i][1]]] = false;
                visit[y][x] = false;
            }
        }
        dfs(y, x + 1, sum);
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
