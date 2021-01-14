package com.wonseok.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers42587 {
    public static void main(String[] args) {
        System.out.println(new Programmers42587().solution(new int[]{2,1,3,2},2));
    }

    public int solution(int[] priorities, int location) {
        Queue<Task> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Task(i, priorities[i]));
        }
        Task[] ans = new Task[priorities.length];
        int pos = 0;
        while (!queue.isEmpty()) {
            Task task = queue.poll();
            if (task.value < findMax(queue, queue.size())) {
                queue.offer(task);
            } else {
                ans[pos++] = task;
            }
        }
        for (int i = 0; i < ans.length; i++) {
            if(ans[i].idx==location) return i;
        }
        return 0;
    }

    public int findMax(Queue<Task> queue, int size) {
        int max = -1;
        while (size > 0) {
            Task task = queue.poll();
            max = Math.max(max, task.value);
            queue.offer(task);
            size--;
        }
        return max;
    }

    private class Task {
        int idx;
        int value;

        Task(int idx, int value) {
            idx = idx;
            value = value;
        }
    }
}
