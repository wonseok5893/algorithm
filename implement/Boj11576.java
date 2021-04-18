package implement;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj11576 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int a = sc.nextInt();
        int b = sc.nextInt();

        int m = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < m; i++) {
            stack.push(sc.nextInt());
        }
        int k = 0;
        int mul =1;
        while (!stack.isEmpty()) {
            k+=mul*stack.pop();
            mul *= a;
        }

        while (k >= b) {
            stack.push(k % b);
            k /= b;
        }
        stack.push(k);

        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()+" ");
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
