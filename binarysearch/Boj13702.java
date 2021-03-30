package binarysearch;

import java.io.*;
import java.util.StringTokenizer;

public class Boj13702 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        int max = -1;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);
        }
        int ans = 1;
        int start = 1;
        int end = max;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (determine(arr, mid, k)) {
                start = mid + 1;
                ans = mid;
            } else {
                end = mid-1;
            }
        }
        System.out.println(ans);


    }

    private static boolean determine(int[] arr, int mid,int k) {
        int sum = 0;
        for (int e : arr) {
            sum += e / mid;
        }
        return sum>=k;
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
