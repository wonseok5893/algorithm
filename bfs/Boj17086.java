package bfs;

import java.io.*;
import java.util.*;

public class Boj17086 {
    static int[][] map;

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int m = sc.nextInt();
        map = new int[n][m];
        ArrayList<Shark> sharks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) sharks.add(new Shark(j, i));
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j]==1) continue;
                max = Math.max(bfs(j,i), max);
            }
        }
        System.out.println(max);
    }

    private static int bfs(int x, int y) {
        int[][] visited = new int[map.length][map[0].length];
        for (int[] a : visited) {
            Arrays.fill(a, -1);
        }
        int[] dx = new int[]{-1, 0, 1, 0, -1, -1, 1, 1};
        int[] dy = new int[]{0, 1, 0, -1, 1, -1, 1, -1};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[y][x] = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 8; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];
                if (nextX < 0 || nextY < 0 || nextX >= map[0].length || nextY >= map.length) continue;
                if (visited[nextY][nextX] != -1) continue;
                if (map[nextY][nextX] == 1) return visited[now[1]][now[0]] + 1;
                visited[nextY][nextX] = visited[now[1]][now[0]] + 1;
                queue.offer(new int[]{nextX, nextY});
            }
        }
        return 0;
    }

    static class Shark {
        int x;
        int y;

        public Shark(int x, int y) {
            this.x = x;
            this.y = y;
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
