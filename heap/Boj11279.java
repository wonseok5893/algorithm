package heap;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj11279 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        StringBuffer sb = new StringBuffer();

        Heap heap = new Heap();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();
            if(input==0) {
                int delete = heap.delete();
                if(delete !=-1) sb.append(delete + "\n");
                else sb.append("0\n");
            } else heap.insert(input);
        }
        System.out.println(sb);
    }

    static class Heap {
        int size;
        ArrayList<Integer> lists;

        public Heap() {
            lists = new ArrayList<>();
            lists.add(new Integer(0));
        }

        public void insert(Integer val) {
            lists.add(val);
            size++;
            int p = size;
            while (p > 1 && lists.get(p / 2) < lists.get(p)) {
                int temp = lists.get(p / 2);
                lists.set(p / 2, lists.get(p));
                lists.set(p, temp);
                p /= 2;
            }
        }

        public int delete() {
            if (size ==0) return -1;
            int ret = lists.get(1);

            lists.set(1,lists.get(size));
            lists.remove(size);
            size--;

            int pos = 1;
            while (pos * 2 <= size) {
                int swapPos = pos * 2;
                if (pos * 2 + 1 <= size) {
                    int rightPos = swapPos + 1;
                    if (lists.get(swapPos) < lists.get(rightPos)) {
                        swapPos = rightPos;
                    }
                }
                if (lists.get(pos) > lists.get(swapPos)) break;

                int temp = lists.get(pos);
                lists.set(pos, lists.get(swapPos));
                lists.set(swapPos, temp);
                pos = swapPos;
            }
            return ret;
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
