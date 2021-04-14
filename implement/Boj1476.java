package implement;

import java.io.*;
import java.util.StringTokenizer;

public class Boj1476 {
    public static void main(String[] args) {
        // 1 1 1 -> 1
        // 2 2 2 -> 2
        // 1 16 16 -> 16
        // 4 19 19 -> 19
        // 5 20 1 0> 20
        int E = 1;
        int S = 1;
        int M = 1;
        FastReader sc = new FastReader();
        int tartgetE = sc.nextInt();
        int tartgetS = sc.nextInt();
        int tartgetM = sc.nextInt();

        int year =1;
        while(true){
            if(E==tartgetE&&tartgetM==M&&S==tartgetS)break;
            E = increment("E",E);
            S = increment("S",S);
            M = increment("M",M);
            year++;
        }
        System.out.println(year);

    }

    private static int increment(String e, int value) {
        switch(e){
            case "E":{
                if(value==15)return 1;
                break;
            }
            case "S":{
                if(value==28)return 1;
                break;
            }
            case "M":{
                if(value==19)return 1;
                break;
            }
        }
        return value+1;
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
