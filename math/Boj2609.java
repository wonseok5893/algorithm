package math;

import java.io.*;
import java.util.StringTokenizer;

public class Boj2609 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int gcd = Gcd(a, b);
        System.out.println(gcd);
        System.out.println(Lcm(a,b, gcd));
    }

    private static int Lcm(int a, int b,int G) {
        return a * b / G;
    }

    private static int Gcd(int a, int b) {
        if (a >= b) {
            if(a%b==0)return b;
            return Gcd(a % b, b);
        }
        return Gcd(b, a);
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
