package implement;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj17298 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        int[] N = new int[n+1];
        for (int i = 1; i <=n ; i++) {
            arr[i] = sc.nextInt();
        }
        // 인덱스를 저장할 스택
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        for (int i = 2; i <= n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                N[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) N[stack.pop()] = -1;
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <=n ; i++) {
            sb.append(N[i] + " ");
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
