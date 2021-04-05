package trie;

import java.io.*;
import java.util.*;

public class Boj14425 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<String> S = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            S.add(str);
        }
        Collections.sort(S);
        int ans = 0;
        for (int i = 0; i < m; i++) {
            String target = sc.next();
            if(binarySearch(S, target))
                ans++;
        }
        System.out.println(ans);
    }

    private static boolean binarySearch(ArrayList<String> s, String target) {
        int start = 0;
        int end = s.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int compare = s.get(mid).compareTo(target);
            if(compare<0){
                start = mid+1;
            }else{
                if(compare==0)return true;
                end = mid-1;
            }
        }
        return false;
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
