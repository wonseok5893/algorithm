package backtracking;

import java.io.*;
import java.util.*;

public class Boj16955 {
    static boolean[][] visit;
    static int[] dx = new int[]{-1, 1, 0, 0, -1, 1, 1, -1};
    static int[] dy = new int[]{0, 0, 1, -1, 1, -1, 1, -1};
    // 좌 아래 오 위

    static char[][] map;

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        map = new char[10][10];
        visit = new boolean[10][10];
        ArrayList<int[]> guList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            char[] arr = sc.nextLine().toCharArray();
            for (int j = 0; j < 10; j++) {
                map[i][j] = arr[j];
                if (map[i][j] == 'X') guList.add(new int[]{j, i});
            }
        }
        boolean ans = false;
        loop:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (map[i][j] != '.') continue;
                if (!checkLoc(j, i)) continue;
                map[i][j] = 'X';
                if (checkFive(j, i)) {
                    ans = true;
                    break loop;
                }
                map[i][j] = '.';
            }
        }
        if (ans) System.out.println(1);
        else System.out.println(0);
    }

    private static boolean checkFive(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < 8; i += 2) {
            int cnt = 1;
            visit[y][x] = true;
            queue.offer(new int[]{x, y});
            while (!queue.isEmpty()) {
                int[] now = queue.poll();
                for (int j = 0; j < 2; j++) {
                    int nextX = now[0] + dx[i + j];
                    int nextY = now[1] + dy[i + j];
                    if (nextX < 0 || nextY < 0 || nextX >= visit[0].length || nextY >= visit.length) continue;
                    if (visit[nextY][nextX]) continue;
                    if (map[nextY][nextX] != 'X') continue;
                    queue.offer(new int[]{nextX, nextY});
                    visit[nextY][nextX] = true;
                    cnt++;
                }
            }
            if (cnt >= 5) return true;
            visit = new boolean[10][10];
        }
        return false;
    }

    private static void printVisit() {
        for (boolean[] chars : visit) {
            System.out.println(Arrays.toString(chars));
        }
        System.out.println();
    }
    private static void printMap() {
        for (char[] chars : map) {
            System.out.println(Arrays.toString(chars));
        }
        System.out.println();
    }

    private static boolean checkLoc(int x, int y) {
        for (int i = 0; i < 8; i++) {
            int nX = x + dx[i];
            int nY = y + dy[i];
            if (nX < 0 || nY < 0 || nX >= visit[0].length || nY >= visit[0].length) continue;
            if (map[nY][nX] == 'X') return true;
        }
        return false;
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
