package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj20311 {
    //화학실험
    //https://www.acmicpc.net/problem/20311

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(
                System.in
        ));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        PriorityQueue<Flask> queue = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= k; i++) {
            queue.offer(new Flask(i, Integer.parseInt(st.nextToken())));
        }
        // 1 3
        LinkedList<Integer> list = new LinkedList<>();
        Flask poll = queue.poll();
        for (int i = 0; i < poll.count; i++) {
            list.add(poll.idx);
        }
        boolean first = true;
        boolean result = true;
        while (!queue.isEmpty()) {
            Flask next = queue.poll();
            if(first) {
                if (next.count < list.size() - 1) {
                    result = false;
                    break;
                }
                first = false;
            }
            if (next.count > list.size() + 1 ) {
                result = false;
                break;
            }
            int countA = 0;

            if (next.count == list.size()) {
                list.addFirst(next.idx);
                countA =1;
            }
            else if (next.count == list.size() + 1) {
                list.addFirst(next.idx);
                list.addLast(next.idx);
                countA =2;
            }

            int pos = 2;
            for (int i = 0; i < next.count-countA; i++) {
                list.add(pos, next.idx);
                pos+=2;
            }

        }
        String str = "";
        if (!result) System.out.println(-1);
        else {
            for (int i = 0; i < list.size(); i++) {
                str += list.get(i)+" ";
            }
            System.out.println(str);
        }

    }

    private static class Flask implements Comparable<Flask> {
        int idx;
        int count;

        public Flask(int idx, int count) {
            this.idx = idx;
            this.count = count;
        }

        @Override
        public int compareTo(Flask o) {
            return count - o.count;
        }
    }
}
