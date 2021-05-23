package baekjoon가희1회대회;

import java.io.*;
import java.util.StringTokenizer;

public class Num2 {
    static char[][] map;
    static int t;

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int m = sc.nextInt();
        t = sc.nextInt();
        map = new char[n][m];
        int[] start = null;
        for (int i = 0; i < n; i++) {
            char[] arr = sc.nextLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = arr[j];
                if (map[i][j] == 'G') start = new int[]{j, i};
            }
        }
        map[start[1]][start[0]] = '.';
        dfs(start[0], start[1], 0, 0);
        System.out.println(max);
    }

    static int max = 0;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    private static void dfs(int x, int y, int cnt, int eaten) {
        if (cnt == t) {
            max = Math.max(eaten, max);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX < 0 || nextY < 0 || nextX >= map[0].length || nextY >= map.length) continue;
            if (map[nextY][nextX] == '#') continue;
            if (map[nextY][nextX] == 'S') {
                map[nextY][nextX] = '.';
                dfs(nextX, nextY, cnt + 1, eaten + 1);
                map[nextY][nextX] = 'S';
            } else if (map[nextY][nextX] == '.')
                dfs(nextX, nextY, cnt + 1, eaten);

        }
        dfs(x, y, cnt + 1, eaten);
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
