package dfs;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1261 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }
        int[][] visit = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visit[i], Integer.MAX_VALUE);
        }
        Queue<int[]> queue = new LinkedList<>();
        visit[0][0] = 0;
        queue.offer(new int[]{0, 0});
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];
                if(nextX<0||nextY<0||nextX>=m||nextY>=n) continue;
                if(map[nextY][nextX]==1) {
                    if (visit[nextY][nextX] <= visit[now[1]][now[0]] + 1) continue;
                    visit[nextY][nextX] = visit[now[1]][now[0]] + 1;
                }else{
                    if (visit[nextY][nextX] <= visit[now[1]][now[0]]) continue;
                    visit[nextY][nextX] = visit[now[1]][now[0]];
                }
                if(nextX==m&&nextY==n) continue;
                queue.offer(new int[]{nextX, nextY});
            }
        }
        System.out.println(visit[n-1][m-1]);
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
