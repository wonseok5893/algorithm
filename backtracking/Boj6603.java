package backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class Boj6603 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            combination(arr, -1, 0, new StringBuffer());
            System.out.println();
        }
    }

    private static void combination(int[] arr, int start, int cnt, StringBuffer sb) {
        if (cnt == 6) {
            System.out.println(sb);
            return;
        }
        for (int i = start + 1; i < arr.length; i++) {
            boolean minus = false;
            if (arr[i] >= 10) minus = true;
            sb.append(arr[i] + " ");
            combination(arr, i, cnt + 1, sb);
            if (minus)
                sb.delete(sb.length() - 3, sb.length());
            else
                sb.delete(sb.length() - 2, sb.length());
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
