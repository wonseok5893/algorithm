package queue;



import java.io.*;
import java.util.StringTokenizer;

public class Boj1158 {

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        CircularQueue<Integer> queue = new CircularQueue<>();
        int n = sc.nextInt();
        int k = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            queue.addNode(i);
        }
        StringBuffer sb = new StringBuffer();
        sb.append("<");
        while (n-- > 0) {
            sb.append(queue.getAndRemoveByIndex(k)+", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(">");
        System.out.println(sb);
    }

    static class CircularQueue<T> {
        Node<T> root;
        Node<T> endNode;
        int size;

        public void addNode(T e) {
            if (root == null) {
                root = new Node<>(e);
                endNode = root;
            } else {
                endNode.next = new Node<>(e);
                endNode = endNode.next;
                endNode.next = root;
            }
            size++;
        }

        public T getAndRemoveByIndex(int idx) {
            Node<T> now = root;
            Node<T> front = root.next;
            Node<T> back = root;
            int cnt = size;
            while (--cnt > 0) {
                back = back.next;
            }
            while (--idx > 0) {
                now = now.next;
                back = back.next;
                front = front.next;
            }
            T ret = now.value;
            back.next = front;
            this.size--;
            this.root = front;
            return ret;
        }


    }

    static class Node<T> {
        T value;
        Node next;

        public Node(T value) {
            this.value = value;
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
