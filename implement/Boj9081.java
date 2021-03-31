package implement;

import java.io.*;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

public class Boj9081 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            solution(sc.nextLine());
        }
    }

    static String next;

    private static void solution(String str) {
        char[] array = str.toCharArray();
        boolean[] visit = new boolean[array.length];
        next = str;
        first = false;
        next_permutation(array, visit, new StringBuilder());

        System.out.println(next);
        toString(array);
    }
    static boolean first;
    private static String toString(char[] array) {
        StringBuilder sb = new StringBuilder();
        for (char c : array) {
            sb.append(c);
        }
        return sb.toString();
    }
    private static void next_permutation(char[] array, boolean[] visit, StringBuilder sb) {
        if (sb.length() == array.length) {
            if (toString(array).compareTo(sb.toString())< 0) {
                if(!first){
                    next = sb.toString();
                    first = true;
                }else {
                    if (next.compareTo(sb.toString()) > 0)
                        next = sb.toString();
                }
            }
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            sb.append(array[i]);
            next_permutation(array, visit, sb);
            sb.deleteCharAt(sb.length() - 1);
            visit[i] = false;
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
