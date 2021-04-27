package backtracking;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj1174 {
    static ArrayList<Long> list = new ArrayList<>();
    static int idx = 0;

    public static void main(String[] args) {
        // N번쨰로 작은 줄어드는 수
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int k = 1;
        // k자리의 수 만들수 있는 경우의 수
        int total = 0;
        boolean res = false;
        while (n >= total) {
            if(k>10) {
                res = true;
                break;
            }
            getCnt(k, 0, new StringBuilder());
            if (list.size() >= n) {
                break;
            }
            total = list.size();
            k++;
        }
        if(res) System.out.println(-1);
        else System.out.println(list.get(n - 1));
        // 2
        // n은 백만
        // 1 ->  0
        // 10 -> 9
        // 100 ->
        // 1000 -> 999
    }

    private static void getCnt(int k, int cnt, StringBuilder sb) {
        if (k == cnt) {
            list.add(Long.parseLong(sb.toString()));
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (sb.length() >= 1) {
                int last = Integer.parseInt(sb.substring(sb.length() - 1, sb.length()));
                if (last <= i) continue;
            }
            sb.append(i);
            getCnt(k, cnt + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
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
