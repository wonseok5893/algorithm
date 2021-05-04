package math;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj17425 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();

        long[] g = new long[1000001];
        long[] f = new long[1000001];
        Arrays.fill(f, 1);
        for (int i = 2; i <=1000000 ; i++) {
            for (int j = 1; i*j <=1000000 ; j++) {
                f[i*j]+=i;
            }
        }
        g[1] = 1;
        for (int i = 2; i <= 1000000; i++) {
            g[i] = g[i - 1] + f[i];// i의 약수의 합
        }

        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = sc.nextInt();
            sb.append(g[n]+"\n");
        }
        System.out.println(sb);
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
