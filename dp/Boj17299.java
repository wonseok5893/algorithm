package dp;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj17299 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int[] arr = new int[n];
        Map<Integer, Integer> cnt = new HashMap<>();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if(cnt.get(arr[i])==null) cnt.put(arr[i], 1);
            else cnt.put(arr[i], cnt.get(arr[i]) + 1);
        }
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < n; i++) {
            if(stack.isEmpty()) stack.push(i);
            while (!stack.isEmpty() && cnt.get(arr[stack.peek()]) < cnt.get(arr[i])) {
                ans[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            ans[stack.pop()] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(ans[i] + " ");
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
