package dp;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj14002 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        //0~k 포함하는 까지 가장 긴 부분 수열
        int[] dp = new int[n + 1];
        ArrayList<Integer>[] visit = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            visit[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (arr[i - 1] > arr[j - 1]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j]+1;
                        visit[i] = new ArrayList<>();
                        visit[i].addAll(visit[j]);
                        visit[i].add(arr[i - 1]);
                    }
                }
            }
            if(dp[i]==0) {
                dp[i] = 1;
                visit[i].add(arr[i - 1]);
            }
        }
        int maxIdx = -1;
        int max = -1;
        for (int i = 1; i <= n; i++) {
            if (max <= dp[i]) {
                max = dp[i];
                maxIdx = i;
            }
        }
        System.out.println(dp[maxIdx]);

        for (int e : visit[maxIdx]) {
            System.out.print(e+" ");
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
