package dfs;

import java.io.*;
import java.util.*;

public class Boj11559 {
    static char[][] map;
    static boolean[][] visited;
    static ArrayList<int[]> res = new ArrayList<>();
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int y = 12;
        int x = 6;
        map = new char[y][x];
        visited = new boolean[y][x];
        ArrayList<int[]> lists = new ArrayList<>();
        for (int i = 0; i < y; i++) {
            char[] arr = sc.next().toCharArray();
            for (int j = 0; j < x; j++) {
                map[i][j] = arr[j];
            }
        }
        int ans = 0;
        boolean start = false;
        do {
            boolean change = false;
            lists.clear();
            findPossible(map, lists);
            for (int i = 0; i < lists.size(); i++) {
                if (visited[lists.get(i)[1]][lists.get(i)[0]]) continue;
                dfs(lists.get(i)[0], lists.get(i)[1]);
                if (cnt.size() >= 4) {
                    change = true;
                    res.addAll(cnt);
                }
                cnt.clear();
            }
            if (change) {
                removeAndMove();
                ans++;
            }
            start = change;
            visited = new boolean[12][6];
        } while (start);
        System.out.println(ans);
    }
    private static void removeAndMove() {
        for (int[] loc : res) {
            map[loc[1]][loc[0]] = '.';
        }
        res.clear();
        Queue<Character> queue = new LinkedList<>();
        for (int j = 0; j < map[0].length; j++) {
            for (int i = map.length - 1; i >= 0; i--) {
                if (map[i][j] != '.') {
                    queue.offer(map[i][j]);
                    map[i][j] = '.';
                }
            }
            int pos = map.length - 1;
            while (!queue.isEmpty()) {
                map[pos--][j] = queue.poll();
            }
        }
    }

    static ArrayList<int[]> cnt = new ArrayList<>();
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    private static void dfs(int x, int y) {
        cnt.add(new int[]{x, y});
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX < 0 || nextY < 0 || nextX >= visited[0].length || nextY >= visited.length) continue;
            if (visited[nextY][nextX]) continue;
            if (map[nextY][nextX] == map[y][x])
                dfs(nextX, nextY);
        }
    }

    private static void findPossible(char[][] map, ArrayList<int[]> lists) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] != '.') lists.add(new int[]{j, i});
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
