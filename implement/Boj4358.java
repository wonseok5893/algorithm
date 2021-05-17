package implement;

import java.io.*;
import java.util.*;

public class Boj4358 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        Map<String, Integer> cnt = new HashMap<>();
        double total = 0;
        while (true) {
            String str = sc.nextLine();
            if (str==null||str.length() == 0) break;
            total++;
            if (cnt.get(str) == null)
                cnt.put(str, 1);
            else cnt.put(str, cnt.get(str) + 1);
        }
        ArrayList<String> ans = new ArrayList<>(cnt.keySet());
        Collections.sort(ans);
        StringBuilder sb = new StringBuilder();
        for (String s : ans) {
            double d = cnt.get(s) / total*100;
            sb.append(s + " " +String.format("%.4f",d)+"\n");
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
