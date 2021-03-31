package dp;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj9084 {
    public static void main(String[] args) {
        // N 은 20개의 동전 가지
        // M 은 10000개
        FastReader sc = new FastReader();
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] coins = new int[n];
            for (int i = 0; i < n; i++) {
                coins[i] = sc.nextInt();
            }
            int m = sc.nextInt();
            //
            int[] dp = new int[m + 1];
            dp[0] = 1;
            for (int j = 0; j < n; j++) {
                for (int i = 1; i <= m; i++) {
                    if (coins[j] <= i) {
                        dp[i] += dp[i - coins[j]];
                    }
                }
            }
            System.out.println(dp[m]);
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
