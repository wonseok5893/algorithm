package dp;

import java.io.*;
import java.util.StringTokenizer;

public class Boj2225 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int k = sc.nextInt();
        //dp[i][j] 0~i숫자를 j개써서 이 되는 경우의 수
        int[][] dp = new int[n + 1][k+1];
        for (int i = 0; i <= n; i++) {
            dp[i][1] = 1;
        }
        final int mod = (int) 1e9;
        for (int i = 2; i <= k; i++) {
            for (int j = 0; j <= n; j++) {
                for (int l = 0; l <= n; l++) {
                    if (j - l >= 0)
                        dp[j][i] =(dp[j][i]+ dp[j - l][i - 1])%mod;
                }
            }
        }
        System.out.println(dp[n][k]);
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
