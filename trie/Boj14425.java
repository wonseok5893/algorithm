package trie;

import java.io.*;
import java.util.*;

public class Boj14425 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int k = 240001;
        int n = 1000000;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            ans.add(i);
        }
        Collections.sort(ans, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int a = findMinMax(o1);
                int b = findMinMax(o2);
                if(a < b){
                    return 1;
                }else if(a==b){
                    return o2-o1;
                }
                return -1;
            }
        });
        System.out.println(ans.get(k-1));
    }

    private static int findMinMax(int i) {
        for (int j = 2; j <=i; j++) {
            if (i % j == 0) {
                return j;
            }
        }
        return -1;
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
