package implement;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1157 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        String s = sc.next();
        s =s.toLowerCase();
        int[] cnt = new int[256];
        char[] arr = s.toCharArray();
        for (char c : arr) {
            cnt[c]++;
        }
        int max = 0;
        char ans = 0;
        for (int i = 0; i < 256; i++) {
            if(max<=cnt[i]) {
                max = cnt[i];
                ans = (char)i;
            }
        }
        int count = 0;
        for (int i = 0; i < 256; i++) {
            if(max==cnt[i])count++;
        }
        if(count<=1) System.out.println(Character.toUpperCase(ans));
        else System.out.println("?");

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
