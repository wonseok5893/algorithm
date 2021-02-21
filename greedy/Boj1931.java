package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Task> queue = new PriorityQueue<Task>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            queue.offer(new Task(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }

        int possibleStart = 0;
        int count = 0;
        while(!queue.isEmpty()){
            Task now = queue.poll();
            if(now.start>=possibleStart){
                count++;
                possibleStart = now.end;
            }
        }
        System.out.println(count);
    }

    private static class Task implements Comparable<Task> {
        int start;
        int end;

        public Task(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Task o) {
            if(o.end<end) return 1;
            else if(o.end==end){
                if(o.start<start)return 1;
            }
            return -1;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
