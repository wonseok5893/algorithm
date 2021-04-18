package backtracking;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj14889 {
    static int ans = (int) 2e9;
    static int[][] map;
    static int total;

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        // i와 j는 한팀이 되면 번호가 작은 [i][j]로 조회
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                map[i][j] += map[j][i];
            }
        }

        // n 명중 n/2뽑아야함
        bactracking(n, -1, new ArrayList<Integer>());

        System.out.println(ans);

    }

    private static void bactracking(int n, int start, ArrayList<Integer> lists) {
        if (lists.size() == n / 2) {
            boolean[] visit = new boolean[n];
            int sumA = 0;
            for (int i = 0; i < lists.size(); i++) {
                for (int j = i + 1; j < lists.size(); j++) {
                    sumA += map[lists.get(i)][lists.get(j)];
                }
            }
            ArrayList<Integer> linkList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if(!lists.contains(i)) linkList.add(i);
            }
            int sumB = 0;
            for (int i = 0; i < linkList.size(); i++) {
                for (int j = i + 1; j < linkList.size(); j++) {
                    sumB += map[linkList.get(i)][linkList.get(j)];
                }
            }
            int abs = Math.abs(sumA - sumB);
            if (ans > abs)
                ans = abs;
                return;
        }
        for (int i = start + 1; i < n; i++) {
            lists.add(i);
            bactracking(n, i, lists);
            lists.remove(new Integer(i));
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
