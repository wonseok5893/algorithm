package implement;


import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj10866 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        DequeImpl<Integer> deque = new DequeImpl();
        int n = sc.nextInt();
        while (n-- > 0) {
            String oper = sc.next();
            if (oper.contains("push")) {
                int add = sc.nextInt();
                if (oper.contains("front")) {
                    deque.push_front(add);
                } else {
                    deque.push_back(add);
                }
            } else {
                switch (oper) {
                    case "pop_front": {
                        Integer pop = deque.pop_front();
                        if (pop == null) System.out.println(-1);
                        else System.out.println(pop);
                        break;
                    }
                    case "pop_back": {
                        Integer pop = deque.pop_back();
                        if (pop == null) System.out.println(-1);
                        else System.out.println(pop);
                        break;
                    }
                    case "size": {
                        System.out.println(deque.size);
                        break;
                    }
                    case "empty": {
                        System.out.println(deque.isEmpty());
                        break;
                    }
                    case "front": {
                        Integer front = deque.get_front();
                        if (front == null) System.out.println(-1);
                        else System.out.println(front);
                        break;
                    }
                    case "back": {
                        Integer back = deque.get_back();
                        if (back == null) System.out.println(-1);
                        else System.out.println(back);
                        break;
                    }
                }
            }
        }

    }

    static class DequeImpl<T> {
        int size;
        Node<T> front;
        Node<T> back;

        public void push_front(T data) {
            if (size == 0) {
                front = new Node(data, null);
                back = front;
            } else {
                Node first = new Node(data, null);
                first.next = front;
                front.before = first;
                front = first;
            }
            size++;
        }

        public void push_back(T data) {
            if (size == 0) {
                front = new Node(data, null);
                back = front;
            } else {
                Node back = new Node(data, null);
                back.before = this.back;
                this.back.next = back;
                this.back = back;
            }
            size++;
        }

        Deque<Integer> deque = new LinkedList<>();

        public T pop_front() {
            if (size == 0) return null;
            T ret = front.value;
            if (size > 1)
                front.next.before = null;
            front = front.next;
            size--;
            return ret;
        }

        public T pop_back() {
            if (size == 0) return null;
            T ret = back.value;
            if (size > 1) {
                back.before.next = null;
            }
            back = back.before;
            size--;
            return ret;

        }

        public int isEmpty() {
            return size == 0 ? 1 : 0;
        }

        public T get_front() {
            if (size == 0) return null;
            return front.value;
        }

        public T get_back() {
            if (size == 0) return null;
            return back.value;
        }

        static class Node<T> {
            T value;
            Node<T> next;
            Node<T> before;

            public Node(T value, Node<T> next) {
                this.value = value;
                this.next = next;
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
