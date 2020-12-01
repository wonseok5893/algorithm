package greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Programmers214131 {
    public static void main(String[] args) {
        solution(4, new int[]{4, 3, 3});
    }

    public static long solution(int n, int[] works) {

        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        for (int e : works) {
            queue.offer(e);
        }
        while (n > 0) {
            if (!queue.isEmpty()) {
                Integer poll = queue.poll();
                System.out.println(poll);
                poll--;
                n--;
                if (poll > 0) {
                    queue.offer(poll);
                } else return 0;
            } else return 0;
        }
        long result = 0;
        while (!queue.isEmpty()) {
            result += (long) Math.pow(queue.poll(), 2);
        }
        return result;
    }
}
