package dp;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj16194 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] dp = new int[n + 1];
        //dp[k] k카드를 구매하기위한 최소 비용
        for (int i = 1; i <= n; i++) {
            //j까지 쓸때
            for (int j = 1; j <= n; j++) {
                if (j >= i) {
                    if (dp[j] == 0)
                        dp[j] = dp[j - i] + arr[i - 1];
                    else dp[j] = Math.min(dp[j], dp[j - i] + arr[i - 1]);
                }
            }
        }
        System.out.println(dp[n]);
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
