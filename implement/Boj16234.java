package implement;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj16234 {
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static int[][] map;
    static int r;
    static int l;
    static int cnt, sum;
    static boolean[][] visit;
    static ArrayList<int[]> temp = new ArrayList<>();

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int count = 0;
        while (true) {
            boolean move = false;
            visit = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(visit[i][j])continue;
                    dfs(i, j, visit);
                    for (int[] loc : temp) {
                        map[loc[1]][loc[0]] = sum / cnt;
                    }
                    if (temp.size() > 1) {
                        move = true;
                    }
                    sum = 0;
                    cnt = 0;
                    temp.clear();
                }
            }
            if (!move) break;
            else count++;
        }
        System.out.println(count);
    }
    //4 10 50
    //10   50 50
    //50 50 50 50
    //50 50 50 50
    //50 100 50 50

    //10 100
    private static void dfs(int y, int x, boolean[][] visit) {
        visit[y][x] = true;
        sum += map[y][x];
        cnt++;
        temp.add(new int[]{x, y});
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX < 0 || nextY < 0 || nextX >= visit.length || nextY >= visit.length) continue;
            if (visit[nextY][nextX]) continue;
            if (!checkDiff(map[nextY][nextX], map[y][x])) continue;
            dfs(nextY, nextX, visit);
        }

    }

    private static boolean checkDiff(int next, int now) {
        int abs = Math.abs(next - now);
        return abs <= r && abs >= l;
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
