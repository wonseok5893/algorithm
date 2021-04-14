package dp;

import java.io.*;
import java.util.StringTokenizer;

public class Boj1309 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();

        int[][] dp = new int[n + 1][3];

        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                switch(j){
                    case 0:{
                        dp[i][j] = ((dp[i - 1][0] + dp[i - 1][1])%9901 + dp[i - 1][2])%9901;
                        break;
                    }
                    case 1:{
                        dp[i][j] = (dp[i - 1][0] + dp[i - 1][2])%9901;
                        break;
                    }
                    case 2:{
                        dp[i][j] = (dp[i - 1][0] + dp[i - 1][1])%9901;
                        break;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 3; i++) {
            ans = (ans +dp[n][i])%9901;
        }
        System.out.println(ans);
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
