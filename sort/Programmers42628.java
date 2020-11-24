package sort;

import java.util.Collections;
import java.util.PriorityQueue;

public class Programmers42628 {
    //이중 우선순위 큐
    public static void main(String[] args) {

    }

    public int[] solution(String[] operations) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        PriorityQueue<Integer> reverseQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < operations.length; i++) {
            String[] command = operations[i].split(" ");

            int num = Integer.parseInt(command[1]);
            if (command[0].equals("I")) {
                queue.offer(num);
            } else {
                if (command[1].equals("1")) {
                    //최댓값 삭제
                    if (queue.size() == 0) continue;
                    while (!queue.isEmpty()) {
                        reverseQueue.offer(queue.poll());
                    }
                    reverseQueue.poll();
                    while (!reverseQueue.isEmpty()) {
                        queue.offer(reverseQueue.poll());
                    }
                } else {
                    //최솟값 삭제
                    queue.poll();
                }
            }
        }
        if (queue.size() == 0) {
            return new int[]{0, 0};
        } else {
            int min = queue.poll();
            int size = queue.size();
            int max = min;
            while (!queue.isEmpty()) {
                max = queue.poll();
            }
            return new int[]{max, min};
        }
    }
}

