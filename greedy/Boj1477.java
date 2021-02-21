package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int addCount = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] gasStations = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            gasStations[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(gasStations);
        PriorityQueue<Integer> queue = new PriorityQueue<>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2-o1;
                    }
                }
        );
        queue.offer(gasStations[0]);
        for (int i = 0; i < n-1; i++) {
            queue.offer(gasStations[i+1]-gasStations[i]);
        }
        queue.offer(end-gasStations[n-1]);

        while(addCount>0&&!queue.isEmpty()){
            int poll = queue.poll();
            if(poll%2==0) {
                queue.offer(poll / 2);
                queue.offer(poll / 2);
            }else{
                queue.offer(poll/2);
                queue.offer(poll/2+1);
            }
            addCount--;
        }

        System.out.println(queue.poll());
    }
}
