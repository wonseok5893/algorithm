package baekjoon가희1회대회;

import java.io.*;
import java.util.StringTokenizer;

public class Num1 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int m = sc.nextInt();

        int gY = sc.nextInt();
        int gX = sc.nextInt();

        int pY = sc.nextInt();
        int pX = sc.nextInt();

        char[][] map = new char[n][m];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            char[] arr = sc.nextLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = arr[j];
                if (map[i][j] == 'P')cnt++;
            }
        }
        if(pY*pX==cnt) System.out.println(0);
        else System.out.println(1);
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
