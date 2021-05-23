package baekjoon가희1회대회;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Num3 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        int n = sc.nextInt();
        PriorityQueue<Prosess> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            queue.offer(new Prosess(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (t-- > 0) {
            Prosess pop = queue.poll();
            ans.add(pop.id);
            pop.remT--;
            pop.val--;
            if (pop.remT > 0) queue.offer(pop);
        }
        StringBuilder sb = new StringBuilder();
        for (Integer e : ans) {
            sb.append(e + "\n");
        }
        System.out.println(sb);
    }

    private static class Prosess implements Comparable<Prosess> {
        int id;
        int remT;
        int val;

        public Prosess(int id, int remT, int val) {
            this.id = id;
            this.remT = remT;
            this.val = val;
        }

        @Override
        public int compareTo(Prosess o) {
            if (val < o.val) return 1;
            else if (val == o.val) {
                return id - o.id;
            }
            return -1;
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
