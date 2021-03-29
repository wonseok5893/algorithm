package binarysearch;

import java.io.*;
import java.util.*;

public class Boj1300 {
    static int N,M;
    static int[]A;
    static FastReader s = new FastReader();
    public static void main(String[] args) {
        // 공간복잡도 문제가 있을것 같은데
        // O(N^2)
        N = s.nextInt();
        M = s.nextInt();

        int start = 0, end = M;
        int ans = N;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (determination(mid)) {
                ans = mid;
                end = mid-1;
            }else start = mid+1;
        }
        System.out.println(ans);
    }
    // 1 2 3
    // 2 4 6
    // 3 6 9

    private static boolean determination(int mid) {
        int cnt = 0;
        for(int i=1;i<=N;i++){
            cnt += Math.min(mid / i, N);
        }
        return cnt >= M;
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
