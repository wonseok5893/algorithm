package queue;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj10845 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        StringBuffer sb = new StringBuffer();
        QueueImpl<Integer> queue = new QueueImpl<>();
        int n = sc.nextInt();
        while (n-- > 0) {
            String oper = sc.next();
            if (oper.equals("push")) {
                int add = sc.nextInt();
                queue.push(add);
            }else {
                switch (oper) {
                    case "pop": {
                        Integer pop = queue.pop();
                        if (pop == null) sb.append(-1 + "\n");
                        else sb.append(pop + "\n");
                        break;
                    }
                    case "size": {
                        sb.append(queue.size() + "\n");
                        break;
                    }
                    case "empty": {
                        sb.append(queue.empty() + "\n");
                        break;
                    }
                    case "front": {
                        Integer front = queue.front();
                        if(front==null) sb.append(-1 + "\n");
                        else sb.append(front + "\n");
                        break;
                    }
                    case "back": {
                        Integer back = queue.back();
                        if(back==null) sb.append(-1 + "\n");
                        else sb.append(back + "\n");
                        break;
                    }
                }
            }
        }
        System.out.println(sb);
    }

    static class QueueImpl<T> {
        int size;
        Node<T> peek;
        Node<T> top;

        public void push(T add){
            if(peek==null){
                peek = new Node(add, null);
                top = peek;
            }else{
                top.next = new Node(add, null);
                top = top.next;
            }
            size++;
        }
        public T pop(){
            if(size==0)return null;
            T res = peek.value;
            peek = peek.next;
            size--;
            return res;
        }
        public T front(){
            if(size==0)return null;
            return peek.value;
        }
        public T back(){
            if(size==0)return null;
            return top.value;
        }
        public int empty(){
            if(size==0)return 1;
            return 0;
        }
        public int size(){
            return size;
        }
        static class Node<T>{
            T value;
            Node<T> next;

            public Node(T value, Node<T> next) {
                this.value = value;
                this.next = null;
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
