package implement;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj17103 {
    static boolean[] prime = new boolean[1000001];
    static ArrayList<Integer> primes = new ArrayList<>();

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = true;
        for (int i = 2; i <= 1000000; i++) {
            if (prime[i]) {
                for (int j = 2; i * j <= 1000000; j++) {
                    prime[i * j] = false;
                }
            }
        }
        for (int i = 2; i <= 1000000; i++) {
            if (prime[i]) primes.add(i);
        }
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            solution(n);
        }
    }

    private static void solution(int n) {
        int ans = 0;
        for (int i = 0; i < primes.size(); i++) {
            if(primes.get(i)>n)break;
            if(n- primes.get(i)<primes.get(i))break;
            if(prime[n-primes.get(i)])ans++;
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
