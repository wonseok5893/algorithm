package math;

import java.io.*;
import java.util.StringTokenizer;

public class Boj6588 {
    static boolean[] prime;
    static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        prime = new boolean[1000001];
        prime[1] = true;
        for (int i = 2; i <prime.length; i++) {
            if(!prime[i]){
                for (int j = 2; (i*j)<prime.length; j++) {
                    prime[i*j] = true;
                }
            }
        }
        while (true) {
            int n = sc.nextInt();
            if(n==0)break;
            solution(n);
        }
        System.out.println(sb);
    }

    private static void solution(int n) {
        for (int i = 3; i <= n / 2; i+=2) {
            if (!prime[i]) {
                if (!prime[n - i]) {
                    sb.append(n + " = " + i + " + " + (n - i) + "\n");
                    break;
                }
            }
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
