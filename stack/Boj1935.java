package stack;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj1935 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        Stack<Double> stack = new Stack<>();
        Map<String, Integer> map = new HashMap<>();
        String str = sc.next();
        int pos = 65;
        for (int i = 0; i < n; i++) {
            String key = String.valueOf((char) (pos + i));
            map.put(key, sc.nextInt());
        }
        String[] strArr = str.split("");
        for (String s : strArr) {
            char c = s.charAt(0);
            if (Character.isAlphabetic(c)) {
                stack.push((double)map.get(s));
            } else {
                calc(s, stack);
            }
        }
        System.out.printf(String.format("%.2f",stack.pop()));
    }

    private static void calc(String oper, Stack<Double> stack) {
        Double a = stack.pop();
        Double b = stack.pop();
        switch (oper){
            case"*":{
                stack.push(a * b);
                break;
            }
            case"+":{
                stack.push(a + b);
                break;
            }
            case"-":{
                stack.push(b-a);
                break;
            }
            case"/":{
                stack.push(b/a);
                break;
            }
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
