package stack;

import java.io.*;
import java.util.Objects;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj10828 {
    public static void main(String[] args) {
        StackImpl<Integer> stack = new StackImpl<>();
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        while (n-- > 0) {
            String oper = sc.next();
            if(oper.equals("push")){
                int add = sc.nextInt();
                stack.push(add);
            }
            switch (oper){
                case "top":{
                    Integer peek = stack.peek();
                    System.out.println(peek==null ?-1:peek);
                    break;
                }
                case "size":{
                    System.out.println(stack.size);
                    break;
                }
                case "empty":{
                    if(stack.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                    break;
                }
                case "pop":{
                    Integer pop = stack.pop();
                    System.out.println(pop==null?-1:pop);
                    break;
                }
            }
        }
    }
    static class StackImpl<T>{
        Object[] objects = new Object[100001];
        int size;

        public boolean isEmpty(){
            if(size>0)return false;
            return true;
        }

        public T peek(){
            if(size==0)return null;
            return (T)objects[size-1];
        }
        public T pop(){
            if(size==0)return null;
            T ret = (T)objects[size-1];
            objects[size - 1] = null;
            size--;
            return ret;
        }
        public void push(T add) {
            objects[size] = add;
            size++;
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
