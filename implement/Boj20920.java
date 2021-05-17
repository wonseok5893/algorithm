package implement;

import java.io.*;
import java.util.*;

public class Boj20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[]info = br.readLine().split(" ");
        int n = Integer.parseInt(info[0]);
        int m = Integer.parseInt(info[1]);

        Map<String, Integer> cnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if(str.length()<m) continue;
            if (cnt.get(str) == null) cnt.put(str, 1);
            else cnt.put(str, cnt.get(str) + 1);
        }
        ArrayList<String> lists = new ArrayList<>(cnt.keySet());
        lists.sort((o1,o2)->{
            if(cnt.get(o1)<cnt.get(o2))return 1;
            else if(cnt.get(o1)==cnt.get(o2)){
                if(o1.length()<o2.length())return 1;
                else if(o1.length()==o2.length()){
                    return o1.compareTo(o2);
                }
            }
            return -1;
        });
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (String s : lists) {
            bw.write(s + "\n");
        }
        bw.flush();
        bw.close();
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
